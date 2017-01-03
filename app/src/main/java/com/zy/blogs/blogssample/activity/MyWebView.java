package com.zy.blogs.blogssample.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.JavascriptInterface;
import android.webkit.MimeTypeMap;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.zy.blogs.blogssample.R;

/**
 * <p/>
 * 作者：zhouyuan on  2016/7/28 13:51
 * <p/>
 * 邮箱：244370114@qq.com
 * <p/>
 */
public class MyWebView extends Activity {

    private ScorllWebView webview;
    private Button button;
    private long exitTime = 0;

    @SuppressLint("AddJavascriptInterface")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_webview);
        webview = (ScorllWebView) findViewById(R.id.webview);
        button = (Button) findViewById(R.id.button);

//        webview.getSettings().setJavaScriptEnabled(true);
//        webview.addJavascriptInterface(new WebHeight(), "webHeight");
//        webview.loadUrl("file:///android_asset/demo.html");
//        webview.setWebChromeClient(new WebChromeClient() {
//
//            @Override
//            public void onReceivedIcon(WebView view, Bitmap icon) {
//                super.onReceivedIcon(view, icon);
//            }
//
//            @Override
//            public void onReceivedTitle(WebView view, String title) {
//                super.onReceivedTitle(view, title);
//            }
//        });
//
//        webview.setWebViewClient(new WebViewClient() {
//            //在webview里打开新链接
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
////                view.loadUrl(url);
//                return false;
//            }
//        });

        initData();
        WebSettings webSettings = webview.getSettings();
        //①设置WebView允许调用js
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDefaultTextEncodingName("UTF-8");
        //②将object对象暴露给Js,调用addjavascriptInterface
//        webview.addJavascriptInterface(new MyObject(MyWebView.this), "myObj");
        webview.addJavascriptInterface(new WebHeight(), "webHeight");
        webview.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                System.out.println("view = [" + view + "], url = [" + url + "]");
                return true;
            }
        });
        webview.loadUrl("file:///android_asset/test.html");
    }

    private void initData() {
        Intent intent = getIntent();
        String action = intent.getAction();
        String scheme = intent.getScheme();
        Uri uri = intent.getData();
        System.out.println("action:" + action);
        System.out.println("scheme:" + scheme);
        if (uri != null) {
            String host = uri.getHost();
            String dataString = intent.getDataString();
            String id = uri.getQueryParameter("id");
            String name = String.valueOf(uri.getQueryParameters("name"));
            String age = uri.getQueryParameter("age");
            String path = uri.getPath();
            String path1 = uri.getEncodedPath();
            String queryString = uri.getQuery();
            System.out.println("host:" + host);
            System.out.println("dataString:" + dataString);
            System.out.println("id:" + id);
            System.out.println("name:" + name);
            System.out.println("age:" + age);
            System.out.println("path:" + path);
            System.out.println("path1:" + path1);
            System.out.println("queryString:" + queryString);
        }

        button.setOnClickListener(v -> startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("test://login/123123123"))));
    }


    //我们需要重写回退按钮的时间,当用户点击回退按钮：
    //1.webView.canGoBack()判断网页是否能后退,可以则goback()
    //2.如果不可以连续点击两次退出App,否则弹出提示Toast
    @Override
    public void onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack();
        } else {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序",
                        Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                super.onBackPressed();
            }
        }
    }

    class WebHeight {
        @JavascriptInterface
        public void resize(final String height) {
            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    float heightf = Float.parseFloat(height);
                    webview.setLayoutParams(new FrameLayout.LayoutParams(getResources().getDisplayMetrics().widthPixels,
                            (int) (heightf * getResources().getDisplayMetrics().density)));
                    System.out.println("ssssssssssss");
                    Toast.makeText(MyWebView.this, "heightf = " + heightf, Toast.LENGTH_SHORT).show();
                    String videoPath = "http://ohv2zr6ee.bkt.clouddn.com/video1.mp4";
                    String extension = MimeTypeMap.getFileExtensionFromUrl(videoPath);
                    String mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.parse(videoPath), mimeType);
                    startActivity(intent);
                }
            });
        }
    }
}

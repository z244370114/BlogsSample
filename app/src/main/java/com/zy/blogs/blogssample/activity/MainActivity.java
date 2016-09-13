package com.zy.blogs.blogssample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.ImageView;

import com.zy.blogs.blogssample.R;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class MainActivity extends AppCompatActivity {

    private ImageView iv_upfile;
    private Button btn_upfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        iv_upfile = (ImageView) findViewById(R.id.iv_upfile);
        btn_upfile = (Button) findViewById(R.id.btn_upfile);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        btn_upfile.setOnClickListener(v -> {
            File file = new File("/mnt/sdcard/DCIM/camera/1111.jpg");
            RequestBody body =
                    RequestBody.create(MediaType.parse("multipart/form-data"), file);

        });
    }


}

package com.zy.blogs.blogssample.activity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.blankj.utilcode.utils.ImageUtils;
import com.blankj.utilcode.utils.SDCardUtils;
import com.blankj.utilcode.utils.SizeUtils;
import com.makeramen.roundedimageview.RoundedImageView;
import com.zy.blogs.blogssample.R;
import com.zy.blogs.blogssample.mvp.MvpActivity;
import com.zy.blogs.blogssample.mvp.main.ModifyMyInfyPresenter;
import com.zy.blogs.blogssample.mvp.main.ModifyMyInfyView;

import java.io.File;
import java.util.List;

import butterknife.Bind;
import okhttp3.MediaType;
import okhttp3.RequestBody;


/**
 * <p/>
 * 作者：zhouyuan on  2016/9/23 17:33
 * <p/>
 * 邮箱：244370114@qq.com
 * <p/>
 */
public class ModifyMyInfoActivity extends MvpActivity<ModifyMyInfyPresenter> implements ModifyMyInfyView {

    @Bind(R.id.iv_avatar)
    RoundedImageView ivAvatar;
    @Bind(R.id.tv_username)
    TextView tvUsername;
    @Bind(R.id.tv_post)
    TextView tvPost;
    @Bind(R.id.tv_corporation)
    TextView tvCorporation;
    @Bind(R.id.tv_recommend)
    TextView tvRecommend;
    @Bind(R.id.tv_blogs_address)
    TextView tvBlogsAddress;
    @Bind(R.id.rl_avatar)
    RelativeLayout rlAvatar;
    @Bind(R.id.rl_username)
    RelativeLayout rlUsername;
    @Bind(R.id.rl_post)
    RelativeLayout rlPost;
    @Bind(R.id.rl_corporation)
    RelativeLayout rlCorporation;
    @Bind(R.id.rl_recommend)
    RelativeLayout rlRecommend;
    @Bind(R.id.rl_blogs_address)
    RelativeLayout rlBlogsAddress;
    private Uri photoUri;
    private static final int SELECT_PIC_BY_TACK_PHOTO = 111;
    private static final int SELECT_PIC_BY_PICK_PHOTO = 222;
    private String picPath = "";
    private RequestBody body;
    private String avater_url;
    private static final int CROP_SMALL_PICTURE = 333;

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_modify_my_info, R.string.redact, R.menu.menu_modify_myinfo, MODE_BACK);
        toolbar.setBackgroundColor(getResources().getColor(R.color.white));
        toolbar.setNavigationIcon(R.drawable.icon_back_black);
        toolbar_title.setTextColor(getResources().getColor(R.color.primary_text));
    }

    @Override
    protected void setUpData() {
        rlAvatar.setOnClickListener(v -> new MaterialDialog.Builder(this)
                .items(R.array.items)
                .itemsColor(getResources().getColor(R.color.primary_text))
                .itemsCallback((dialog, view, which, text) -> {
                    switch (which) {
                        case 0:
                            takePhoto();
                            break;
                        case 1:
                            pickPhoto();
                            break;
                    }
                }).show());

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
//        int itemId = item.getItemId();
//        if (itemId == R.id.save) {
        new MaterialDialog.Builder(this)
                .title("提示")
                .content(R.string.content)
                .positiveText(R.string.agree)
                .negativeText(R.string.disagree)
                .onPositive((dialog, which) -> mvpPresenter.modifyUserData("1", "eeeeeeee", avater_url))
                .onNegative((dialog, which) -> dialog.dismiss())
                .show();
//            return true;
//        }
        return super.onMenuItemClick(item);
    }

    /**
     * 选择相册
     */
    private void pickPhoto() {
        Intent intent = new Intent();
        // 如果要限制上传到服务器的图片类型时可以直接写如：image/jpeg 、 image/png等的类型
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, SELECT_PIC_BY_PICK_PHOTO);
    }

    /**
     * 直接拍照
     */
    private void takePhoto() {
        if (SDCardUtils.isSDCardEnable()) {

            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            /***
             * 需要说明一下，以下操作使用照相机拍照，拍照后的图片会存放在相册中的
             * 这里使用的这种方式有一个好处就是获取的图片是拍照后的原图
             * 如果不使用ContentValues存放照片路径的话，拍照后获取的图片为缩略图不清晰
             */
            ContentValues values = new ContentValues();
            photoUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
            intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, photoUri);
            startActivityForResult(intent, SELECT_PIC_BY_TACK_PHOTO);
        } else {
            showToast("内存卡不存在");
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // 点击取消按钮
        if (resultCode == RESULT_CANCELED) {
            return;
        }
        // 可以使用同一个方法，这里分开写为了防止以后扩展不同的需求
        switch (requestCode) {
            case SELECT_PIC_BY_PICK_PHOTO:// 如果是直接从相册获取
                doPhoto(requestCode, data);
                break;
            case SELECT_PIC_BY_TACK_PHOTO:// 如果是调用相机拍照时
                doPhoto(requestCode, data);
                break;
            case CROP_SMALL_PICTURE:
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);

    }


    private void doPhoto(int requestCode, Intent data) {
        // 从相册取图片，有些手机有异常情况，请注意
        if (requestCode == SELECT_PIC_BY_PICK_PHOTO) {
            if (data == null) {
                showToast("选择图片文件出错");
                return;
            }
            photoUri = data.getData();
            if (photoUri == null) {
                showToast("选择图片文件出错");
                return;
            }
        }
        String[] pojo = {MediaStore.MediaColumns.DATA};
        Cursor cursor = getContentResolver().query(photoUri, pojo, null, null, null);
        if (cursor != null) {
            int columnIndex = cursor.getColumnIndexOrThrow(pojo[0]);
            cursor.moveToFirst();
            picPath = cursor.getString(columnIndex);
            // 4.0以上的版本会自动关闭 (4.0--14;; 4.0.3--15)
            if (Integer.parseInt(Build.VERSION.SDK) < 14) {
                cursor.close();
            }
        }
        if (picPath != null && ImageUtils.isImage(picPath)) {

            Bitmap map = ImageUtils.getBitmap(picPath, SizeUtils.dp2px(this, 50f), SizeUtils.dp2px(this, 50f));
            ivAvatar.setImageBitmap(map);
            File file = new File(picPath);
            body = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            mvpPresenter.updataImage(body);
        }

    }

    @Override
    protected ModifyMyInfyPresenter createPresenter() {
        return new ModifyMyInfyPresenter(this);
    }

    @Override
    public void updateImage(String url) {
        avater_url = url;
    }

    @Override
    public void modifySuccess(List<Integer> data) {
        if (data.get(0) == 1) {
            showToast("修改成功!!!!!!!!");
        }
    }

    @Override
    public void getDataFail(String msg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}

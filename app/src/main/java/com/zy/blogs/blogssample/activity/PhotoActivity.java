package com.zy.blogs.blogssample.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import com.zy.blogs.blogssample.R;
import com.zy.blogs.blogssample.base.BaseActivity;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * <p/>
 * 作者：zhouyuan on  2016/9/27 11:24
 * <p/>
 * 邮箱：244370114@qq.com
 * <p/>
 */

public class PhotoActivity extends BaseActivity {

    private static final int REQ_THUMB = 222;
    private static final int REQ_GALLERY = 333;
    private static final String TAG = "PhotoActivity";
    private static final int REQ_TAKE_PHOTO = 444;
    Button mThumbnail, mFullSize, mAddGallery;
    ImageView mImageView;

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_photo, R.string.photo, -1, MODE_NONE);
    }

    @Override
    protected void setUpData() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 200);
        }

        mThumbnail = (Button) findViewById(R.id.thumbnail);
        mFullSize = (Button) findViewById(R.id.fullSize);
        mAddGallery = (Button) findViewById(R.id.addGallery);
        mImageView = (ImageView) findViewById(R.id.imageView);

        mThumbnail.setOnClickListener(v -> {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {//判断是否有相机应用
                startActivityForResult(takePictureIntent, REQ_THUMB);
            }
        });

        mFullSize.setOnClickListener(v -> {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            // Ensure that there's a camera activity to handle the intent
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {//判断是否有相机应用
                // Create the File where the photo should go
                File photoFile = null;
                try {
                    photoFile = createImageFile();//创建临时图片文件
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                // Continue only if the File was successfully created
                if (photoFile != null) {
                    //FileProvider 是一个特殊的 ContentProvider 的子类，
                    //它使用 content:// Uri 代替了 file:/// Uri. ，更便利而且安全的为另一个app分享文件
                    Uri photoURI = FileProvider.getUriForFile(PhotoActivity.this,
                            "com.zy.blogs.fileprovider",
                            photoFile);
                    Log.i(TAG, "photoURI:" + photoURI.toString());
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                    startActivityForResult(takePictureIntent, REQ_TAKE_PHOTO);
                }
            }
        });

        mAddGallery.setOnClickListener(v -> {

            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            // Ensure that there's a camera activity to handle the intent
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {//判断是否有相机应用
                // Create the File where the photo should go
                File photoFile = null;
                try {
                    photoFile = createPublicImageFile();//创建临时图片文件
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                // Continue only if the File was successfully created
                if (photoFile != null) {
                    Uri photoURI = FileProvider.getUriForFile(PhotoActivity.this,
                            "com.zy.blogs.fileprovider",
                            photoFile);
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                    startActivityForResult(takePictureIntent, REQ_GALLERY);
                }
            }

            galleryAddPic();
        });
    }

    String mCurrentPhotoPath;

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINA).format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        //.getExternalFilesDir()方法可以获取到 SDCard/Android/data/你的应用的包名/files/ 目录，一般放一些长时间保存的数据
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        //创建临时文件,文件前缀不能少于三个字符,后缀如果为空默认未".tmp"
        File image = File.createTempFile(
                imageFileName,  /* 前缀 */
                ".jpg",         /* 后缀 */
                storageDir      /* 文件夹 */
        );
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }


    String mPublicPhotoPath;

    private File createPublicImageFile() throws IOException {
        File path = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DCIM);
        // Create an image file name
        Log.i(TAG, "path:" + path.getAbsolutePath());
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINA).format(new Date());
        String imageFileName = "JPEG_" + timeStamp;
        File image = File.createTempFile(
                imageFileName,  /* 前缀 */
                ".jpg",         /* 后缀 */
                path      /* 文件夹 */
        );
        mPublicPhotoPath = image.getAbsolutePath();
        return image;
    }


    private void galleryAddPic() {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(mPublicPhotoPath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        sendBroadcast(mediaScanIntent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQ_THUMB://返回结果
                if (resultCode != Activity.RESULT_OK) return;
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                mImageView.setImageBitmap(imageBitmap);
                break;
            case REQ_TAKE_PHOTO://返回结果
                if (resultCode != Activity.RESULT_OK) return;


                // Get the dimensions of the View
                int targetW = mImageView.getWidth();
                int targetH = mImageView.getHeight();

                // Get the dimensions of the bitmap
                BitmapFactory.Options bmOptions = new BitmapFactory.Options();
                bmOptions.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
                int photoW = bmOptions.outWidth;
                int photoH = bmOptions.outHeight;

                // Determine how much to scale down the image
                int scaleFactor = Math.min(photoW / targetW, photoH / targetH);

                // Decode the image file into a Bitmap sized to fill the View
                bmOptions.inJustDecodeBounds = false;
                bmOptions.inSampleSize = scaleFactor;
                bmOptions.inPurgeable = true;

                Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
                mImageView.setImageBitmap(bitmap);
                break;
            case REQ_GALLERY:
                if (resultCode != Activity.RESULT_OK) return;


                // Get the dimensions of the View
                targetW = mImageView.getWidth();
                targetH = mImageView.getHeight();

                // Get the dimensions of the bitmap
                bmOptions = new BitmapFactory.Options();
                bmOptions.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(mPublicPhotoPath, bmOptions);
                photoW = bmOptions.outWidth;
                photoH = bmOptions.outHeight;

                // Determine how much to scale down the image
                scaleFactor = Math.min(photoW / targetW, photoH / targetH);

                // Decode the image file into a Bitmap sized to fill the View
                bmOptions.inJustDecodeBounds = false;
                bmOptions.inSampleSize = scaleFactor;
                bmOptions.inPurgeable = true;

                bitmap = BitmapFactory.decodeFile(mPublicPhotoPath, bmOptions);
                mImageView.setImageBitmap(bitmap);
                break;
        }
    }


}

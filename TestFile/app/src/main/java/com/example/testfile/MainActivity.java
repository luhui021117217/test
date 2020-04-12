package com.example.testfile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
private ImageView iv;
    private static final int SELECT_PHOTO = 100;
//    private static final int REQUEST_EXTERNAL_STORAGE = 1;
//    private static String[] PERMISSIONS_STORAGE = {
//            Manifest.permission.READ_EXTERNAL_STORAGE,
//            Manifest.permission.WRITE_EXTERNAL_STORAGE
//    };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView) findViewById(R.id.imageView);
//       File file=new File(Environment.getExternalStorageDirectory(),"image1.jpg");
//       Uri contentUri = FileProvider.getUriForFile(this,BuildConfig.APPLICATION_ID + ".fileProvider",file);
//        //addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//        InputStream inputStream = null;
//        verifyStoragePermissions(this);
//        try {
//            inputStream = getContentResolver().openInputStream(contentUri);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//
//        Bitmap bitmap = null;
//
//            bitmap = BitmapFactory.decodeStream(inputStream);
//
//
//        iv.setImageURI(contentUri);
//
 Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
 photoPickerIntent.setType("image/*");
 startActivityForResult(photoPickerIntent, SELECT_PHOTO);
//
//    }
//
//    public static void verifyStoragePermissions(Activity activity) {
//        // Check if we have write permission
//        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
//        if (permission != PackageManager.PERMISSION_GRANTED) {
//            // We don't have permission so prompt the user
//            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
//        }
//    }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch(requestCode) {
            case SELECT_PHOTO:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    InputStream imageStream = null;
                    try {
                        imageStream = getContentResolver().openInputStream(selectedImage);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    Bitmap yourSelectedImage = BitmapFactory.decodeStream(imageStream);
                    iv.setImageBitmap( yourSelectedImage);
                }
        }
    }
}

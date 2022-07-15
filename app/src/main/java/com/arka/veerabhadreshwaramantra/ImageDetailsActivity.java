package com.arka.veerabhadreshwaramantra;

import android.Manifest;
import android.app.DownloadManager;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.widget.ContentLoadingProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;
import java.util.ArrayList;

public class ImageDetailsActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button button, buttonSetWallpaper, buttonDownload;
    private String pathSelected;
    int resourceID;
    private final String Selected_URL_PATH_ID = "Selected_URL_PATH_ID";
    private ArrayList<String> imagePath = new ArrayList<>();
    private TinyDB tinyDB;
    private long refid;
    private ContentLoadingProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);
        resourceID = getIntent().getIntExtra(Selected_URL_PATH_ID, 0);
        imageView = findViewById(R.id.img);
        button = findViewById(R.id.btnClose);
        buttonSetWallpaper = findViewById(R.id.btnSetWallpaper);
        buttonDownload = findViewById(R.id.btndownload);
        progressBar = findViewById(R.id.progressBar);
        // Create the next level button, which tries to show an interstitial when clicked.
        // Create the text view to show the level number.
        // Create the InterstitialAd and set the adUnitId (defined in values/strings.xml).
        //Add AdMob StringId
        tinyDB = new TinyDB(getApplicationContext());
        imagePath = tinyDB.getListString("MyUsers");
        progressBar.show();
//        loadInterstitial();
        displayImage();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isStoragePermissionGranted();
            }
        });

        buttonSetWallpaper.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                WallpaperManager myWallpaperManager
                        = WallpaperManager.getInstance(getApplicationContext());

                    Glide.with(ImageDetailsActivity.this).load(imagePath.get(resourceID)).into(new SimpleTarget<Drawable>() {
                        @Override
                        public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                                try {
                                Bitmap bitmap = ((BitmapDrawable) resource).getBitmap();
                                myWallpaperManager.setBitmap(bitmap);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    });

                    Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Wallpaper Set", Snackbar.LENGTH_LONG);
                    snackbar.show();
            }
        });
    }

    public boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("Deepak", "Permission is granted");
                progressBar.show();
                downloadFiles(ImageDetailsActivity.this, "VeerbhadraImage", ".jpeg", imagePath.get(resourceID));
                return true;
            } else {
                Log.v("Deepak", "Permission is revoked");
                Toast.makeText(this, "Permission is needed For storing wallpaper, Please Grant Permission", Toast.LENGTH_LONG).show();
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            Log.v("Deepak", "Permission is granted");
            return true;
        }
    }

    private void downloadFiles(Context context, String fileName, String fileExtension, String Url) {
        progressBar.hide();
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(Url);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setAllowedNetworkTypes(
                DownloadManager.Request.NETWORK_WIFI
                        | DownloadManager.Request.NETWORK_MOBILE).setAllowedOverRoaming(false).setTitle("Wallpapers")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
                .setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, fileName + fileExtension);
        refid = downloadManager.enqueue(request);
        Toast.makeText(getApplicationContext(),"Download Complete", Toast.LENGTH_LONG).show();
//        list.add(refid);
    }

    private void displayImage() {
        progressBar.hide();
        for (int i = 0; i < imagePath.size(); i++) {
            if (resourceID == i) {
                Glide.with(getApplicationContext())
                        .load(imagePath.get(i)) // Uri of the picture
                        .into(imageView);
//                    pathSelected = strPath + "/" + result[i].getName();
                return;
            }
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }

}

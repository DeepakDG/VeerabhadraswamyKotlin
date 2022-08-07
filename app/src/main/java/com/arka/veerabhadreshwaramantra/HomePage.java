package com.arka.veerabhadreshwaramantra;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.VideoView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {

    public final static int LOOPS = 1000;
    public CarouselPagerAdapter adapter;
    public ViewPager pager;
//    public static int count = 10; //ViewPager items size
    private AlertDialog dialog;
    private TinyDB tinyDB;
    private ArrayList<String> imagePath = new ArrayList<>();
    private ContentLoadingProgressBar progressBar;
    private VideoView splashVideo;

    /**
     * You shouldn't define first page = 0.
     * Let define firstpage = 'number viewpager size' to make endless carousel
     */
    public static int FIRST_PAGE = 10;
//    ImageButton setting_btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        progressBar = findViewById(R.id.progressBar);
        pager = findViewById(R.id.myviewpager);
//        setting_btn = findViewById(R.id.setting_icon);
        //set page margin between pages for viewpager
        tinyDB = new TinyDB(getApplicationContext());
        imagePath = tinyDB.getListString("MyUsers");
        progressBar.show();
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int pageMargin = ((metrics.widthPixels / 4) * 2);
        pager.setPageMargin(-pageMargin);
//        Log.d("Deepak imagetostring ",imagePathList.toString());
        adapter = new CarouselPagerAdapter(HomePage.this, getSupportFragmentManager());
        pager.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        pager.addOnPageChangeListener(adapter);
// Set current item to the middle page so we can fling to both
        // directions left and right
        pager.setCurrentItem(imagePath.size());
        pager.setOffscreenPageLimit(3);
        progressBar.hide();

    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(HomePage.this);
        builder.setTitle("ಅಪ್ಲಿಕೇಶನ್ ನಿರ್ಗಮಿಸಿ")
                .setMessage("ಮುಖ್ಯ ಮುಖಪುಟ ಪರದೆಗೆ ಹೋಗುವುದನ್ನು ಖಚಿತಪಡಿಸಿ ?")
                .setCancelable(false)
                .setPositiveButton("ಹೌದು", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        startActivity(new Intent(HomePage.this,MainActivity.class));
                    }
                })
                .setNegativeButton("ಇಲ್ಲ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        //Creating dialog box
        dialog = builder.create();
        dialog.show();
    }
}


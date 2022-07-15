package com.arka.veerabhadreshwaramantra;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ItemFragment extends Fragment {
    private static final String POSITON = "position";
    private static final String SCALE = "scale";
    private final String Selected_URL_PATH_ID = "Selected_URL_PATH_ID";
    private static final String Selected_Array_PATH = "pathArrayString";
    private int screenWidth;
    private int screenHeight;
    private ArrayList<String> imagePath = new ArrayList<>();
    private TinyDB tinyDB;

    private ImageView imageView;
    private ContentLoadingProgressBar progressBar;

    public static Fragment newInstance(HomePage context, int pos, float scale) {
        Bundle b = new Bundle();
        b.putInt(POSITON, pos);
        b.putFloat(SCALE, scale);

        return Fragment.instantiate(context, ItemFragment.class.getName(), b);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWidthAndHeight();


    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }
        tinyDB = new TinyDB(getContext());
        final int postion = this.getArguments().getInt(POSITON);
        float scale = this.getArguments().getFloat(SCALE);
//        ArrayList<String> arrayString = this.getArguments().getStringArrayList(Selected_URL_PATH_ID);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(screenWidth / 2, screenHeight / 2);
        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.fragmentimage, container, false);
        TextView textView = linearLayout.findViewById(R.id.text);
        CarouselLinearLayout root = linearLayout.findViewById(R.id.root_container);
//        progressBar = linearLayout.findViewById(R.id.progressBar);
//        progressBar.show();
        imageView = linearLayout.findViewById(R.id.pagerImg);
        imageView.setLayoutParams(layoutParams);
        imagePath = tinyDB.getListString("MyUsers");
        Log.d("Deepak getIterate ", imagePath.toString());

        Glide.with(getActivity())
                .load(imagePath.get(postion)).apply(RequestOptions.placeholderOf(R.drawable.load_image).error(R.drawable.load_image))
                .into(imageView);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ImageDetailsActivity.class);
                intent.putExtra(Selected_URL_PATH_ID, postion);
                startActivity(intent);
            }

        });
        root.setScaleBoth(scale);
        return linearLayout;
    }

    /**
     * Get device screen width and height
     */
    private void getWidthAndHeight() {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        screenHeight = displaymetrics.heightPixels;
        screenWidth = displaymetrics.widthPixels;
    }
}

package com.arka.veerabhadreshwaramantra;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class CarouselPagerAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener {

    public final static float BIG_SCALE = 1.0f;
    public final static float SMALL_SCALE = 0.7f;
    public final static float DIFF_SCALE = BIG_SCALE - SMALL_SCALE;
    private HomePage context;
    ArrayList<String> imageArrayListPath = new ArrayList<>();
    private FragmentManager fragmentManager;
    private float scale;
    private ArrayList<String> imagePath = new ArrayList<>();
    private TinyDB tinyDB;

    public CarouselPagerAdapter(HomePage context, FragmentManager fm) {
        super(fm);
        this.fragmentManager = fm;
        this.context = context;
        tinyDB = new TinyDB(this.context);
        imagePath = tinyDB.getListString("MyUsers");
    }

    @Override

    public Fragment getItem(int position) {
        // make the first pager bigger than others
        try {
            if (position == imagePath.size())
                scale = BIG_SCALE;
            else
                scale = SMALL_SCALE;
            position = position % imagePath.size();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ItemFragment.newInstance(context, position, scale);
    }

    @Override
    public int getCount() {
        int count = 0;
        try {
            count = imagePath.size() * HomePage.LOOPS;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        try {
            if (positionOffset >= 0f && positionOffset <= 1f) {
                CarouselLinearLayout cur = getRootView(position);
                CarouselLinearLayout next = getRootView(position + 1);
                cur.setScaleBoth(BIG_SCALE - DIFF_SCALE * positionOffset);
                next.setScaleBoth(SMALL_SCALE + DIFF_SCALE * positionOffset);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @SuppressWarnings("ConstantConditions")
    private CarouselLinearLayout getRootView(int position) {
        return (CarouselLinearLayout) fragmentManager.findFragmentByTag(this.getFragmentTag(position))
                .getView().findViewById(R.id.root_container);
    }

    private String getFragmentTag(int position) {
        return "android:switcher:" + context.pager.getId() + ":" + position;
    }
}


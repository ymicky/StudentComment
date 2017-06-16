package com.stundentcomments.stundentcomment;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

public class StudentCommentActivity extends FragmentActivity {
    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 2;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);


        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ScreenSlidePageFragment.index = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    //@Override
    //public void onBackPressed() {
    //    if (mPager.getCurrentItem() == 0) {
    //        // If the user is currently looking at the first step, allow the system to handle the
    //        // Back button. This calls finish() on this activity and pops the back stack.
    //        super.onBackPressed();
    //    } else {
    //        // Otherwise, select the previous step.
    //        mPager.setCurrentItem(mPager.getCurrentItem() - 1);
    //   }
    //}

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int contentNr) {
            Content content = new Content("",0);
            switch (contentNr)
            {
                case 0:
                    content = new Content(getResources().getString(R.string.comment1),R.drawable.pic_1);
                    break;
                case 1:
                    content = new Content(getResources().getString(R.string.comment2),R.drawable.pic_2);
                    break;
            }
            return ScreenSlidePageFragment.newInstance(content);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}

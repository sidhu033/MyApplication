package com.example.user.myapplication.activity;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.user.myapplication.R;

import com.example.user.myapplication.CustomPagerAdapter;

public class slider extends Activity
{
    //Declaration of variables
    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private TextView txt_next,txt_skip;
    private ImageView promo1;
    private int[] layouts;          //sliders layouts

    //    TextView vredtxtredox,vredtxtredoxsub,redtxtredox2,redtxtredox2sub,vredtxtredox3,vredtxtredoxsub3;
    //private Button btnSkip, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // Making notification bar transparent


             if (Build.VERSION.SDK_INT >= 19)
        {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().requestFeature(Window.FEATURE_NO_TITLE);

           // getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        setContentView(R.layout.slider);

    // Checking for first time launch - before calling setContentView()
       /* prefs = Application.getApp().getPrefs();
        if (!prefs.isFirstTimeLaunch()) {
            launchHomeScreen();
            finish();
        }*/



        //intialization
        promo1 = findViewById(R.id.promo1);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
        txt_skip = (TextView) findViewById(R.id.txt_skip);
        txt_next = (TextView) findViewById(R.id.txt_next);
        promo1 = findViewById(R.id.promo1);



        // layouts of all welcome sliders add few more layouts if you want
        layouts = new int[]
                {
                R.layout.view_red,
                R.layout.redoxer_2
                /*,R.layout.redoxer_3*/};


        // adding bottom dots
                     addBottomDots(0);

       // making notification bar transparent
                     changeStatusBarColor();

       //setting view pager adapter
        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        //launching home screen activity
        txt_skip.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                launchHomeScreen();
            }
        });

        //slidert checking the last page and
        txt_next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
             // checking for last page
            // if last page home screen will be launched

                int current = getItem(+1);
                if (current < layouts.length)
                {
                // move to next screen
                viewPager.setCurrentItem(current);
                } else
                    {
                    launchHomeScreen();
                }
            }
        });
    }
    //adding bottom dots
    private void addBottomDots(int currentPage)
    {
        dots = new TextView[layouts.length];
        int[] colorsActive = getResources().getIntArray(R.array.array_pager_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_pager_inactive);
        dotsLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++)
        {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("•"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout.addView(dots[i]);
        }
        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }

    private int getItem(int i)
    {

        return viewPager.getCurrentItem() + i;
    }
    private void launchHomeScreen()
    {
        //   prefs.setFirstTimeLaunch(false);
            startActivity(new Intent(slider.this, MainActivity.class));
            finish();
    }
    //  viewpager change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener()
    {
        @Override
        public void onPageSelected(int position)
        {
            addBottomDots(position);

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.length - 1)
            {
// last page. make button text to GOT IT
                txt_next.setText(getString(R.string.start));
                txt_skip.setVisibility(View.GONE);
            } else
                {
// still pages are left
                txt_next.setText(getString(R.string.next));
                txt_skip.setVisibility(View.VISIBLE);
            }
        }
        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2)
        {

        }
        @Override
        public void onPageScrollStateChanged(int arg0)
        {
        }
    };
    /**
     * Making notification bar transparent
     */
    private void changeStatusBarColor()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }
    /**
     * View pager adapter
     */
    public class MyViewPagerAdapter extends PagerAdapter
    {
        private LayoutInflater layoutInflater;
        public MyViewPagerAdapter()
        {

        }
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);
            return view;
        }
        @Override
        public int getCount() {
            return layouts.length;
        }
        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}




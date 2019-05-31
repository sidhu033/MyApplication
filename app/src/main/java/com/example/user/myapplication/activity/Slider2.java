package com.example.user.myapplication.activity;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.user.myapplication.R;

public class Slider2 extends AppCompatActivity
{
    private ViewPager viewPager2;
    private MyViewPagerAdapterr myViewPagerAdapterr;
    private LinearLayout dotsLayout1;
    private TextView[] dots;
    private int[] layouts;          //sliders layouts
    private TextView txt_prev1,txt_next1;
    android.support.v7.widget.Toolbar slidertoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

      /*  // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 19)
        {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        }*/
        setContentView(R.layout.activity_slider2);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.glogo);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("BENIFITS OF REDOXER");
        //intialization
        txt_prev1 = findViewById(R.id.txt_prev1);
        txt_next1 = findViewById(R.id.txt_next1);
        dotsLayout1 =findViewById(R.id.layoutDots2);
       /* slidertoolbar = findViewById(R.id.slidertoolbar);
        setSupportActionBar(slidertoolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
*/
        //dots intialization
        viewPager2 = (ViewPager) findViewById(R.id.view_pager2);


        // layouts of all welcome sliders add few more layouts if you want
        layouts = new int[]
                {
                        R.layout.slider1,
                        R.layout.slider2,
                        R.layout.slider3
                };
        // adding bottom dots
        addBottomDots(0);

        //setting view pager adapter
        myViewPagerAdapterr = new MyViewPagerAdapterr();           //instance of class myviewpage adapter
        viewPager2.setAdapter(myViewPagerAdapterr);                 //aading adapter to viewpage
        viewPager2.addOnPageChangeListener(viewPagerPageChangeListenerr);           //page change listner

        //onclick text events
        txt_next1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                int current = getItem(+1);
                if (current < layouts.length)
                {
                    // move to next screen
                    viewPager2.setCurrentItem(current);
                } else
                {
                    launchpurchase();
                }
            }
        });
        txt_prev1.setOnClickListener(new View.OnClickListener()             //for previous button
        {
            @Override
            public void onClick(View view)
            {
                 viewPager2.setCurrentItem(getItem(-1), true);

            }
        });
        txt_prev1.setVisibility(View.GONE);
    }
    //on create closeed
    private void launchpurchase()
    {  startActivity(new Intent(Slider2.this, PurchaseActivity.class));
        finish();
    }

    //returns current item of viewpager
    private int getItem(int i)
    {

        return viewPager2.getCurrentItem() + i;
    }

    //for adding dots
     private void addBottomDots(int currentPage)
    {
        dots = new TextView[layouts.length];
        int[] colorsActive = getResources().getIntArray(R.array.array_pager_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_pager_inactive);
        dotsLayout1.removeAllViews();

        for (int i = 0; i < dots.length; i++)
        {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("•"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout1.addView(dots[i]);
        }
        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }
    /**
     * View pager adapter
     */
    //  viewpager change listener
     ViewPager.OnPageChangeListener viewPagerPageChangeListenerr = new ViewPager.OnPageChangeListener()
    {
        @Override
        public void onPageScrolled(int i, float v, int i1)
        {


        }

        @Override
        public void onPageSelected(int position)
        {
            addBottomDots(position);

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.length - 1)
            {
            // last page. make button text to GOT IT
                txt_next1.setText(getString(R.string.Purchsenow));
                txt_prev1.setText(getString(R.string.Purchselater));

            } else
            {
                    // still pages are left
                txt_next1.setText(getString(R.string.next));
                txt_prev1.setVisibility(View.VISIBLE);
            }
            txt_next1.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                        purchasenow();
                }
            });
            txt_prev1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    purchaselater();
                }
            });
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

    private void purchaselater()
    {
        Intent intent = new Intent(Slider2.this, Register.class);
        startActivity(intent);
    }

    private void purchasenow()
    {
        Intent i = new Intent(Slider2.this, PurchaseActivity1.class);
        startActivity(i);

    }

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

    public class  MyViewPagerAdapterr extends PagerAdapter
    {
            LayoutInflater layoutInflater;
            public MyViewPagerAdapterr()            //constructor of Myview pageradapter
             {

             }
        //view group method
        public Object instantiateItem(ViewGroup container, int position)
        {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);
            return view;
        }
        @Override
        public int getCount()
        {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o)
        {

                return view == o;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object)               //viewgroup ovrriede method method
        {
            View view = (View) object;
            container.removeView(view);
        }
    }
}

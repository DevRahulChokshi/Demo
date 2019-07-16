package com.targetupsc.education.android.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.targetupsc.education.android.R;
import com.targetupsc.education.android.Utils.VerticalViewPager;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashActivity extends AppCompatActivity {


    @BindView(R.id.layoutDots)
    LinearLayout dotsLayout;
    @BindView(R.id.txt_terms_conditions)
    TextView txtTermsConditions;
    @BindView(R.id.Lnr_bottom)
    LinearLayout LnrBottom;


    ArrayList<Integer> BannerArrayList;
    VerticalViewPager viewPager;
    @BindView(R.id.view_pager_banner)
    VerticalViewPager viewPagerBanner;
    @BindView(R.id.relative)
    RelativeLayout relative;
    @BindView(R.id.img_fb)
    ImageView imgFb;
    @BindView(R.id.img_register)
    ImageView imgRegister;
    @BindView(R.id.img_google)
    ImageView imgGoogle;
    private TextView[] dots;
    private MyViewPagerAdapter myViewPagerAdapter;
    int currentPage = 0, NUM_PAGES = 4;
    Timer timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        BannerArrayList = new ArrayList<>();

        viewPager = findViewById(R.id.view_pager_banner);
        BannerArrayList.add(R.drawable.splash_dummy);
        BannerArrayList.add(R.drawable.splash_dummy);
        BannerArrayList.add(R.drawable.splash_dummy);
        BannerArrayList.add(R.drawable.splash_dummy);
        SetAdViewPager();


        //viewPager.setRotation(90);
        addBottomDots(0);


        SetSliderAutoTimer();


        //   startActivity(new Intent(this,SignUpActivity.class));
    }

    @OnClick({R.id.img_fb, R.id.img_register, R.id.img_google, R.id.txt_terms_conditions})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_fb:
                break;
            case R.id.img_register:

                startActivity(new Intent(this, SignUpActivity.class));
                finish();

                break;
            case R.id.img_google:


                break;
            case R.id.txt_terms_conditions:

                startActivity(new Intent(this, LoginActivity.class));
                finish();

                break;
        }
    }


    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;
        private ArrayList<Integer> bannerModelArrayList;

        public MyViewPagerAdapter(ArrayList<Integer> mbannerModelArrayList) {
            bannerModelArrayList = mbannerModelArrayList;

        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(R.layout.row_banner, container, false);
            ImageView imgAd = view.findViewById(R.id.imgAd);
            imgAd.setImageResource(bannerModelArrayList.get(position));
            container.addView(view);
            view.setRotation(90);
            imgAd.animate().rotation(270).start();

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            return view;
        }

        @Override
        public int getCount() {
            return bannerModelArrayList.size();
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


    //Set viepager and adapter
    private void SetAdViewPager() {

        myViewPagerAdapter = new MyViewPagerAdapter(BannerArrayList);
        viewPager.setSaveFromParentEnabled(false);
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);


    }

    //  viewpager change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);

            Log.e("---------------------", "onPageSelected  " + position);

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            Log.e("---------------------", "onPageScrolled  " + arg0);

            currentPage = arg0;


        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
            Log.e("---------------------", "onPageScrollStateChanged  " + arg0);


        }
    };

    //Method to set dots according to slider position
    private void addBottomDots(int currentPage) {
        dots = new TextView[BannerArrayList.size()];


        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(SplashActivity.this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(50);
            dots[i].setTextColor(SplashActivity.this.getResources().getColor(R.color.colorTextColor));
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(SplashActivity.this.getResources().getColor(R.color.colorTextTitle));
    }

    //Method to set timer to slider
    private void SetSliderAutoTimer() {

        Log.e("SetSliderAutoTimer", "SetSliderAutoTimer");
        final Handler handler = new Handler();

        final Runnable update = new Runnable() {
            public void run() {

                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };


        timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(update);
            }
        }, 100, 3000);

    }

}

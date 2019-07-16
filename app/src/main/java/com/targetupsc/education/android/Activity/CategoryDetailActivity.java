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

import com.targetupsc.education.android.Model.CategoryDetailModel;
import com.targetupsc.education.android.R;
import com.targetupsc.education.android.VerticalViewPagerScreens.VerticalViewPager;
import com.targetupsc.education.android.VerticalViewPagerScreens.VerticlePagerAdapter;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CategoryDetailActivity extends AppCompatActivity {



    VerticalViewPager verticalViewPager;
    ArrayList<CategoryDetailModel> mCategoryDetailList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);
        ButterKnife.bind(this);

//----------------------------------------------------------------
     /*   dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
        viewPager = (ViewPager) findViewById(R.id.view_pager_banner);


        BannerArrayList = new ArrayList<>();

        viewPager = findViewById(R.id.view_pager_banner);
        BannerArrayList.add(R.drawable.logo);
        BannerArrayList.add(R.drawable.logo);
        BannerArrayList.add(R.drawable.logo);
        BannerArrayList.add(R.drawable.logo);

        SetAdViewPager();

        //viewPager.setRotation(90);
        addBottomDots(0);

        SetSliderAutoTimer();*/
        //-------------------------------------------------------------------------------------



        mCategoryDetailList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            CategoryDetailModel categoryDetailModel = new CategoryDetailModel();
            categoryDetailModel.setCategoryName("Lorem ipsum");
            categoryDetailModel.setDescription("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
            mCategoryDetailList.add(categoryDetailModel);
        }


        verticalViewPager = (VerticalViewPager) findViewById(R.id.verticleViewPager);
        verticalViewPager.setAdapter(new VerticlePagerAdapter(this, mCategoryDetailList));

    }

//--------------------------------------------------------------------------------------------
/*
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
        }, 100, 6000);

    }

    //Set viepager and adapter
    private void SetAdViewPager() {

        myViewPagerAdapter = new MyViewPagerAdapter(BannerArrayList);
        viewPager.setSaveFromParentEnabled(false);
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);


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
           */
/* try {
                Picasso.get().load(Constants.BASE_URL_IMAGE + bannerModelArrayList.get(position).getImage()).into(imgAd);
            } catch (Exception e) {
                e.printStackTrace();
            }*//*


            imgAd.setImageResource(bannerModelArrayList.get(position));
            container.addView(view);

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


    //  viewpager change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);


        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    //Method to set dots according to slider position
    private void addBottomDots(int currentPage) {
        dots = new TextView[BannerArrayList.size()];


        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(CategoryDetailActivity.this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(30);
            dots[i].setTextColor(CategoryDetailActivity.this.getResources().getColor(R.color.colorTextColor));
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(CategoryDetailActivity.this.getResources().getColor(R.color.colorTextTitle));
    }
*/

 /*   @OnClick(R.id.Lnr_Contribute)
    public void onViewClicked() {

        startActivity(new Intent(CategoryDetailActivity.this,NewPostActivity.class));
    }
*/


}

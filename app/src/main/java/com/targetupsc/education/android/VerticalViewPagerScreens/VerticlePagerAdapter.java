package com.targetupsc.education.android.VerticalViewPagerScreens;

import android.app.DatePickerDialog;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.targetupsc.education.android.Activity.CategoryDetailActivity;
import com.targetupsc.education.android.Activity.HomeActivity;
import com.targetupsc.education.android.Activity.NewPostActivity;
import com.targetupsc.education.android.Model.CategoryDetailModel;
import com.targetupsc.education.android.R;
import com.targetupsc.education.android.Utils.OnSwipeTouchListener;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class VerticlePagerAdapter extends PagerAdapter {

    Context mContext;
    LayoutInflater mLayoutInflater;

    ArrayList<CategoryDetailModel> mCategoryDetailList;


    ArrayList<Integer> BannerArrayList;
    TextView[] dots;
    MyViewPagerAdapter myViewPagerAdapter;
    int currentPage = 0, NUM_PAGES = 4;
    Timer timer;
    LinearLayout dotsLayout;

    CategoryDetailActivity categoryDetailActivity;


    public VerticlePagerAdapter(CategoryDetailActivity categoryDetailActivity, ArrayList<CategoryDetailModel> mCategoryDetailList) {
        mContext = categoryDetailActivity;
        this.mCategoryDetailList = mCategoryDetailList;
        this.categoryDetailActivity = categoryDetailActivity;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mCategoryDetailList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.row_category_detail, container, false);


        itemView.setOnTouchListener(new OnSwipeTouchListener(mContext) {
            public void onSwipeTop() {
                Toast.makeText(mContext, "top", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeRight() {
                Toast.makeText(mContext, "right", Toast.LENGTH_SHORT).show();


                mContext.startActivity(new Intent(categoryDetailActivity, HomeActivity.class));
                categoryDetailActivity.finish();
            }
            public void onSwipeLeft() {
                Toast.makeText(mContext, "left", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeBottom() {
                Toast.makeText(mContext, "bottom", Toast.LENGTH_SHORT).show();
            }

        });

        final TextView txtDescription = (TextView) itemView.findViewById(R.id.txt_description);
        final TextView txt_date = (TextView) itemView.findViewById(R.id.txt_date);
        LinearLayout Lnr_Contribute = itemView.findViewById(R.id.Lnr_Contribute);
        LinearLayout Lnr_back = itemView.findViewById(R.id.Lnr_back);
        LinearLayout Lnr_calender = itemView.findViewById(R.id.Lnr_calender);


        Lnr_calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar dob_currentDate = Calendar.getInstance();
                DatePickerDialog dob_atePickerDialog = new DatePickerDialog(mContext, R.style.DialogTheme, new DatePickerDialog.OnDateSetListener() {


                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {


                        //Set today's date
                        DateFormat originalFormat = new SimpleDateFormat("dd-MM-yyyy");
                        DateFormat DisplayFormat = new SimpleDateFormat("dd MMMM yyyy");

                        String SelectedDate = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                        Date SeletedDate = null;
                        try {
                            SeletedDate = originalFormat.parse(SelectedDate);
                            Log.e("SeletedDate", "SeletedDate " + SeletedDate);

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        txt_date.setText(originalFormat.format(SeletedDate));


                    }
                }, dob_currentDate.get(Calendar.YEAR), dob_currentDate.get(Calendar.MONTH), dob_currentDate.get(Calendar.DATE));

                dob_atePickerDialog.getDatePicker().setMaxDate(dob_currentDate.getTimeInMillis());
                dob_atePickerDialog.show();

            }
        });

        Lnr_Contribute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.startActivity(new Intent(mContext, NewPostActivity.class));
            }
        });


        Lnr_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mContext.startActivity(new Intent(categoryDetailActivity, HomeActivity.class));
                categoryDetailActivity.finish();
            }
        });


        txtDescription.setText(mCategoryDetailList.get(position).getDescription());


        //-------------------------------------------- code for slider --------------------------------------------
        ViewPager viewPager = itemView.findViewById(R.id.view_pager_banner);
        dotsLayout = itemView.findViewById(R.id.layoutDots);

        BannerArrayList = new ArrayList<>();
        BannerArrayList.add(R.drawable.dummy_big);
        BannerArrayList.add(R.drawable.dummy_big);
        BannerArrayList.add(R.drawable.dummy_big);
        BannerArrayList.add(R.drawable.dummy_big);

        SetAdViewPager(viewPager);
        addBottomDots(0);
        SetSliderAutoTimer(viewPager);
        //-------------------------------------------- code for slider --------------------------------------------


        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }


    //-------------------------------------------- code for slider --------------------------------------------

    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;
        private ArrayList<Integer> bannerModelArrayList;

        public MyViewPagerAdapter(ArrayList<Integer> mbannerModelArrayList) {
            bannerModelArrayList = mbannerModelArrayList;

        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(R.layout.row_banner, container, false);
            ImageView imgAd = view.findViewById(R.id.imgAd);
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

    //Set viepager and adapter
    private void SetAdViewPager(ViewPager viewPager) {

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
            dots[i] = new TextView(mContext);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(30);
            dots[i].setTextColor(mContext.getResources().getColor(R.color.colorTextColor));
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
           // dots[currentPage].setTextColor(mContext.getResources().getColor(R.color.colorTextTitle));
            dots[currentPage].setTextColor(mContext.getResources().getColor(R.color.colorTextColor));
    }

    //Method to set timer to slider
    private void SetSliderAutoTimer(final ViewPager viewPager) {

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
    //-------------------------------------------- code for slider --------------------------------------------

}
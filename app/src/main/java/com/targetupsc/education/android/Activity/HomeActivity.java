package com.targetupsc.education.android.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.targetupsc.education.android.Adapter.HomeOptionsListAdapter;
import com.targetupsc.education.android.Model.TopCategoryModel;
import com.targetupsc.education.android.R;
import com.targetupsc.education.android.Utils.OnSwipeTouchListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {


    ArrayList<String> mHomeOptions;
    ArrayList<TopCategoryModel> mTopCategoryList;
    @BindView(R.id.txt_date)
    TextView txtDate;
    @BindView(R.id.img_search)
    ImageView imgSearch;
    @BindView(R.id.txt_mcq)
    TextView txtMcq;
    @BindView(R.id.txt_test_series)
    TextView txtTestSeries;
    @BindView(R.id.txt_course)
    TextView txtCourse;
    @BindView(R.id.recycler_home_option)
    RecyclerView recyclerHomeOption;
    @BindView(R.id.img_settings)
    ImageView imgSettings;
    @BindView(R.id.Lnr_top_category)
    LinearLayout LnrTopCategory;
    @BindView(R.id.Rel_top)
    RelativeLayout RelTop;
    @BindView(R.id.Lnr_mcq)
    LinearLayout LnrMcq;
    @BindView(R.id.Lnr_topCat_label)
    LinearLayout LnrTopCatLabel;
    @BindView(R.id.Scrollview)
    ScrollView Scrollview;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);


        Scrollview.setOnTouchListener(new OnSwipeTouchListener(HomeActivity.this) {
            public void onSwipeTop() {
                Toast.makeText(HomeActivity.this, "top", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeRight() {
                Toast.makeText(HomeActivity.this, "right", Toast.LENGTH_SHORT).show();


                //HomeActivity.this.startActivity(new Intent(HomeActivity.this, CategoryDetailActivity.class));

            }

            public void onSwipeLeft() {
                Toast.makeText(HomeActivity.this, "left", Toast.LENGTH_SHORT).show();
                HomeActivity.this.finish();
            }

            public void onSwipeBottom() {
                Toast.makeText(HomeActivity.this, "bottom", Toast.LENGTH_SHORT).show();
            }

        });

        LnrMcq.setOnTouchListener(new OnSwipeTouchListener(HomeActivity.this) {
            public void onSwipeTop() {
                Toast.makeText(HomeActivity.this, "top", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeRight() {
                Toast.makeText(HomeActivity.this, "right", Toast.LENGTH_SHORT).show();


                //HomeActivity.this.startActivity(new Intent(HomeActivity.this, CategoryDetailActivity.class));

            }

            public void onSwipeLeft() {
                Toast.makeText(HomeActivity.this, "left", Toast.LENGTH_SHORT).show();
                HomeActivity.this.finish();
            }

            public void onSwipeBottom() {
                Toast.makeText(HomeActivity.this, "bottom", Toast.LENGTH_SHORT).show();
            }

        });

        LnrTopCatLabel.setOnTouchListener(new OnSwipeTouchListener(HomeActivity.this) {
            public void onSwipeTop() {
                Toast.makeText(HomeActivity.this, "top", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeRight() {
                Toast.makeText(HomeActivity.this, "right", Toast.LENGTH_SHORT).show();


                //

            }

            public void onSwipeLeft() {
                Toast.makeText(HomeActivity.this, "left", Toast.LENGTH_SHORT).show();
                HomeActivity.this.startActivity(new Intent(HomeActivity.this, CategoryDetailActivity.class));
                HomeActivity.this.finish();
            }

            public void onSwipeBottom() {
                Toast.makeText(HomeActivity.this, "bottom", Toast.LENGTH_SHORT).show();
            }

        });

        mHomeOptions = new ArrayList<>();
        mHomeOptions.add("Uploads");
        mHomeOptions.add("My Feeds");
        mHomeOptions.add("Top Articles");
        mHomeOptions.add("Bookmarks");


        HomeOptionsListAdapter homeOptionsListAdapter = new HomeOptionsListAdapter(HomeActivity.this, mHomeOptions);
        recyclerHomeOption.setHasFixedSize(true);
        recyclerHomeOption.setLayoutManager(new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.HORIZONTAL, false));
        recyclerHomeOption.setAdapter(homeOptionsListAdapter);

        mTopCategoryList = new ArrayList<>();
        for (int i = 0; i < 19; i++) {
            TopCategoryModel topCategoryModel = new TopCategoryModel();
            mTopCategoryList.add(topCategoryModel);
        }

        ShowTopCategoryList();

    }

    //Method to show grid of Top Category List
    @SuppressLint("ClickableViewAccessibility")
    private void ShowTopCategoryList() {
        int RowCount = 0;
        LinearLayout LnrCategory = null;
        for (int i = 0; i < mTopCategoryList.size(); i++) {

            if (RowCount == 0) {
                LnrCategory = new LinearLayout(HomeActivity.this);
            }

            LayoutInflater inflater = LayoutInflater.from(HomeActivity.this);
            LinearLayout view = (LinearLayout) inflater.inflate(R.layout.row_top_category, null);

            view.setGravity(Gravity.CENTER);
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.MATCH_PARENT, 1);
            view.setLayoutParams(param);
            LnrCategory.addView(view);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(HomeActivity.this, CategoryDetailActivity.class));
                }
            });

            RowCount++;
            if (RowCount == 3) {
                LnrTopCategory.addView(LnrCategory);
                RowCount = 0;
            }
            if (RowCount < 3 && i == (mTopCategoryList.size() - 1)) {


                if (RowCount == 1) {
                    LinearLayout.LayoutParams param1 = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.MATCH_PARENT, 1);


                    LinearLayout linearLayout = new LinearLayout(HomeActivity.this);
                    linearLayout.setGravity(Gravity.CENTER);
                    linearLayout.setLayoutParams(param1);
                    LnrCategory.addView(linearLayout);


                    LinearLayout linearLayout1 = new LinearLayout(HomeActivity.this);
                    linearLayout1.setGravity(Gravity.CENTER);
                    linearLayout1.setLayoutParams(param1);
                    LnrCategory.addView(linearLayout1);
                } else if (RowCount == 2) {
                    LinearLayout.LayoutParams param1 = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.MATCH_PARENT, 1);


                    LinearLayout linearLayout = new LinearLayout(HomeActivity.this);
                    linearLayout.setGravity(Gravity.CENTER);
                    linearLayout.setLayoutParams(param1);
                    LnrCategory.addView(linearLayout);

                }




                LnrTopCategory.addView(LnrCategory);


                RowCount = 0;

            }
        }

    }

    @OnClick({R.id.txt_mcq, R.id.txt_test_series, R.id.txt_course, R.id.img_settings})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.txt_mcq:
                startActivity(new Intent(HomeActivity.this, MCQActivity.class));
                break;
            case R.id.txt_test_series:
                startActivity(new Intent(HomeActivity.this, TestSeriesDetailsActivity.class));

                break;
            case R.id.txt_course:
                startActivity(new Intent(HomeActivity.this, CourseActivity.class));

                break;
            case R.id.img_settings:

                startActivity(new Intent(HomeActivity.this, SettingActivity.class));

                break;
        }
    }
}

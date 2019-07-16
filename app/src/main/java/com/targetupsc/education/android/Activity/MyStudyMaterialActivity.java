package com.targetupsc.education.android.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.targetupsc.education.android.Adapter.CoursePdfListAdapter;
import com.targetupsc.education.android.Model.CoursePdfMyStudyMaterialModel;
import com.targetupsc.education.android.Model.TestSeriesMyStudyMaterialModel;
import com.targetupsc.education.android.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyStudyMaterialActivity extends AppCompatActivity {

    @BindView(R.id.Lnr_back)
    LinearLayout LnrBack;
    @BindView(R.id.recycler_course_pdf)
    RecyclerView recyclerCoursePdf;
    @BindView(R.id.Lnr_Test_Series)
    LinearLayout LnrTestSeries;


    ArrayList<CoursePdfMyStudyMaterialModel> mCoursePdfList;
    ArrayList<TestSeriesMyStudyMaterialModel> mTestSeriesList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_study_material);
        ButterKnife.bind(this);


        mCoursePdfList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CoursePdfMyStudyMaterialModel coursePdfMyStudyMaterialModel = new CoursePdfMyStudyMaterialModel();
            mCoursePdfList.add(coursePdfMyStudyMaterialModel);
        }

        CoursePdfListAdapter coursePdfListAdapter = new CoursePdfListAdapter(MyStudyMaterialActivity.this, mCoursePdfList);
        recyclerCoursePdf.setHasFixedSize(true);
        recyclerCoursePdf.setLayoutManager(new LinearLayoutManager(MyStudyMaterialActivity.this, LinearLayoutManager.HORIZONTAL, false));
        recyclerCoursePdf.setAdapter(coursePdfListAdapter);


        mTestSeriesList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            TestSeriesMyStudyMaterialModel testSeriesMyStudyMaterialModel = new TestSeriesMyStudyMaterialModel();
            mTestSeriesList.add(testSeriesMyStudyMaterialModel);
        }


        for (int j = 0; j < mTestSeriesList.size(); j++) {

            LayoutInflater inflater = LayoutInflater.from(MyStudyMaterialActivity.this);
            LinearLayout view = (LinearLayout) inflater.inflate(R.layout.row_test_series_study_material, null);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MyStudyMaterialActivity.this, MyStudyMaterialQuestionsActivity.class));
                }
            });
            LnrTestSeries.addView(view);
        }

    }

    @OnClick(R.id.Lnr_back)
    public void onViewClicked() {
        finish();
    }
}

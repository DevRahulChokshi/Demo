package com.targetupsc.education.android.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.targetupsc.education.android.Adapter.CourseListAdapter;
import com.targetupsc.education.android.Adapter.CoursePdfListAdapter;
import com.targetupsc.education.android.Model.CourseModel;
import com.targetupsc.education.android.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CourseActivity extends AppCompatActivity {

    @BindView(R.id.Lnr_back)
    LinearLayout LnrBack;
    @BindView(R.id.recycler_course_pdf)
    RecyclerView recyclerCoursePdf;
    @BindView(R.id.recycler_course_video)
    RecyclerView recyclerCourseVideo;
    @BindView(R.id.recycler_books)
    RecyclerView recyclerBooks;
    ArrayList<CourseModel> mCoursePdfList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        ButterKnife.bind(this);


        mCoursePdfList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CourseModel CourseModel = new CourseModel();
            mCoursePdfList.add(CourseModel);
        }

        CourseListAdapter coursePdfListAdapter = new CourseListAdapter(CourseActivity.this, mCoursePdfList);
        recyclerCoursePdf.setHasFixedSize(true);
        recyclerCoursePdf.setLayoutManager(new LinearLayoutManager(CourseActivity.this, LinearLayoutManager.HORIZONTAL, false));
        recyclerCoursePdf.setAdapter(coursePdfListAdapter);

        CourseListAdapter coursePdfListAdaptervideo = new CourseListAdapter(CourseActivity.this, mCoursePdfList);
        recyclerCourseVideo.setHasFixedSize(true);
        recyclerCourseVideo.setLayoutManager(new LinearLayoutManager(CourseActivity.this, LinearLayoutManager.HORIZONTAL, false));
        recyclerCourseVideo.setAdapter(coursePdfListAdaptervideo);

        CourseListAdapter coursePdfListAdapterbook = new CourseListAdapter(CourseActivity.this, mCoursePdfList);
        recyclerBooks.setHasFixedSize(true);
        recyclerBooks.setLayoutManager(new LinearLayoutManager(CourseActivity.this, LinearLayoutManager.HORIZONTAL, false));
        recyclerBooks.setAdapter(coursePdfListAdapterbook);

    }

    @OnClick(R.id.Lnr_back)
    public void onViewClicked() {
        finish();
    }
}

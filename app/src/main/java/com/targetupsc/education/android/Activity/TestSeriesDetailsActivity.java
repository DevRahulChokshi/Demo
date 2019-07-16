package com.targetupsc.education.android.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.targetupsc.education.android.Adapter.TestSeriesListAdapter;
import com.targetupsc.education.android.Model.TestSeriesModel;
import com.targetupsc.education.android.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestSeriesDetailsActivity extends AppCompatActivity {
    ArrayList<TestSeriesModel> mTestSeriesList;
    @BindView(R.id.Lnr_back)
    LinearLayout LnrBack;
    @BindView(R.id.recycler_test_series)
    RecyclerView recyclerTestSeries;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_series_details);
        ButterKnife.bind(this);


        mTestSeriesList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            TestSeriesModel TestSeriesModel = new TestSeriesModel();
            mTestSeriesList.add(TestSeriesModel);
        }

        TestSeriesListAdapter TestSeriesListAdapter = new TestSeriesListAdapter(TestSeriesDetailsActivity.this, mTestSeriesList);
        recyclerTestSeries.setHasFixedSize(true);
        recyclerTestSeries.setLayoutManager(new LinearLayoutManager(TestSeriesDetailsActivity.this, LinearLayoutManager.VERTICAL, false));
        recyclerTestSeries.setAdapter(TestSeriesListAdapter);
    }

    @OnClick(R.id.Lnr_back)
    public void onViewClicked() {
        finish();
    }
}

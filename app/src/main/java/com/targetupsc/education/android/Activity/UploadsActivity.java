package com.targetupsc.education.android.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.targetupsc.education.android.Adapter.UploadsListAdapter;
import com.targetupsc.education.android.Model.UploadsModel;
import com.targetupsc.education.android.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UploadsActivity extends AppCompatActivity {

    ArrayList<UploadsModel> mUploadsList;
    @BindView(R.id.Lnr_back)
    LinearLayout LnrBack;
    @BindView(R.id.recycler_test_series)
    RecyclerView recyclerUploads;
    @BindView(R.id.img_plus)
    ImageView imgPlus;
    @BindView(R.id.img_search)
    ImageView imgSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploads);
        ButterKnife.bind(this);


        mUploadsList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            UploadsModel UploadsModel = new UploadsModel();
            mUploadsList.add(UploadsModel);
        }

        UploadsListAdapter UploadsListAdapter = new UploadsListAdapter(UploadsActivity.this, mUploadsList);
        recyclerUploads.setHasFixedSize(true);
        recyclerUploads.setLayoutManager(new LinearLayoutManager(UploadsActivity.this, LinearLayoutManager.VERTICAL, false));
        recyclerUploads.setAdapter(UploadsListAdapter);

    }


    @OnClick({R.id.Lnr_back, R.id.img_plus})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Lnr_back:
                finish();
                break;
            case R.id.img_plus:
                startActivity(new Intent(UploadsActivity.this, NewPostActivity.class));
                break;
        }
    }
}

package com.targetupsc.education.android.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.targetupsc.education.android.Adapter.OptionalListAdapter;
import com.targetupsc.education.android.Model.OptionalModel;
import com.targetupsc.education.android.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OptionalActivity extends AppCompatActivity {


    ArrayList<OptionalModel> mOptionalList;
    @BindView(R.id.recycler_optional)
    RecyclerView recyclerOptional;
    @BindView(R.id.btn_submit)
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optional);
        ButterKnife.bind(this);

        mOptionalList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            OptionalModel optionalModel = new OptionalModel();
            optionalModel.setTitle("Geography");
            mOptionalList.add(optionalModel);
        }

        OptionalListAdapter optionalListAdapter = new OptionalListAdapter(OptionalActivity.this, mOptionalList);
        recyclerOptional.setHasFixedSize(true);
        recyclerOptional.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerOptional.setAdapter(optionalListAdapter);
    }


    @OnClick(R.id.btn_submit)
    public void onViewClicked() {

        startActivity(new Intent(OptionalActivity.this,CategoryDetailActivity.class));

    }
}

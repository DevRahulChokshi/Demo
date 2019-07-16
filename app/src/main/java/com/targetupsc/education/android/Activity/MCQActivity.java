package com.targetupsc.education.android.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.targetupsc.education.android.Adapter.MCQListAdapter;
import com.targetupsc.education.android.Model.MCQModel;
import com.targetupsc.education.android.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MCQActivity extends AppCompatActivity {

    @BindView(R.id.Lnr_back)
    LinearLayout LnrBack;
    @BindView(R.id.recycler_mcq)
    RecyclerView recyclerMcq;

    ArrayList<MCQModel> mMCQList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcq);
        ButterKnife.bind(this);


        mMCQList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            MCQModel MCQModel = new MCQModel();
            mMCQList.add(MCQModel);
        }

        MCQListAdapter MCQListAdapter = new MCQListAdapter(MCQActivity.this, mMCQList);
        recyclerMcq.setHasFixedSize(true);
        recyclerMcq.setLayoutManager(new LinearLayoutManager(MCQActivity.this, LinearLayoutManager.VERTICAL, false));
        recyclerMcq.setAdapter(MCQListAdapter);
        
    }

    @OnClick(R.id.Lnr_back)
    public void onViewClicked() {
        finish();
    }
}

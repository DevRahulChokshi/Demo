package com.targetupsc.education.android.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.targetupsc.education.android.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyStudyMaterialQuestionsActivity extends AppCompatActivity {

    @BindView(R.id.Lnr_back)
    LinearLayout LnrBack;
    @BindView(R.id.txt_sr_no_1)
    TextView txtSrNo1;
    @BindView(R.id.txt_sr_no_2)
    TextView txtSrNo2;
    @BindView(R.id.txt_sr_no_3)
    TextView txtSrNo3;
    @BindView(R.id.txt_sr_no_4)
    TextView txtSrNo4;
    @BindView(R.id.btn_previous)
    Button btnPrevious;
    @BindView(R.id.btn_next)
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_study_material_questions);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.Lnr_back, R.id.btn_previous, R.id.btn_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Lnr_back:
                finish();
                break;
            case R.id.btn_previous:
                break;
            case R.id.btn_next:


                break;
        }
    }
}

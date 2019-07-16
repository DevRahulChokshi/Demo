package com.targetupsc.education.android.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.targetupsc.education.android.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserTypeActivity extends AppCompatActivity {

    @BindView(R.id.Lnr_school)
    LinearLayout LnrSchool;
    @BindView(R.id.Lnr_under_graduate)
    LinearLayout LnrUnderGraduate;
    @BindView(R.id.Lnr_exam_appearing)
    LinearLayout LnrExamAppearing;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    @BindView(R.id.txt_school)
    TextView txtSchool;
    @BindView(R.id.txt_under_graduation)
    TextView txtUnderGraduation;
    @BindView(R.id.txt_exam_Appearing)
    TextView txtExamAppearing;
    @BindView(R.id.img_school)
    ImageView imgSchool;
    @BindView(R.id.img_under_graduate)
    ImageView imgUnderGraduate;
    @BindView(R.id.img_exam_appearing)
    ImageView imgExamAppearing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_type);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.img_school, R.id.img_under_graduate, R.id.img_exam_appearing, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_school:

                txtSchool.setTextColor(getResources().getColor(R.color.colorred));
                txtExamAppearing.setTextColor(getResources().getColor(R.color.colorTextColor));
                txtUnderGraduation.setTextColor(getResources().getColor(R.color.colorTextColor));

                break;
            case R.id.img_under_graduate:

                txtSchool.setTextColor(getResources().getColor(R.color.colorTextColor));
                txtExamAppearing.setTextColor(getResources().getColor(R.color.colorTextColor));
                txtUnderGraduation.setTextColor(getResources().getColor(R.color.colorred));

                break;
            case R.id.img_exam_appearing:

                txtSchool.setTextColor(getResources().getColor(R.color.colorTextColor));
                txtExamAppearing.setTextColor(getResources().getColor(R.color.colorred));
                txtUnderGraduation.setTextColor(getResources().getColor(R.color.colorTextColor));

                break;
            case R.id.btn_submit:
                startActivity(new Intent(UserTypeActivity.this, OptionalActivity.class));
                break;
        }
    }

   /* @OnClick({R.id.Lnr_school, R.id.Lnr_under_graduate, R.id.Lnr_exam_appearing, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Lnr_school:

                LnrSchool.setBackground(getResources().getDrawable(R.drawable.bg_gradient_pink));
                LnrExamAppearing.setBackground(getResources().getDrawable(R.drawable.bg_rounded_gray_bordertransperent));
                LnrUnderGraduate.setBackground(getResources().getDrawable(R.drawable.bg_rounded_gray_bordertransperent));

                txtSchool.setTextColor(getResources().getColor(R.color.colorWhite));
                txtExamAppearing.setTextColor(getResources().getColor(R.color.colorTextColor));
                txtUnderGraduation.setTextColor(getResources().getColor(R.color.colorTextColor));
                break;
            case R.id.Lnr_under_graduate:

                LnrSchool.setBackground(getResources().getDrawable(R.drawable.bg_rounded_gray_bordertransperent));
                LnrExamAppearing.setBackground(getResources().getDrawable(R.drawable.bg_rounded_gray_bordertransperent));
                LnrUnderGraduate.setBackground(getResources().getDrawable(R.drawable.bg_gradient_pink));

                txtSchool.setTextColor(getResources().getColor(R.color.colorTextColor));
                txtExamAppearing.setTextColor(getResources().getColor(R.color.colorTextColor));
                txtUnderGraduation.setTextColor(getResources().getColor(R.color.colorWhite));

                break;
            case R.id.Lnr_exam_appearing:


                LnrSchool.setBackground(getResources().getDrawable(R.drawable.bg_rounded_gray_bordertransperent));
                LnrExamAppearing.setBackground(getResources().getDrawable(R.drawable.bg_gradient_pink));
                LnrUnderGraduate.setBackground(getResources().getDrawable(R.drawable.bg_rounded_gray_bordertransperent));

                txtSchool.setTextColor(getResources().getColor(R.color.colorTextColor));
                txtExamAppearing.setTextColor(getResources().getColor(R.color.colorWhite));
                txtUnderGraduation.setTextColor(getResources().getColor(R.color.colorTextColor));

                break;
            case R.id.btn_submit:

                startActivity(new Intent(UserTypeActivity.this,OptionalActivity.class));

                break;
        }
    }*/
}

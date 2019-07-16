package com.targetupsc.education.android.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.targetupsc.education.android.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class SettingActivity extends AppCompatActivity {

    @BindView(R.id.Lnr_back)
    LinearLayout LnrBack;
    @BindView(R.id.img_profile)
    CircleImageView imgProfile;
    @BindView(R.id.txt_name)
    TextView txtName;
    @BindView(R.id.txt_mobile)
    TextView txtMobile;
    @BindView(R.id.Lnr_profile)
    LinearLayout LnrProfile;
    @BindView(R.id.Lnr_study_material)
    LinearLayout LnrStudyMaterial;
    @BindView(R.id.Lnr_payment_history)
    LinearLayout LnrPaymentHistory;
    @BindView(R.id.Lnr_About_us)
    LinearLayout LnrAboutUs;
    @BindView(R.id.Lnr_Notification)
    LinearLayout LnrNotification;
    @BindView(R.id.Lnr_share_app)
    LinearLayout LnrShareApp;
    @BindView(R.id.Lnr_rate_App)
    LinearLayout LnrRateApp;
    @BindView(R.id.Lnr_terms_condition)
    LinearLayout LnrTermsCondition;
    @BindView(R.id.Lnr_feedback)
    LinearLayout LnrFeedback;
    @BindView(R.id.Lnr_logout)
    LinearLayout LnrLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.Lnr_back, R.id.Lnr_profile, R.id.Lnr_study_material, R.id.Lnr_payment_history, R.id.Lnr_About_us, R.id.Lnr_Notification, R.id.Lnr_share_app, R.id.Lnr_rate_App, R.id.Lnr_terms_condition, R.id.Lnr_feedback, R.id.Lnr_logout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Lnr_back:
                finish();
                break;
            case R.id.Lnr_profile:
                startActivity(new Intent(SettingActivity.this, ProfileActivity.class));
                break;
            case R.id.Lnr_study_material:
                startActivity(new Intent(SettingActivity.this, MyStudyMaterialActivity.class));
                break;
            case R.id.Lnr_payment_history:
                startActivity(new Intent(SettingActivity.this, PaymentHistoryActivity.class));
                break;
            case R.id.Lnr_About_us:
                startActivity(new Intent(SettingActivity.this, AboutUsActivity.class));

                break;
            case R.id.Lnr_Notification:
                startActivity(new Intent(SettingActivity.this, NotificationActivity.class));

                break;
            case R.id.Lnr_share_app:
                startActivity(new Intent(SettingActivity.this, ShareAppActivity.class));

                break;
            case R.id.Lnr_rate_App:
                break;
            case R.id.Lnr_terms_condition:
                break;
            case R.id.Lnr_feedback:
                break;
            case R.id.Lnr_logout:
                break;
        }
    }
}

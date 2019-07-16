package com.targetupsc.education.android.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.targetupsc.education.android.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends AppCompatActivity {

    @BindView(R.id.edt_name)
    EditText edtName;
    @BindView(R.id.edt_gmail)
    EditText edtGmail;
    @BindView(R.id.edt_mobile)
    EditText edtMobile;
    @BindView(R.id.edt_location)
    EditText edtLocation;
    @BindView(R.id.img_remember_me)
    ImageView imgRememberMe;
    @BindView(R.id.btn_signup)
    Button btnSignup;
    @BindView(R.id.txt_terms_conditions)
    TextView txtTermsConditions;
    @BindView(R.id.txt_register)
    TextView txtRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.img_remember_me, R.id.btn_signup, R.id.txt_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.txt_register:

                startActivity(new Intent(this, LoginActivity.class));
                finish();

                break;
            case R.id.img_remember_me:
                break;
            case R.id.btn_signup:


                final Dialog mBottomSheetDialog = new Dialog(SignUpActivity.this, R.style.MaterialDialogSheet);

                mBottomSheetDialog.setContentView(R.layout.dialog_otp_signup); // your custom view.
                mBottomSheetDialog.setCancelable(true);
                mBottomSheetDialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                mBottomSheetDialog.getWindow().setGravity(Gravity.BOTTOM);
                mBottomSheetDialog.show();


                Button btn_verify = mBottomSheetDialog.findViewById(R.id.btn_verify);
                btn_verify.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(SignUpActivity.this, UserTypeActivity.class));
                        finish();
                    }
                });


                break;
        }
    }
}

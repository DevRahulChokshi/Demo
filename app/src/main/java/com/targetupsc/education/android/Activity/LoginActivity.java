package com.targetupsc.education.android.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.edt_username)
    EditText edtUsername;
    @BindView(R.id.Lnr_username)
    LinearLayout LnrUsername;
    @BindView(R.id.edt_password)
    EditText edtPassword;
    @BindView(R.id.Lnr_password)
    LinearLayout LnrPassword;
    @BindView(R.id.img_remember_me)
    ImageView imgRememberMe;
    @BindView(R.id.btn_signup)
    Button btnSignup;
    @BindView(R.id.txt_register)
    TextView txtRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.img_remember_me, R.id.btn_signup, R.id.txt_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_remember_me:
                break;
            case R.id.btn_signup:

                startActivity(new Intent(this, CategoryDetailActivity.class));
                finish();
                break;
            case R.id.txt_register:

                startActivity(new Intent(this, SignUpActivity.class));
                finish();
                break;
        }
    }
}

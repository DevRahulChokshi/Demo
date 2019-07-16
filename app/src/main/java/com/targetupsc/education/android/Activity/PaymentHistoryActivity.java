package com.targetupsc.education.android.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.targetupsc.education.android.Model.PaymentHistoryModel;
import com.targetupsc.education.android.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PaymentHistoryActivity extends AppCompatActivity {

    @BindView(R.id.Lnr_back)
    LinearLayout LnrBack;
    @BindView(R.id.Lnr_Payment)
    LinearLayout LnrPayment;

    ArrayList<PaymentHistoryModel> mPaymentHistoryList;

    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_history);
        ButterKnife.bind(this);


        mPaymentHistoryList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            PaymentHistoryModel PaymentHistoryModel = new PaymentHistoryModel();
            mPaymentHistoryList.add(PaymentHistoryModel);
        }


        for (int j = 0; j < mPaymentHistoryList.size(); j++) {

            LayoutInflater inflater = LayoutInflater.from(PaymentHistoryActivity.this);
            LinearLayout view = (LinearLayout) inflater.inflate(R.layout.row_payment_history, null);

            LnrPayment.addView(view);
        }

    }

    @OnClick(R.id.Lnr_back)
    public void onViewClicked() {
        finish();
    }
}

package com.targetupsc.education.android.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.targetupsc.education.android.Adapter.NotificationListAdapter;
import com.targetupsc.education.android.Model.NotificationModel;
import com.targetupsc.education.android.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NotificationActivity extends AppCompatActivity {

    ArrayList<NotificationModel> mNotificationList;
    @BindView(R.id.recycler_notification)
    RecyclerView recyclerNotification;
    @BindView(R.id.Lnr_back)
    LinearLayout LnrBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);


        mNotificationList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            NotificationModel NotificationModel = new NotificationModel();
            mNotificationList.add(NotificationModel);
        }

        NotificationListAdapter NotificationListAdapter = new NotificationListAdapter(NotificationActivity.this, mNotificationList);
        recyclerNotification.setHasFixedSize(true);
        recyclerNotification.setLayoutManager(new LinearLayoutManager(NotificationActivity.this, LinearLayoutManager.VERTICAL, false));
        recyclerNotification.setAdapter(NotificationListAdapter);
    }

    @OnClick(R.id.Lnr_back)
    public void onViewClicked() {
        finish();
    }
}

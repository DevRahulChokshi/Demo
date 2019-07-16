package com.targetupsc.education.android.Adapter;

/*
public class OptionalListAdapter {
}
*/

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.targetupsc.education.android.Model.NotificationModel;
import com.targetupsc.education.android.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationListAdapter extends RecyclerView.Adapter<NotificationListAdapter.CustomViewHolder> {


    private ArrayList<NotificationModel> OptionalList;
    Context mContext;


    //--------------------------------------------------------------------------------------------------------------
    public class CustomViewHolder extends RecyclerView.ViewHolder {



        CustomViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, itemView);

        }


    }
//---------------------------------------------------------------------------------------------------------------------


    //------------------------------------------------------------------------------------------------------------------
    public NotificationListAdapter(Context mContext, ArrayList<NotificationModel> OptionalList) {
        this.OptionalList = OptionalList;
        this.mContext = mContext;

    }


//----------------------------------------------------------------------------------------------------------------


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_notification, viewGroup, false);

        final CustomViewHolder holder = new CustomViewHolder(itemView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
        return holder;
    }


    @Override
    public void onBindViewHolder(final CustomViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return (null != OptionalList ? OptionalList.size() : 0);
    }


}



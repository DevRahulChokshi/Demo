package com.targetupsc.education.android.Adapter;

/*
public class UploadsListAdapter {
}
*/

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.targetupsc.education.android.Activity.CategoryDetailActivity;
import com.targetupsc.education.android.Activity.TestSeriesGridListActivity;
import com.targetupsc.education.android.Model.UploadsModel;
import com.targetupsc.education.android.R;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class UploadsListAdapter extends RecyclerView.Adapter<UploadsListAdapter.CustomViewHolder> {


    private ArrayList<UploadsModel> UploadsList;
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
    public UploadsListAdapter(Context mContext, ArrayList<UploadsModel> UploadsList) {
        this.UploadsList = UploadsList;
        this.mContext = mContext;

    }


//----------------------------------------------------------------------------------------------------------------


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_upload, viewGroup, false);

        final CustomViewHolder holder = new CustomViewHolder(itemView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.startActivity(new Intent(mContext, CategoryDetailActivity.class));

            }
        });
        return holder;
    }


    @Override
    public void onBindViewHolder(final CustomViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return (null != UploadsList ? UploadsList.size() : 0);
    }


}



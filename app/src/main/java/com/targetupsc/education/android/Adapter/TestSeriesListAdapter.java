package com.targetupsc.education.android.Adapter;

/*
public class OptionalListAdapter {
}
*/

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.targetupsc.education.android.Activity.TestSeriesGridListActivity;
import com.targetupsc.education.android.Model.TestSeriesModel;
import com.targetupsc.education.android.R;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class TestSeriesListAdapter extends RecyclerView.Adapter<TestSeriesListAdapter.CustomViewHolder> {


    private ArrayList<TestSeriesModel> OptionalList;
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
    public TestSeriesListAdapter(Context mContext, ArrayList<TestSeriesModel> OptionalList) {
        this.OptionalList = OptionalList;
        this.mContext = mContext;

    }


//----------------------------------------------------------------------------------------------------------------


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_test_series, viewGroup, false);

        final CustomViewHolder holder = new CustomViewHolder(itemView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.startActivity(new Intent(mContext, TestSeriesGridListActivity.class));

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



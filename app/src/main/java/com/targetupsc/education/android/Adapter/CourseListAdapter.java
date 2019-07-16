package com.targetupsc.education.android.Adapter;

/*
public class mCoursePdfListAdapter {
}
*/

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.targetupsc.education.android.Activity.TestSerisCongratulationsActivity;
import com.targetupsc.education.android.Model.CourseModel;
import com.targetupsc.education.android.R;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.CustomViewHolder> {


    private ArrayList<CourseModel> mCoursePdfList;
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
    public CourseListAdapter(Context mContext, ArrayList<CourseModel> mCoursePdfList) {
        this.mCoursePdfList = mCoursePdfList;
        this.mContext = mContext;

    }


//----------------------------------------------------------------------------------------------------------------


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_course, viewGroup, false);

        final CustomViewHolder holder = new CustomViewHolder(itemView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mContext.startActivity(new Intent(mContext, TestSerisCongratulationsActivity.class));
            }
        });
        return holder;
    }


    @Override
    public void onBindViewHolder(final CustomViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return (null != mCoursePdfList ? mCoursePdfList.size() : 0);
    }


}



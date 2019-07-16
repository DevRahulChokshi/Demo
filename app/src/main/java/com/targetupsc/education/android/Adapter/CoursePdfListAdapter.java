package com.targetupsc.education.android.Adapter;

/*
public class mCoursePdfListAdapter {
}
*/

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.targetupsc.education.android.Model.CoursePdfMyStudyMaterialModel;
import com.targetupsc.education.android.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CoursePdfListAdapter extends RecyclerView.Adapter<CoursePdfListAdapter.CustomViewHolder> {


    private ArrayList<CoursePdfMyStudyMaterialModel> mCoursePdfList;
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
    public CoursePdfListAdapter(Context mContext, ArrayList<CoursePdfMyStudyMaterialModel> mCoursePdfList) {
        this.mCoursePdfList = mCoursePdfList;
        this.mContext = mContext;

    }


//----------------------------------------------------------------------------------------------------------------


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_course_pdf, viewGroup, false);

        final CustomViewHolder holder = new CustomViewHolder(itemView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //ChangeSelection(holder.getAdapterPosition());
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



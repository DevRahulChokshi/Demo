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
import android.widget.Button;
import android.widget.TextView;

import com.targetupsc.education.android.Activity.MCQQuestionActivity;
import com.targetupsc.education.android.Model.MCQModel;
import com.targetupsc.education.android.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MCQListAdapter extends RecyclerView.Adapter<MCQListAdapter.CustomViewHolder> {


    private ArrayList<MCQModel> OptionalList;
    Context mContext;


    //--------------------------------------------------------------------------------------------------------------
    public class CustomViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_date)
        TextView txtDate;
        @BindView(R.id.btn_start)
        Button btnStart;

        CustomViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, itemView);

        }


    }
//---------------------------------------------------------------------------------------------------------------------


    //------------------------------------------------------------------------------------------------------------------
    public MCQListAdapter(Context mContext, ArrayList<MCQModel> OptionalList) {
        this.OptionalList = OptionalList;
        this.mContext = mContext;

    }


//----------------------------------------------------------------------------------------------------------------


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_mcq, viewGroup, false);

        final CustomViewHolder holder = new CustomViewHolder(itemView);

        holder.btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.startActivity(new Intent(mContext, MCQQuestionActivity.class));

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



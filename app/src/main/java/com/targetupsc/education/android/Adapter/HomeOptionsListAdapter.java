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
import android.widget.TextView;

import com.targetupsc.education.android.Activity.UploadsActivity;
import com.targetupsc.education.android.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeOptionsListAdapter extends RecyclerView.Adapter<HomeOptionsListAdapter.CustomViewHolder> {


    private ArrayList<String> OptionalList;
    Context mContext;


    //--------------------------------------------------------------------------------------------------------------
    public class CustomViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_options)
        TextView txtOptions;

        CustomViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, itemView);

        }


    }
//---------------------------------------------------------------------------------------------------------------------


    //------------------------------------------------------------------------------------------------------------------
    public HomeOptionsListAdapter(Context mContext, ArrayList<String> OptionalList) {
        this.OptionalList = OptionalList;
        this.mContext = mContext;

    }


//----------------------------------------------------------------------------------------------------------------


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_home_options, viewGroup, false);

        final CustomViewHolder holder = new CustomViewHolder(itemView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(OptionalList.get(holder.getAdapterPosition()).equals("Uploads")){
                    mContext.startActivity(new Intent(mContext, UploadsActivity.class));
                }
            }
        });
        return holder;
    }


    @Override
    public void onBindViewHolder(final CustomViewHolder holder, int position) {

        holder.txtOptions.setText(OptionalList.get(position));


    }

    @Override
    public int getItemCount() {
        return (null != OptionalList ? OptionalList.size() : 0);
    }





}



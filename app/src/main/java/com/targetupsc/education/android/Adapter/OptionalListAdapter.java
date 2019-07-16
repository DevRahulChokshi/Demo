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

import com.targetupsc.education.android.Model.OptionalModel;
import com.targetupsc.education.android.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OptionalListAdapter extends RecyclerView.Adapter<OptionalListAdapter.CustomViewHolder> {


    private ArrayList<OptionalModel> OptionalList;
Context mContext;


    //--------------------------------------------------------------------------------------------------------------
    public class CustomViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.txt_title)
        TextView txtTitle;


        CustomViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, itemView);

        }


    }
//---------------------------------------------------------------------------------------------------------------------


    //------------------------------------------------------------------------------------------------------------------
    public OptionalListAdapter(Context mContext, ArrayList<OptionalModel> OptionalList) {
        this.OptionalList = OptionalList;
        this.mContext = mContext;

    }


//----------------------------------------------------------------------------------------------------------------


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_optional, viewGroup, false);

        final CustomViewHolder holder = new CustomViewHolder(itemView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ChangeSelection(holder.getAdapterPosition());
            }
        });
        return holder;
    }


    @Override
    public void onBindViewHolder(final CustomViewHolder holder, int position) {

        holder.txtTitle.setText(OptionalList.get(position).getTitle());

        if(OptionalList.get(position).isSelected()){
            holder.txtTitle.setTextColor(mContext.getResources().getColor(R.color.colorred));
        }else{
            holder.txtTitle.setTextColor(mContext.getResources().getColor(R.color.colorTextColor));
        }
    }

    @Override
    public int getItemCount() {
        return (null != OptionalList ? OptionalList.size() : 0);
    }


    private void ChangeSelection(int adapterPosition) {

        for (int i = 0; i < OptionalList.size(); i++) {
            if (i == adapterPosition) {
                OptionalList.get(i).setSelected(true);
            } else {
                OptionalList.get(i).setSelected(false);
            }
        }


        OptionalListAdapter.this.notifyDataSetChanged();
    }


}



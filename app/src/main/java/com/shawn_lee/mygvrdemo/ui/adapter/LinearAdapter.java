package com.shawn_lee.mygvrdemo.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shawn_lee.mygvrdemo.R;
import com.shawn_lee.mygvrdemo.ui.model.Photo;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 祥 on 2016/7/23.
 */
public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.LinearViewHolder> {

    private List<Photo.Result> data;
    private Context context;

    public LinearAdapter(List<Photo.Result> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_linear, parent, false);
        return new LinearViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LinearViewHolder holder, int position) {
        holder.tv_linear.setText(data.get(position).getDesc());
        Picasso.with(context)
                .load(data.get(position).getUrl())
                .into(holder.iv_linear);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    protected class LinearViewHolder extends RecyclerView.ViewHolder{

        private ImageView iv_linear;
        private TextView tv_linear;
        public LinearViewHolder(View itemView) {
            super(itemView);
            iv_linear = (ImageView) itemView.findViewById(R.id.iv_linear);
            tv_linear = (TextView) itemView.findViewById(R.id.tv_linear);
        }
    }

    public void setData(List<Photo.Result> data) {
        this.data = data;
    }
}

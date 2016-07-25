package com.shawn_lee.mygvrdemo.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.shawn_lee.mygvrdemo.R;
import com.shawn_lee.mygvrdemo.ui.model.Photo;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 祥 on 2016/7/23.
 */
public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {

    private List<Photo.Result> data;
    private Context context;

    public GridAdapter(List<Photo.Result> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_grid, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, int position) {
        Picasso.with(context)
                .load(data.get(position).getUrl())
                .into(holder.iv_grid);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    protected class GridViewHolder extends RecyclerView.ViewHolder{

        private ImageView iv_grid;
        public GridViewHolder(View itemView) {
            super(itemView);
            iv_grid = (ImageView) itemView.findViewById(R.id.iv_grid);
        }
    }
}

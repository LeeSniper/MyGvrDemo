package com.shawn_lee.mygvrdemo.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.shawn_lee.mygvrdemo.R;
import com.shawn_lee.mygvrdemo.ui.model.Photo;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.List;

/**
 * Created by 祥 on 2016/7/23.
 */
public class StaggeredAdapter extends RecyclerView.Adapter<StaggeredAdapter.StaggeredViewHolder> {

    private List<Photo.Result> data;
    private Context context;

    public StaggeredAdapter(List<Photo.Result> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public StaggeredViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_staggered, parent, false);
        return new StaggeredViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final StaggeredViewHolder holder, int position) {
        //对图片进行处理
        Transformation transformation = new Transformation() {
            @Override
            public Bitmap transform(Bitmap source) {
                //根据容器宽度和图片宽高比，生成缩小后的图片
                int targetWidth = holder.iv_staggered.getWidth();
                double ratio = (double) source.getHeight()/(double) source.getWidth();
                int targetaHight = (int) (ratio*targetWidth);
                Bitmap scaledBitmap = Bitmap.createScaledBitmap(source, targetWidth, targetaHight, false);
                //缩放之后，释放原图片资源
                if (scaledBitmap != source){
                    source.recycle();
                }
                return scaledBitmap;
            }

            @Override
            public String key() {
                return "StaggeredTransformation";
            }
        };
        //加载网络图片
        Picasso.with(context)
                .load(data.get(position).getUrl())
                .transform(transformation)
                .into(holder.iv_staggered);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    protected class StaggeredViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_staggered;
        public StaggeredViewHolder(View itemView) {
            super(itemView);
            iv_staggered = (ImageView) itemView.findViewById(R.id.iv_staggered);
        }
    }
}

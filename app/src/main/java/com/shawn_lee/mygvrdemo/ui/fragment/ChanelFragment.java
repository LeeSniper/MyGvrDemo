package com.shawn_lee.mygvrdemo.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.shawn_lee.mygvrdemo.R;

/**
 * Created by 祥 on 2016/7/18.
 */
public class ChanelFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private int[] imageIds = {R.drawable.ic_show,R.drawable.ic_stars,R.drawable.ic_music,R.drawable.ic_original,R.drawable.ic_travel,
            R.drawable.ic_edu,R.drawable.ic_extreme,R.drawable.ic_news,R.drawable.ic_car,R.drawable.ic_anime};
    private String[] titles = {"爱秀","明星","音乐","原创","旅游","教育","极限","资讯","汽车","二次元"};
    private LayoutInflater mInflater;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chanel, container, false);
        mInflater = getActivity().getLayoutInflater();
        ImageButton ibtn_history = (ImageButton) view.findViewById(R.id.ibtn_history);
        ImageButton ibtn_search = (ImageButton) view.findViewById(R.id.ibtn_search);
        GridView gv_chanel = (GridView) view.findViewById(R.id.gv_chanel);
        ibtn_history.setVisibility(View.GONE);
        ibtn_search.setOnClickListener(this);
        gv_chanel.setAdapter(new ChanelAdapter());
        gv_chanel.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    private class ChanelAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return imageIds.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null){
                holder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.item_chanel,null);
                holder.icon_item_chanel = (ImageView) convertView.findViewById(R.id.icon_item_chanel);
                holder.title_item_chanel = (TextView) convertView.findViewById(R.id.title_item_chanel);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.icon_item_chanel.setImageResource(imageIds[position]);
            holder.title_item_chanel.setText(titles[position]);
            return convertView;
        }
    }

    private class ViewHolder {
        private ImageView icon_item_chanel;
        private TextView title_item_chanel;
    }
}

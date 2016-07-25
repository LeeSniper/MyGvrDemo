package com.shawn_lee.mygvrdemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shawn_lee.mygvrdemo.R;
import com.shawn_lee.mygvrdemo.ui.adapter.StaggeredAdapter;
import com.shawn_lee.mygvrdemo.ui.model.Photo;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 祥 on 2016/7/11.
 */
public class RecyclerHomeThree extends android.support.v4.app.Fragment {
    protected List<Photo.Result> data = new ArrayList<>();
    private StaggeredAdapter staggeredAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_three, container, false);
        RecyclerView rv_home03 = (RecyclerView) view.findViewById(R.id.rv_home03);
        rv_home03.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        rv_home03.setAdapter(staggeredAdapter);
        return view;
    }

    public void setStaggeredAdapter(StaggeredAdapter staggeredAdapter) {
        this.staggeredAdapter = staggeredAdapter;
    }
}

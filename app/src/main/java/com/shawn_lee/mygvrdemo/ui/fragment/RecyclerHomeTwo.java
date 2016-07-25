package com.shawn_lee.mygvrdemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shawn_lee.mygvrdemo.R;
import com.shawn_lee.mygvrdemo.ui.adapter.GridAdapter;
import com.shawn_lee.mygvrdemo.ui.model.Photo;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 祥 on 2016/7/11.
 */
public class RecyclerHomeTwo extends android.support.v4.app.Fragment {
    protected List<Photo.Result> data = new ArrayList<>();
    private GridAdapter gridAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_two, container, false);
        RecyclerView rv_home02 = (RecyclerView) view.findViewById(R.id.rv_home02);
        rv_home02.setLayoutManager(new GridLayoutManager(getContext(),3));
        rv_home02.setAdapter(gridAdapter);
        return view;
    }

    public void setGridAdapter(GridAdapter gridAdapter) {
        this.gridAdapter = gridAdapter;
    }
}

package com.shawn_lee.mygvrdemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shawn_lee.mygvrdemo.R;
import com.shawn_lee.mygvrdemo.ui.adapter.LinearAdapter;


/**
 * Created by 祥 on 2016/7/11.
 */
public class RecyclerHomeOne extends android.support.v4.app.Fragment{
    protected RecyclerView recyclerView;
    private LinearAdapter linearAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_one, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_home01);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(linearAdapter);
        return view;
    }

    public void setLinearAdapter(LinearAdapter linearAdapter) {
        this.linearAdapter = linearAdapter;
    }
}

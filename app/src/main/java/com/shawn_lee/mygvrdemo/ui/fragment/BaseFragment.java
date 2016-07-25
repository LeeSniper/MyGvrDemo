package com.shawn_lee.mygvrdemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 祥 on 2016/7/11.
 */
public abstract class BaseFragment extends android.support.v4.app.Fragment {

    private Bundle savedState;
    protected FragmentManager fragmentManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView(inflater,container,savedInstanceState);
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        //判断是否有保存的状态，如果有则恢复之前的状态，如果没有，则进行第一次加载的初始化操作
//        if (!restoreStateFromArgument()) {
//            onFirstTimeLaunched();
//        }
//    }
//
//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        saveStateToArguments();
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        saveStateToArguments();
//    }
//
//    //Don't Touch!
//    private void saveStateToArguments() {
//        if (getView() != null){
//            savedState = saveState();
//        }
//        if (savedState != null){
//            Bundle b = getArguments();
//            b.putBundle("internalSavedViewState",savedState);
//        }
//    }
//
//    //Don't Touch!
//    private boolean restoreStateFromArgument() {
//        Bundle b = getArguments();
//        if (b != null) {
//            savedState = b.getBundle("internalSavedViewState");
//        }
//        if (savedState != null) {
//            restoreState(savedState);
//            return true;
//        }
//        return false;
//    }
//
    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }
//
//    //第一次加载的时候进行的初始化操作
//    protected abstract void onFirstTimeLaunched();
//
//    //保存状态和恢复状态时需要进行的操作
//    protected abstract Bundle saveState();
//    protected abstract void restoreState(Bundle savedState);

    //初始化View和初始化数据
    protected abstract View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);
    protected abstract void initData();
}

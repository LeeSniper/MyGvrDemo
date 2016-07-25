package com.shawn_lee.mygvrdemo.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shawn_lee.mygvrdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 祥 on 2016/7/18.
 */
public class HomeFragment extends BaseFragment {
    protected TabLayout tabLayout_home;
    protected ViewPager viewpager_home;
    private List<String> titleList = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        initData();
        tabLayout_home = (TabLayout) view.findViewById(R.id.tabLayout_home);
        viewpager_home = (ViewPager) view.findViewById(R.id.viewpager_home);
        viewpager_home.setAdapter(new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }
            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titleList.get(position);
            }
        });
        tabLayout_home.setupWithViewPager(viewpager_home);
        return view;
    }

    @Override
    protected void initData() {
        titleList.add("线性布局");
        titleList.add("表格布局");
        titleList.add("瀑布流布局");
        fragments.add(new RecyclerHomeOne());
        fragments.add(new RecyclerHomeTwo());
        fragments.add(new RecyclerHomeThree());
    }

    public List<Fragment> getFragments() {
        return fragments;
    }
}

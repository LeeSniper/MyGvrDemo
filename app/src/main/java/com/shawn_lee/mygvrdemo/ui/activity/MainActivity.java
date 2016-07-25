package com.shawn_lee.mygvrdemo.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.shawn_lee.mygvrdemo.R;
import com.shawn_lee.mygvrdemo.ui.adapter.GridAdapter;
import com.shawn_lee.mygvrdemo.ui.adapter.LinearAdapter;
import com.shawn_lee.mygvrdemo.ui.adapter.StaggeredAdapter;
import com.shawn_lee.mygvrdemo.ui.fragment.BaseFragment;
import com.shawn_lee.mygvrdemo.ui.fragment.ChanelFragment;
import com.shawn_lee.mygvrdemo.ui.fragment.ExploreFragment;
import com.shawn_lee.mygvrdemo.ui.fragment.HomeFragment;
import com.shawn_lee.mygvrdemo.ui.fragment.MineFragment;
import com.shawn_lee.mygvrdemo.ui.fragment.RecyclerHomeOne;
import com.shawn_lee.mygvrdemo.ui.fragment.RecyclerHomeThree;
import com.shawn_lee.mygvrdemo.ui.fragment.RecyclerHomeTwo;
import com.shawn_lee.mygvrdemo.ui.model.Photo;
import com.shawn_lee.mygvrdemo.ui.utils.GankAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

public class MainActivity extends FragmentActivity {
    private ViewPager viewPager;
    private List<Fragment> fragmentList;
    protected TabLayout tabLayout_main;
    protected FragmentManager fragmentManager;
    protected List<Photo.Result> data = new ArrayList<>();
    protected LinearAdapter linearAdapter = new LinearAdapter(data,this);
    protected GridAdapter gridAdapter = new GridAdapter(data,this);
    protected StaggeredAdapter staggeredAdapter = new StaggeredAdapter(data,this);
    protected Handler myHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0x123) {
                linearAdapter.notifyDataSetChanged();
                gridAdapter.notifyDataSetChanged();
                staggeredAdapter.notifyDataSetChanged();
                LinearAdapter linearAdapter = new LinearAdapter(data,MainActivity.this);
                GridAdapter gridAdapter = new GridAdapter(data,MainActivity.this);
                StaggeredAdapter staggeredAdapter = new StaggeredAdapter(data,MainActivity.this);
                HomeFragment homeFragment = (HomeFragment) fragmentList.get(0);
                RecyclerHomeOne fragment1 = (RecyclerHomeOne) homeFragment.getFragments().get(0);
                RecyclerHomeTwo fragment2 = (RecyclerHomeTwo) homeFragment.getFragments().get(1);
                RecyclerHomeThree fragment3 = (RecyclerHomeThree) homeFragment.getFragments().get(2);
                fragment1.setLinearAdapter(linearAdapter);
                fragment2.setGridAdapter(gridAdapter);
                fragment3.setStaggeredAdapter(staggeredAdapter);
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getResult(1);
        initData();
        initView();
    }

    protected void initData() {
        fragmentList = new ArrayList<>();
        HomeFragment homeFragment = new HomeFragment();
        fragmentList.add(homeFragment);
        ChanelFragment chanelFragment = new ChanelFragment();
        fragmentList.add(chanelFragment);
        ExploreFragment exploreFragment = new ExploreFragment();
        fragmentList.add(exploreFragment);
        MineFragment mineFragment = new MineFragment();
        fragmentList.add(mineFragment);
    }

    protected void initView() {
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setOffscreenPageLimit(3);
        tabLayout_main = (TabLayout) findViewById(R.id.tabLayout_main);
        fragmentManager = getSupportFragmentManager();
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(fragmentManager) {
            @Override
            public int getCount() {
                return fragmentList.size();
            }

            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        BaseFragment fragment = (BaseFragment) fragmentList.get(position);
                        fragment.setFragmentManager(fragmentManager);
                        return fragmentList.get(position);
                    case 1:
                        return fragmentList.get(position);
                    case 2:
                        return fragmentList.get(position);
                    case 3:
                        return fragmentList.get(position);
                }
                return null;
            }
        };
        viewPager.setAdapter(adapter);
        TabLayout.TabLayoutOnPageChangeListener onPageChangeListener = new TabLayout.TabLayoutOnPageChangeListener(tabLayout_main);
        viewPager.addOnPageChangeListener(onPageChangeListener);
        tabLayout_main.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                switch (tab.getPosition()) {
                    case 0:
                        tab.setIcon(R.drawable.ic_home_selected);
                        break;
                    case 1:
                        tab.setIcon(R.drawable.ic_explore_selected);
                        break;
                    case 2:
                        tab.setIcon(R.drawable.ic_notifications_selected);
                        break;
                    case 3:
                        tab.setIcon(R.drawable.ic_person_selected);
                        break;
                    default:
                        break;
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        tab.setIcon(R.drawable.ic_home);
                        break;
                    case 1:
                        tab.setIcon(R.drawable.ic_explore);
                        break;
                    case 2:
                        tab.setIcon(R.drawable.ic_notifications);
                        break;
                    case 3:
                        tab.setIcon(R.drawable.ic_person);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void getResult(int page) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://gank.io/api/data/福利/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        GankAPI gankAPI = retrofit.create(GankAPI.class);
        Call<Photo> photoCall = gankAPI.getPhoto(page);
        photoCall.enqueue(new Callback<Photo>() {
            @Override
            public void onResponse(Response<Photo> response, Retrofit retrofit) {
                data = response.body().getResults();
                myHandler.sendEmptyMessage(0x123);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    public GridAdapter getGridAdapter() {
        return gridAdapter;
    }

    public LinearAdapter getLinearAdapter() {
        return linearAdapter;
    }

    public StaggeredAdapter getStaggeredAdapter() {
        return staggeredAdapter;
    }
}

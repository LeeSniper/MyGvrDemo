package com.shawn_lee.mygvrdemo.ui.utils;

import com.shawn_lee.mygvrdemo.ui.model.Photo;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by 祥 on 2016/7/19.
 */
public interface GankAPI {
    @GET("20/{page}")
    Call<Photo> getPhoto(@Path("page") int page);
}

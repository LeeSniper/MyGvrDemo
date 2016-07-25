package com.shawn_lee.mygvrdemo.ui.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.vr.sdk.widgets.pano.VrPanoramaEventListener;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;
import com.shawn_lee.mygvrdemo.R;
import com.shawn_lee.mygvrdemo.ui.activity.VrVideoActivity;

/**
 * Created by 祥 on 2016/7/18.
 */
public class ExploreFragment extends android.support.v4.app.Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explore, container, false);
        VrPanoramaView vr_panorama = (VrPanoramaView) view.findViewById(R.id.vr_panorama);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fullscreenpic);
        vr_panorama.loadImageFromBitmap(bitmap, new VrPanoramaView.Options());
        VrListener listener = new VrListener();
        vr_panorama.setEventListener(listener);
        return view;
    }

    protected class VrListener extends VrPanoramaEventListener {
        @Override
        public void onClick() {
            Intent intent = new Intent(getContext(), VrVideoActivity.class);
            startActivity(intent);
        }
    }

}

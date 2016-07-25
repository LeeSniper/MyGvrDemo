package com.shawn_lee.mygvrdemo.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.google.vr.sdk.widgets.video.VrVideoEventListener;
import com.google.vr.sdk.widgets.video.VrVideoView;
import com.shawn_lee.mygvrdemo.R;

import java.io.IOException;

/**
 * Created by 祥 on 2016/7/15.
 */
public class VrVideoActivity extends Activity {
    private VrVideoView vrVideoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vrvideo);
        vrVideoView = (VrVideoView) findViewById(R.id.vrVideoView);
        VrVideoListener listener = new VrVideoListener();
        vrVideoView.setEventListener(listener);

        try {
            vrVideoView.loadVideoFromAsset("vrvideodemo.mp4");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    protected class VrVideoListener extends VrVideoEventListener {
        @Override
        public void onLoadSuccess() {
            Log.e("VrVideoActivity","loadSuccess");
            vrVideoView.playVideo();
        }

        @Override
        public void onLoadError(String errorMessage) {
            Log.e("VrVideoActivity","loadError");
        }
    }
}

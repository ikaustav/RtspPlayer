package com.android.kaustavghosh.rtspplayer.view;

import android.app.Activity;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.android.kaustavghosh.rtspplayer.R;
import com.android.kaustavghosh.rtspplayer.contract.VideoContract;
import com.android.kaustavghosh.rtspplayer.presenter.VideoPresenter;


/**
 * View layer of MVP
 *
 * Created by kaustavghosh on 12/09/17.
* */
public class MainActivity extends Activity implements VideoContract.View {

    VideoContract.Presenter mPresenter;
    VideoView mVideoView;

    //initialization during creation of activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize the components
        mPresenter = new VideoPresenter(this);
        mVideoView = (VideoView) findViewById(R.id.myVideo);

        //start from the last video position if available
        int position = 0;
        if (savedInstanceState != null) {
            position = savedInstanceState.getInt("position");
        }

        showVideo(position);
    }

    //onConfigurationChange does not destroy the activity
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    //save state of the video before destruction
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //if video is playing then save the position before destroying the activity
        if (mVideoView.isPlaying())
            outState.putInt("position", mVideoView.getCurrentPosition());
    }

    //initialize the video
    @Override
    public void showVideo(int position) {
        //set the video properties
        mPresenter.setVideo();

        //initialize the video
        mPresenter.initVideo(position);
    }

    //bind the video to MediaController and start the video
    @Override
    public void startVideo(Uri uri, int position) {
        mVideoView.setVideoURI(uri);

        MediaController vidControl = new MediaController(this);
        vidControl.setAnchorView(mVideoView);
        mVideoView.setMediaController(vidControl);

        mVideoView.seekTo(position);
        mVideoView.start();
    }
}

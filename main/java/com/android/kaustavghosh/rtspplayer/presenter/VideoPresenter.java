package com.android.kaustavghosh.rtspplayer.presenter;

import android.net.Uri;

import com.android.kaustavghosh.rtspplayer.constants.Constant;
import com.android.kaustavghosh.rtspplayer.contract.VideoContract;
import com.android.kaustavghosh.rtspplayer.model.Video;

import java.net.URI;

/**
 * Presenter layer of MVP
 *
 * Created by kaustavghosh on 12/09/17.
 */

public class VideoPresenter implements VideoContract.Presenter {

    private Video mVideo;
    private VideoContract.View mView;

    //initialize model and view
    public VideoPresenter(VideoContract.View view){
        mVideo = new Video();
        mView = view;
    }

    //set video properties
    @Override
    public void setVideo() {
        Uri uri = Uri.parse(Constant.VIDEO_URI);
        mVideo.setUri(uri);
    }

    //start video with all the properties initialized
    @Override
    public void initVideo(int position) {
        mView.startVideo(mVideo.getUri(), position);
    }
}

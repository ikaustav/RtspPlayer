package com.android.kaustavghosh.rtspplayer.contract;

import android.net.Uri;

/**
 * Contract for View and Presenter layer in MVP
 *
 * Created by kaustavghosh on 12/09/17.
 */

public interface VideoContract {
    //Contract for view
    interface View {
        void showVideo(int position);

        void startVideo(Uri uri, int position);
    }

    //contract for presenter
    interface Presenter {
        void setVideo();

        void initVideo(int position);
    }
}

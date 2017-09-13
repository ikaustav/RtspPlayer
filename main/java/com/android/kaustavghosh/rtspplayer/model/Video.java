package com.android.kaustavghosh.rtspplayer.model;

import android.net.Uri;

/**
 * Model layer of MVP
 *
 * Created by kaustavghosh on 12/09/17.
 */

public class Video {
    //properties of the video
    private Uri mUri;

    public void setUri(Uri uri) {
        mUri = uri;
    }

    public Uri getUri() {
        return mUri;

    }
}

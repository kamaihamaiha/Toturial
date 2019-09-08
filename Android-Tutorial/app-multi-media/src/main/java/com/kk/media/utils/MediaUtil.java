package com.kk.media.utils;


import android.content.Context;
import android.media.MediaPlayer;
import com.kk.media.R;


/**
 * 媒体播放工具
 */

public class MediaUtil {

    private static final String TAG = "MediaUtil";
    private MediaPlayer player;

    private MediaUtil(Context context) {
        player = MediaPlayer.create(context.getApplicationContext(), R.raw.sound);

    }

    private static MediaUtil instance;

    public static MediaUtil getInstance() {

        return instance;
    }

    public static void init(Context context){
        instance = new MediaUtil(context);
    }


    public void play() {
        if (!player.isPlaying()) {
            player.start();
        }
    }


    public void stop() {

        if (player != null && player.isPlaying()) {

            player.stop();

        }

    }


    /**
     * 释放播放器资源
     */
    public void ReleasePlayer() {
        if (player != null) {
            player.stop();
            player.release();
            player = null;
        }

    }


}


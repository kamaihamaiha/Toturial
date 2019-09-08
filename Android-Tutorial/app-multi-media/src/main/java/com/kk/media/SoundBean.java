package com.kk.media;

import android.media.MediaPlayer;

public class SoundBean {
    private String order;
    private String name;
    private String filePath;
    private MediaPlayer mediaPlayer = new MediaPlayer();

    public SoundBean(String order, String name, String filePath) {
        this.order = order;
        this.name = name;
        this.filePath = filePath;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }
}

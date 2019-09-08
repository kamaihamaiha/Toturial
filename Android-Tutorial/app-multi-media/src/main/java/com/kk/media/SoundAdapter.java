package com.kk.media;

import android.media.MediaPlayer;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SoundAdapter extends RecyclerView.Adapter<SoundAdapter.SoundViewHolder> {
    private List<SoundBean> mList;

    public SoundAdapter(List<SoundBean> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public SoundViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sound_item, viewGroup, false);
        return new SoundViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull SoundViewHolder soundViewHolder, int i) {
        final SoundBean soundBean = mList.get(i);
        soundViewHolder.order.setText(soundBean.getOrder());
        soundViewHolder.name.setText(soundBean.getName());
        final MediaPlayer mediaPlayer = soundBean.getMediaPlayer();
        initMediaPlayer(mediaPlayer, soundBean.getFilePath());
        soundViewHolder.play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                }
            }
        });
        soundViewHolder.stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
            }
        });
        soundViewHolder.reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.reset();
                    initMediaPlayer(mediaPlayer, soundBean.getFilePath());
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    class SoundViewHolder extends RecyclerView.ViewHolder {

        View soundView;
        TextView order;
        TextView name;
        Button play;
        Button stop;
        Button reset;

        public SoundViewHolder(@NonNull View itemView) {
            super(itemView);
            soundView = itemView;
            order = itemView.findViewById(R.id.tv_order);
            name = itemView.findViewById(R.id.tv_file_name);
            play = itemView.findViewById(R.id.btn_start);
            stop = itemView.findViewById(R.id.btn_stop);
            reset = itemView.findViewById(R.id.btn_reset);
        }
    }

    private void initMediaPlayer(MediaPlayer mediaPlayer, String sourcePath) {
        try {
            File file = new File(sourcePath);
            mediaPlayer.setDataSource(file.getPath());
            mediaPlayer.prepare();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

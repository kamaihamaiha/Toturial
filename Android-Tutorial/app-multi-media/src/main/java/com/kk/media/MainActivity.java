package com.kk.media;

import android.media.MediaPlayer;
import android.os.Environment;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.kk.media.utils.MediaUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private MediaPlayer mediaPlayer = new MediaPlayer();
    private List<SoundBean> soundBeanList = new ArrayList<>();
    private MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        initMediaPlayer();
        //todo 先初始化集合
        String soundDirPath = Environment.getExternalStorageDirectory().getPath() + "/" + "audio/";

        File dir = new File(soundDirPath);
        if (dir.exists()) {

            File[] files = dir.listFiles();
            int order = 0;
            for (File file : files) {
                order++;
                SoundBean soundBean = new SoundBean(order + "", file.getName(), file.getAbsolutePath());
                soundBeanList.add(soundBean);
            }
        }

//        SoundAdapter adapter = new SoundAdapter(soundBeanList);
//        recyclerView.setAdapter(adapter);

        player = MediaPlayer.create(this, R.raw.sound);

        findViewById(R.id.btn_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!player.isPlaying()) {
                    Log.d(TAG, "onClick: -------播放！");
                    player.start();
                } else {
                    Log.d(TAG, "onClick: -------重置后，播放！");
                    player.reset();

                    player = MediaPlayer.create(MainActivity.this, R.raw.sound);
                    player.start();
                }
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }

    private void initMediaPlayer() {
        try {
            File file = new File(Environment.getExternalStorageDirectory().getPath() + "/" + "audio/" + "cf-gogogo.mp3");
            mediaPlayer.setDataSource(file.getPath());
            mediaPlayer.prepare();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

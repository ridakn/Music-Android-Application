package com.example.musicapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicService extends Service {

    private MediaPlayer player;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        player = MediaPlayer.create(this, R.raw.song1);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player.setLooping(true);
        player.start();
        return START_STICKY;
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        player.start();
        super.onTaskRemoved(rootIntent);
    }

    @Override
    public void onDestroy() {
        player.stop();
        super.onDestroy();
    }
}


package com.example.jukebox.ui;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaPlayer;

import org.jetbrains.annotations.NotNull;

public class SongPlayer {
    private final Context context;
    public MediaPlayer player;

    public SongPlayer(@NotNull Context context) {
        super();
        this.context = context;
    }

    public final void playSong(int resource) {
        MediaPlayer mp = MediaPlayer.create(this.context, resource);
        this.player = mp;
        mp.setAudioAttributes(
                new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .build()
        );
        mp.start();
    }
}

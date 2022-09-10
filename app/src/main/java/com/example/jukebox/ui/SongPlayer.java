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

    @NotNull
    public final MediaPlayer getPlayer() {
        return this.player;
    }

    public final void setPlayer(@NotNull MediaPlayer var1) {
        this.player = var1;
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

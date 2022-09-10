package com.example.jukebox.data;

import org.jetbrains.annotations.NotNull;

import kotlin.jvm.internal.Intrinsics;

public final class Sound {
    @NotNull
    private final String name;
    private final int image;
    private final int audio;

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getImage() {
        return this.image;
    }

    public final int getAudio() {
        return this.audio;
    }

    public Sound(String name, int image, int audio) {
        this.name = name;
        this.image = image;
        this.audio = audio;
    }
}
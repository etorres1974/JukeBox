package com.example.jukebox.data;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class Album {
    @NotNull
    private final String name;
    @NotNull
    private final List sounds;

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final List getSounds() {
        return this.sounds;
    }

    public Album(String name,  List sounds) {
        this.name = name;
        this.sounds = sounds;
    }
}


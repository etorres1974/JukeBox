package com.example.jukebox.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.jukebox.data.Album;
import com.example.jukebox.data.Sound;
import com.example.jukebox.databinding.SongItemBinding;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

public class AlbumAdapter extends BaseAdapter {

    @NotNull
    private final Album instrument;

    public int getCount() {
        return this.instrument.getSounds().size();
    }

    @NotNull
    public Object getItem(int p0) {
        return this.instrument.getSounds().get(p0);
    }

    public long getItemId(int p0) {
        return (long)p0;
    }

    @NotNull
    public View getView(int position, @Nullable View view, @Nullable ViewGroup parent) {
        Context context = parent != null ? parent.getContext() : null;
        LayoutInflater inflater = LayoutInflater.from(context);
        SongItemBinding var10000 = SongItemBinding.inflate(inflater, parent, false);
        SongItemBinding binding = var10000;
        Sound sound = (Sound) CollectionsKt.getOrNull(this.instrument.getSounds(), position);
        this.setupView(sound, binding, context);
        ConstraintLayout var8 = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(var8, "binding.root");
        return (View)var8;
    }

    private final void setupView(final Sound sound, SongItemBinding binding, final Context context) {
        if (sound != null) {
            binding.cardView.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                public final void onClick(View it) {
                    if (context != null) {
                        (new SongPlayer(context)).playSong(sound.getAudio());
                    }

                }
            }));
            binding.imageView.setImageDrawable(context != null ? context.getDrawable(sound.getImage()) : null);
        }

    }

    @NotNull
    public final Album getInstrument() {
        return this.instrument;
    }

    public AlbumAdapter(@NotNull Album instrument) {
        super();
        this.instrument = instrument;
    }
}


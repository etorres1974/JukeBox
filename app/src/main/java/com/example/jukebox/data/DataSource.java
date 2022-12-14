package com.example.jukebox.data;

import com.example.jukebox.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataSource {

    private Sound jazz = new Sound("Jazz", R.drawable.jazz, R.raw.jazz);
    private Sound hipHop = new Sound ("HipHop", R.drawable.hip_hop, R.raw.beat);
    private Sound space = new Sound ("Space", R.drawable.space, R.raw.space);
    private Sound think = new Sound ("Think", R.drawable.think, R.raw.think);

    private Sound yeah = new Sound("Yeah", R.drawable.ic_dj, R.raw.ah_yeah);
    private Sound bass = new Sound("Bass", R.drawable.ic_drum, R.raw.bass);
    private Sound bell = new Sound("Bell", R.drawable.ic_bell, R.raw.bell);

    public Album  getLoops() {
        List<Sound> musicas = new ArrayList<>();
        musicas.add(jazz);
        musicas.add(hipHop);
        musicas.add(space);
        musicas.add(think);
        return new Album("loops", musicas);
    }

    public List<Album> getInstruments() {
        List<Album> lista = new ArrayList<>();
        List<Sound> voices = new ArrayList<Sound>(Collections.singleton(yeah));
        List<Sound> instruments = new ArrayList<Sound>(Collections.singleton(bass));
        List<Sound> objects = new ArrayList<Sound>(Collections.singleton(bell));

        lista.add(new Album("Voice", voices));
        lista.add(new Album("Instruments", instruments));
        lista.add(new Album("Objects", objects));
        return lista;
    }
}

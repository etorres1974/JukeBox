package com.example.jukebox.ui.loops;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.jukebox.R;
import com.example.jukebox.data.DataSource;
import com.example.jukebox.databinding.FragmentLoopsBinding;
import com.example.jukebox.ui.AlbumAdapter;

public class LoopsFragment extends Fragment {

    private FragmentLoopsBinding binding;
    private DataSource data = new DataSource();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLoopsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupListView();
    }

    private void setupListView(){
        ListAdapter adapter = new AlbumAdapter(data.getLoops());
        binding.lvMusic.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
package com.example.jukebox.ui.Sounds;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.jukebox.R;
import com.example.jukebox.data.Album;
import com.example.jukebox.data.DataSource;
import com.example.jukebox.databinding.FragmentSoundsBinding;
import com.example.jukebox.ui.AlbumAdapter;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SoundsFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private FragmentSoundsBinding binding;
    private DataSource data = new DataSource();
    private List<Album> albuns = data.getInstruments();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSoundsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupSpinner();
    }

    public void setupSpinner(){
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                requireContext(), R.array.instruments_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerInstrument.setAdapter(adapter);
        binding.spinnerInstrument.setOnItemSelectedListener(this);
    }

    private void setupListView(Album album){
        ListAdapter adapter = new AlbumAdapter(album);
        binding.listViewInstrument.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
        List<String> lista = instruments();
        String selected = lista.get(pos);
        Album album = null;
        for(int i = 0; i < lista.size(); i++ ){
            if(Objects.equals(selected, albuns.get(i).getName())){
                album = albuns.get(i);
            }
        }
        if(album != null)
            setupListView(album);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //TODO
    }

    public List<String> instruments() {
       return  Arrays.asList(getResources().getStringArray(R.array.instruments_array));
    }
}

//[]
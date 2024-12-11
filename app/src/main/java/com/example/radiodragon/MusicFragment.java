package com.example.radiodragon;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MusicFragment extends Fragment {

    private List<Genre> genreList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_music);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        initializeGenres(); // Inicializa géneros y canciones

        GenreAdapter adapter = new GenreAdapter(genreList);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void initializeGenres() {

        // Lista de géneros y canciones
        genreList.add(new Genre("Darkwave", Arrays.asList(
            new Song("Song 1", "https://raw.githubusercontent.com/ArDaMaEs/RadioDragonPodcasts/main/Darkwave%20-%20Synthpop/Boy%20Harsher%20-%20Pain.mp3", R.drawable.album1),
            new Song("Song 2", "https://raw.githubusercontent.com/ArDaMaEs/RadioDragonPodcasts/main/Darkwave%20-%20Synthpop/Male%20Tears%20-%20Hit%20Me.mp3", R.drawable.album2)
    )));
    
    genreList.add(new Genre("Dream Pop", Arrays.asList(
            new Song("Song 1", "https://raw.githubusercontent.com/ArDaMaEs/RadioDragonPodcasts/main/Dream%20Pop%20-%20Alternative/Cigarettes%20After%20Sex%20-%20Apocalypse.mp3", R.drawable.album3),
            new Song("Song 2", "https://raw.githubusercontent.com/ArDaMaEs/RadioDragonPodcasts/main/Dream%20Pop%20-%20Alternative/Lana%20Del%20Rey%20-%20Brooklyn%20Baby.mp3", R.drawable.album4)
    )));

    genreList.add(new Genre("Hyperpop", Arrays.asList(
        new Song("Song 1", "https://raw.githubusercontent.com/ArDaMaEs/RadioDragonPodcasts/main/Hyperpop%20-%20Electronic/Charli%20XCX%20-%20Vroom%20Vroom.mp3", R.drawable.album5),
        new Song("Song 2", "https://raw.githubusercontent.com/ArDaMaEs/RadioDragonPodcasts/main/Hyperpop%20-%20Electronic/Dorian%20Electra%20-%20Flamboyant.mp3", R.drawable.album6)
)));

genreList.add(new Genre("Indie", Arrays.asList(
        new Song("Song 1", "https://raw.githubusercontent.com/ArDaMaEs/RadioDragonPodcasts/main/Indie%20-%20Lo-fi/Clairo%20-%20Bags.mp3", R.drawable.album7),
        new Song("Song 2", "https://raw.githubusercontent.com/ArDaMaEs/RadioDragonPodcasts/main/Indie%20-%20Lo-fi/Dayglow%20-%20Can%20I%20Call%20You%20Tonight.mp3", R.drawable.album8)
)));

genreList.add(new Genre("Metal", Arrays.asList(
    new Song("Song 1", "https://raw.githubusercontent.com/ArDaMaEs/RadioDragonPodcasts/main/Metal%20(Progresivo%20-%20Alternativo)/Deftones%20-%20Change%20(In%20the%20House%20of%20Flies).mp3", R.drawable.album9),
    new Song("Song 2", "https://raw.githubusercontent.com/ArDaMaEs/RadioDragonPodcasts/main/Metal%20(Progresivo%20-%20Alternativo)/Gojira%20-%20Flying%20Whales.mp3", R.drawable.album10)
)));

genreList.add(new Genre("Pop mainstream", Arrays.asList(
    new Song("Song 1", "https://raw.githubusercontent.com/ArDaMaEs/RadioDragonPodcasts/main/Pop%20Mainstream/Billie%20Eilish%20-%20bad%20guy.mp3", R.drawable.album11),
    new Song("Song 2", "https://raw.githubusercontent.com/ArDaMaEs/RadioDragonPodcasts/main/Pop%20Mainstream/Harry%20Styles%20-%20As%20It%20Was.mp3", R.drawable.album12)
)));

genreList.add(new Genre("Punk", Arrays.asList(
    new Song("Song 1", "https://raw.githubusercontent.com/ArDaMaEs/RadioDragonPodcasts/main/Punk%20-%20Garage%20Rock/IDLES%20-%20Never%20Fight%20a%20Man%20With%20a%20Perm.mp3", R.drawable.album12),
    new Song("Song 2", "https://raw.githubusercontent.com/ArDaMaEs/RadioDragonPodcasts/main/Punk%20-%20Garage%20Rock/The%20Garden%20-%20Thy%20Mission.mp3", R.drawable.album14)
)));

genreList.add(new Genre("Rap", Arrays.asList(
    new Song("Song 1", "https://raw.githubusercontent.com/ArDaMaEs/RadioDragonPodcasts/main/Rap%20-%20Hip-Hop/Kendrick%20Lamar%20-%20HUMBLE.mp3", R.drawable.album15),
    new Song("Song 2", "https://raw.githubusercontent.com/ArDaMaEs/RadioDragonPodcasts/main/Rap%20-%20Hip-Hop/Tyler%2C%20the%20Creator%20-%20EARFQUAKE.mp3", R.drawable.album16)
)));

genreList.add(new Genre("Rock alternativo", Arrays.asList(
    new Song("Song 1", "https://raw.githubusercontent.com/ArDaMaEs/RadioDragonPodcasts/main/Rock%20Alternativo/Foo%20Fighters%20-%20Everlong.mp3", R.drawable.album17),
    new Song("Song 2", "https://raw.githubusercontent.com/ArDaMaEs/RadioDragonPodcasts/main/Rock%20Alternativo/Muse%20-%20Plug%20In%20Baby.mp3", R.drawable.album18)
)));

   

    }
}
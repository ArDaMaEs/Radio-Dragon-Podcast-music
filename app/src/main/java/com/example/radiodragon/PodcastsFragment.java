// PodcastsFragment.java
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

public class PodcastsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_podcast, container, false); // Asegúrate de usar el nombre correcto aquí

        // Configurar el RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_podcasts);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Lista de podcasts
        List<Podcast> podcastList = new ArrayList<>();
        podcastList.add(new Podcast(R.drawable.biomimetica, "Biomimética", Arrays.asList("https://raw.githubusercontent.com/ArDaMaEs/RadioDragonPodcasts/main/Biomimetica/Noticiero%20Apocalipsis%20Ambiental%20-%2004%20de%20noviembre.mp3", "https://raw.githubusercontent.com/ArDaMaEs/RadioDragonPodcasts/main/Biomimetica/Noticiero%20Apocalipsis%20Ambiental%20-%2011%20de%20noviembre.mp3")));
        podcastList.add(new Podcast(R.drawable.echando_rollo, "Echando Rollo", Arrays.asList("https://raw.githubusercontent.com/ArDaMaEs/RadioDragonPodcasts/main/Echando%20Rollo/Del%20libro%20al%20cine%20-%2020%20de%20septiembre.mp3", "https://raw.githubusercontent.com/ArDaMaEs/RadioDragonPodcasts/main/Echando%20Rollo/Mexico%20en%20documentales%20-%2013%20de%20septiembre.mp3", "https://raw.githubusercontent.com/ArDaMaEs/RadioDragonPodcasts/main/Echando%20Rollo/Olivia%20Rios%20-%2015%20de%20noviembre.mp3")));
        podcastList.add(new Podcast(R.drawable.el_escenario, "El Escenario", Arrays.asList("https://raw.githubusercontent.com/ArDaMaEs/RadioDragonPodcasts/main/El%20Escenario/Caterin%20Mireldy%20y%20Yamile%20-%2012%20de%20noviembre.mp3", "https://raw.githubusercontent.com/ArDaMaEs/RadioDragonPodcasts/main/El%20Escenario/Dennys%20-%2019%20de%20noviembre.mp3", "https://raw.githubusercontent.com/ArDaMaEs/RadioDragonPodcasts/main/El%20Escenario/Lupita%20Briseño%20Estudiante%20de%20Diseño%20Digital%20-%2029%20de%20octubre.mp3")));
        podcastList.add(new Podcast(R.drawable.entre_letras, "Entre Letras", Arrays.asList("https://raw.githubusercontent.com/ArDaMaEs/RadioDragonPodcasts/main/Entre%20Letras/Escritora%20Elvira%20Hernandez%20-%2013%20de%20noviembre.mp3", "https://raw.githubusercontent.com/ArDaMaEs/RadioDragonPodcasts/main/Entre%20Letras/Mas%20Alla%20de%20las%20Fronteras%20-%2023%20de%20octubre.mp3", "https://raw.githubusercontent.com/ArDaMaEs/RadioDragonPodcasts/main/Entre%20Letras/Vocalista%20de%20Campeche%20Show%20y%20los%20Guramis%20Lalo%20Estrada%20-%2020%20de%20noviembre.mp3")));

        // Configurar el adaptador
        PodcastAdapter adapter = new PodcastAdapter(podcastList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}

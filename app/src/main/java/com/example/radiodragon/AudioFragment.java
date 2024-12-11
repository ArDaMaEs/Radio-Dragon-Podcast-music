package com.example.radiodragon;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class AudioFragment extends Fragment {

    private static final String ARG_AUDIO_URL = "audio_url"; // Clave para pasar la URL
    private ExoPlayer exoPlayer;
    private Button playPauseButton;
    private boolean isPlaying = false;

    // Método para crear una instancia del fragmento con la URL
    public static AudioFragment newInstance(String audioUrl) {
        AudioFragment fragment = new AudioFragment();
        Bundle args = new Bundle();
        args.putString(ARG_AUDIO_URL, audioUrl);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_audio, container, false);

        playPauseButton = view.findViewById(R.id.play_pause_button);

        String audioUrl = getArguments() != null ? getArguments().getString(ARG_AUDIO_URL) : null;

        if (audioUrl != null && !audioUrl.isEmpty()) {
            try {
                // Inicializar ExoPlayer
                exoPlayer = new ExoPlayer.Builder(requireContext()).build();
                MediaItem mediaItem = MediaItem.fromUri(Uri.parse(audioUrl));
                exoPlayer.setMediaItem(mediaItem);
                exoPlayer.prepare();

                // Log de depuración
                Log.d("AudioFragment", "Reproduciendo audio desde URL: " + audioUrl);

                // Configurar botón de play/pause
                playPauseButton.setOnClickListener(v -> {
                    if (isPlaying) {
                        exoPlayer.pause();
                        playPauseButton.setText("Reproducir");
                        Log.d("AudioFragment", "Audio pausado");
                    } else {
                        exoPlayer.play();
                        playPauseButton.setText("Pausar");
                        Log.d("AudioFragment", "Audio en reproducción");
                    }
                    isPlaying = !isPlaying;
                });
            } catch (Exception e) {
                Log.e("AudioFragment", "Error inicializando el reproductor: " + e.getMessage());
            }
        } else {
            Log.e("AudioFragment", "URL de audio inválida");
        }

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (exoPlayer != null) {
            exoPlayer.stop();
            exoPlayer.release();
            exoPlayer = null;
            Log.d("AudioFragment", "Reproductor liberado");
        }
    }
}

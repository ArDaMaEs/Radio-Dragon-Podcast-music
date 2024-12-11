package com.example.radiodragon;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PodcastAdapter extends RecyclerView.Adapter<PodcastAdapter.PodcastViewHolder> {

    private final List<Podcast> podcastList;

    public PodcastAdapter(List<Podcast> podcastList) {
        this.podcastList = podcastList;
    }

    @NonNull
    @Override
    public PodcastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_podcast, parent, false);
        return new PodcastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PodcastViewHolder holder, int position) {
        Podcast podcast = podcastList.get(position);
        holder.podcastImage.setImageResource(podcast.getImageResId());
        holder.podcastTitle.setText(podcast.getTitle());

        // Configura el RecyclerView interno para los audios
        AudioAdapter audioAdapter = new AudioAdapter(podcast.getAudioUrls());
        holder.audioList.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
        holder.audioList.setAdapter(audioAdapter);
    }

    @Override
    public int getItemCount() {
        return podcastList.size();
    }

    static class PodcastViewHolder extends RecyclerView.ViewHolder {
        ImageView podcastImage;
        TextView podcastTitle;
        RecyclerView audioList;

        public PodcastViewHolder(@NonNull View itemView) {
            super(itemView);
            podcastImage = itemView.findViewById(R.id.podcast_image);
            podcastTitle = itemView.findViewById(R.id.podcast_title);
            audioList = itemView.findViewById(R.id.audio_list);
        }
    }
}

// Adaptador para los audios
class AudioAdapter extends RecyclerView.Adapter<AudioAdapter.AudioViewHolder> {

    private final List<String> audioUrls;
    private MediaPlayer mediaPlayer;

    public AudioAdapter(List<String> audioUrls) {
        this.audioUrls = audioUrls;
    }

    @NonNull
    @Override
    public AudioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_audio, parent, false);
        return new AudioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AudioViewHolder holder, int position) {
        String audioUrl = audioUrls.get(position);
        holder.audioTitle.setText("Audio " + (position + 1));

        holder.playButton.setOnClickListener(v -> {
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.release();
            }
            mediaPlayer = new MediaPlayer();
            try {
                mediaPlayer.setDataSource(audioUrl);
                mediaPlayer.prepare();
                mediaPlayer.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public int getItemCount() {
        return audioUrls.size();
    }

    static class AudioViewHolder extends RecyclerView.ViewHolder {
        TextView audioTitle;
        Button playButton;

        public AudioViewHolder(@NonNull View itemView) {
            super(itemView);
            audioTitle = itemView.findViewById(R.id.audio_title);
            playButton = itemView.findViewById(R.id.play_button);
        }
    }
}

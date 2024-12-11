package com.example.radiodragon;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {

    private final List<Song> songList;
    private MediaPlayer mediaPlayer;

    public SongAdapter(List<Song> songList) {
        this.songList = songList;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_song, parent, false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        Song song = songList.get(position);
        holder.songTitle.setText(song.getTitle());
        holder.albumImage.setImageResource(song.getAlbumImageResId());

        holder.playPauseButton.setOnClickListener(v -> {
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
                holder.playPauseButton.setText("Play");
            } else {
                mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource(song.getUrl());
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                    holder.playPauseButton.setText("Pause");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                mediaPlayer.setOnCompletionListener(mp -> {
                    holder.playPauseButton.setText("Play");
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    static class SongViewHolder extends RecyclerView.ViewHolder {
        TextView songTitle;
        ImageView albumImage;
        Button playPauseButton;

        public SongViewHolder(@NonNull View itemView) {
            super(itemView);
            songTitle = itemView.findViewById(R.id.song_title);
            albumImage = itemView.findViewById(R.id.album_image);
            playPauseButton = itemView.findViewById(R.id.play_pause_button);
        }
    }
}

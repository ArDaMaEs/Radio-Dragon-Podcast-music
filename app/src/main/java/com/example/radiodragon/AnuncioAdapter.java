package com.example.radiodragon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AnuncioAdapter extends RecyclerView.Adapter<AnuncioAdapter.AnuncioViewHolder> {

    private final List<Anuncio> anuncioList;

    public AnuncioAdapter(List<Anuncio> anuncioList) {
        this.anuncioList = anuncioList;
    }

    @NonNull
    @Override
    public AnuncioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_anuncio, parent, false);
        return new AnuncioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnuncioViewHolder holder, int position) {
        Anuncio anuncio = anuncioList.get(position);
        holder.anuncioImage.setImageResource(anuncio.getImageResId());
        holder.anuncioText.setText(anuncio.getDescription());
        holder.anuncioDate.setText(anuncio.getDate()); // Aquí ponemos la fecha
    }

    @Override
    public int getItemCount() {
        return anuncioList.size();
    }

    static class AnuncioViewHolder extends RecyclerView.ViewHolder {
        ImageView anuncioImage;
        TextView anuncioText;
        TextView anuncioDate; // Agregamos el TextView para la fecha

        public AnuncioViewHolder(@NonNull View itemView) {
            super(itemView);
            anuncioImage = itemView.findViewById(R.id.anuncio_image);
            anuncioText = itemView.findViewById(R.id.anuncio_text);
            anuncioDate = itemView.findViewById(R.id.anuncio_date); // Referenciamos el TextView de la fecha
        }
    }
}

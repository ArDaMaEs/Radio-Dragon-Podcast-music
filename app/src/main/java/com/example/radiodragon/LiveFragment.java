package com.example.radiodragon;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class LiveFragment extends Fragment {

    private static final String FACEBOOK_LIVE_URL = "https://www.facebook.com/radiodragonutfv/"; // Cambia por tu URL de Facebook

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_live, container, false);

        Button btnLive = view.findViewById(R.id.btn_live);
        btnLive.setOnClickListener(v -> openFacebookLive());

        return view;
    }

    // Función para abrir la página de Facebook
    private void openFacebookLive() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(FACEBOOK_LIVE_URL));
        startActivity(intent);
    }
}

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
import java.util.Collections;
import java.util.List;

public class AnunciosFragment extends Fragment {

    private RecyclerView recyclerView;
    private AnuncioAdapter anuncioAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_anuncios, container, false);

        recyclerView = view.findViewById(R.id.recycler_view_anuncios);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        List<Anuncio> anuncioList = new ArrayList<>();
        anuncioList.add(new Anuncio(R.drawable.imagen1, "#MomentosHistóricos el 20 de noviembre, conmemoramos el 114 Aniversario de la Revolución Mexicana.  #SomosDragones", "20 de noviembre"));
        anuncioList.add(new Anuncio(R.drawable.imagen2, "Te recordamos que el lunes 18 de noviembre se suspenden todas las actividades académicas y administrativas. Reanudando actividades el martes 19 de noviembre en los horarios regulares. #SomosDragones", "18 de noviembre"));
        anuncioList.add(new Anuncio(R.drawable.imagen3, "La Universidad Tecnológica Fidel Velázquez y el Departamento de Psicología te invitan a participar en la plática ¿Por qué consumimos sustancias psicoactivas? Este 15 de noviembre, a las 10:00 horas, en el CCAI (Edificio H). #SomosDragones", "13 de noviembre"));
        anuncioList.add(new Anuncio(R.drawable.imagen4, "El Departamento de Psicología te invita a la plática Salud sexual reproductiva en el marco de la Semana de la Sexualidad Responsable.▪️ Jueves 14 de noviembre.16:00 horas. En la Velaria. #SomosDragones", "14 de noviembre"));
        anuncioList.add(new Anuncio(R.drawable.imagen5, "¡Ya puedes realizar tu REGISTRO para el examen de admisión o pase automático y ser parte de la #ComunidadDragón! Convocatoria de ingreso enero 2025. 📌Límite de registro: 29 de noviembre de 2024. 📌Examen de admisión: 06 de diciembre de 2024.  *Lee la convocatoria con detenimiento y atención. Para todos los programas educativos (excepto el área de Salud: Enfermería y Terapia Física). Escanea el código QR o chécala en nuestro sitio web: https://utfv.edomex.gob.mx/.../Convocatoria%20Ingreso... #SomosDragones", "10 de noviembre"));
        anuncioList.add(new Anuncio(R.drawable.imagen6, "La Universidad Tecnológica Fidel Velázquez a través del Departamento de Psicología te invita a asistir a la plática Jornada de salud femenina como parte de las actividades de la Semana de la Sexualidad Responsable. Jueves 14 de noviembre. de 9:00 a 12:00 horas. En la Biblioteca. #SomosDragones", "8 de noviembre"));
        anuncioList.add(new Anuncio(R.drawable.imagen7, "La #UTFV cuenta con un Centro Naranja, en apoyo y atención a las mujeres de la comunidad universitaria y público en general en situación de violencia de género en las siguientes áreas: -Prevención y atención de la violencia de género. -Trabajo social. -Asesoría jurídica (patrocinio de juicios en materia de derecho familiar). -Atención psicológica. Horario de atención: lunes a viernes de 9:00 a 18:00 horas. Para mayores informes, acércate al Departamento de Psicología, en La Era.#SomosDragones", "2 de noviembre"));
        // Agrega más anuncios con sus fechas aquí

        // Ordenar los anuncios por fecha (más recientes primero)
        Collections.sort(anuncioList, (a1, a2) -> a2.getDate().compareTo(a1.getDate()));

        // Configurar el adaptador con la lista ordenada
        anuncioAdapter = new AnuncioAdapter(anuncioList);
        recyclerView.setAdapter(anuncioAdapter);

        return view;
    }
}

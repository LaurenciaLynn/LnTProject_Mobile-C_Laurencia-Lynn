package com.example.mymath;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Fragment2 extends Fragment {

    private Button buttonPersegi, buttonSegitiga, buttonLingkaran;
    private TextView textViewPersegi, textViewSegitiga, textViewLingkaran;
    private EditText editTextSisiPersegi, editTextTinggiSegitiga, editTextAlasSegitiga, editTextRadiusLingkaran;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buttonPersegi = view.findViewById(R.id.bt_persegi);
        buttonSegitiga = view.findViewById(R.id.bt_segitiga);
        buttonLingkaran = view.findViewById(R.id.bt_lingkaran);

        textViewPersegi = view.findViewById(R.id.tv_persegi);
        textViewSegitiga = view.findViewById(R.id.tv_segitiga);
        textViewLingkaran = view.findViewById(R.id.tv_lingkaran);

        editTextSisiPersegi = view.findViewById(R.id.et_persegi);
        editTextTinggiSegitiga = view.findViewById(R.id.et_tinggisegitiga);
        editTextAlasSegitiga = view.findViewById(R.id.et_alassegitiga);
        editTextRadiusLingkaran = view.findViewById(R.id.et_lingkaran);

        buttonPersegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sisiString = editTextSisiPersegi.getText().toString().trim();
                if (!sisiString.isEmpty()) {
                    int sisi = Integer.parseInt(sisiString);
                    textViewPersegi.setText(String.valueOf(sisi * sisi));
                } else {
                    textViewPersegi.setText("");
                }
            }
        });

        buttonSegitiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String alasString = editTextAlasSegitiga.getText().toString().trim();
                String tinggiString = editTextTinggiSegitiga.getText().toString().trim();
                if (!alasString.isEmpty() && !tinggiString.isEmpty()) {
                    int alas = Integer.parseInt(alasString);
                    int tinggi = Integer.parseInt(tinggiString);
                    textViewSegitiga.setText(String.valueOf(alas * tinggi / 2));
                } else {
                    textViewSegitiga.setText("");
                }
            }
        });

        buttonLingkaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String radiusString = editTextRadiusLingkaran.getText().toString().trim();
                if (!radiusString.isEmpty()) {
                    int radius = Integer.parseInt(radiusString);
                    textViewLingkaran.setText(String.valueOf(22 * radius * radius / 7));
                } else {
                    textViewLingkaran.setText("");
                }
            }
        });
    }
}
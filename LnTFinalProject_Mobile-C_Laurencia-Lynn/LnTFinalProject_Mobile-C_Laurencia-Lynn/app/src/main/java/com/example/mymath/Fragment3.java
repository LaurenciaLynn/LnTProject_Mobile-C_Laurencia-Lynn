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

public class Fragment3 extends Fragment {

    private Button buttonBalok, buttonPiramid, buttonTabung;
    private TextView textViewBalok, textViewPiramid, textViewTabung;
    private EditText editTextPBalok, editTextLBalok, editTextTBalok,
                    editTextPPiramid, editTextLPiramid, editTextTPiramid,
                    editTextRTabung, editTextTTabung;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buttonBalok = view.findViewById(R.id.bt_balok);
        buttonPiramid = view.findViewById(R.id.bt_piramid);
        buttonTabung = view.findViewById(R.id.bt_tabung);

        textViewBalok = view.findViewById(R.id.tv_balok);
        textViewPiramid = view.findViewById(R.id.tv_piramid);
        textViewTabung = view.findViewById(R.id.tv_tabung);

        editTextPBalok = view.findViewById(R.id.et_pbalok);
        editTextLBalok = view.findViewById(R.id.et_lbalok);
        editTextTBalok = view.findViewById(R.id.et_tbalok);

        editTextPPiramid = view.findViewById(R.id.et_ppiramid);
        editTextLPiramid = view.findViewById(R.id.et_lpiramid);
        editTextTPiramid = view.findViewById(R.id.et_tpiramid);

        editTextRTabung = view.findViewById(R.id.et_rtabung);
        editTextTTabung = view.findViewById(R.id.et_ttabung);

        buttonBalok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = editTextPBalok.getText().toString().trim();
                String str2 = editTextLBalok.getText().toString().trim();
                String str3 = editTextTBalok.getText().toString().trim();

                if (!str1.isEmpty() && !str2.isEmpty() && !str3.isEmpty()) {
                    int p = Integer.parseInt(str1);
                    int l = Integer.parseInt(str2);
                    int t = Integer.parseInt(str3);
                    textViewBalok.setText(String.valueOf(p * l * t));
                } else {
                    textViewBalok.setText("\0");
                }
            }
        });

        buttonPiramid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = editTextPPiramid.getText().toString().trim();
                String str2 = editTextLPiramid.getText().toString().trim();
                String str3 = editTextTPiramid.getText().toString().trim();

                if (!str1.isEmpty() && !str2.isEmpty() && !str3.isEmpty()) {
                    int p = Integer.parseInt(str1);
                    int l = Integer.parseInt(str2);
                    int t = Integer.parseInt(str3);
                    textViewPiramid.setText(String.valueOf(p * l * t / 3));
                } else {
                    textViewPiramid.setText("\0");
                }
            }
        });

        buttonTabung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = editTextRTabung.getText().toString().trim();
                String str2 = editTextTTabung.getText().toString().trim();

                if (!str1.isEmpty() && !str2.isEmpty()) {
                    int r = Integer.parseInt(str1);
                    int t = Integer.parseInt(str2);
                    textViewTabung.setText(String.valueOf(22 * r * r * t / 7));
                } else {
                    textViewTabung.setText("\0");
                }
            }
        });
    }
}
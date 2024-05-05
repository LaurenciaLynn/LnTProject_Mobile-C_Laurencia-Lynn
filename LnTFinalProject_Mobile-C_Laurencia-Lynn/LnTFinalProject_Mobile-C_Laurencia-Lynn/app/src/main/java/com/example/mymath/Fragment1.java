package com.example.mymath;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Fragment1 extends Fragment {

    private Button plusButton, lessButton, resetButton;
    private TextView counterTextView;
    private SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        plusButton = view.findViewById(R.id.bt_plusplus);
        lessButton = view.findViewById(R.id.bt_lessless);
        resetButton = view.findViewById(R.id.bt_reset);
        counterTextView = view.findViewById(R.id.tv_counter);

        sharedPreferences = getActivity().getSharedPreferences("counter", Context.MODE_PRIVATE);
        counterTextView.setText(sharedPreferences.getString("counter", ""));

        if (counterTextView.getText().toString().equals("")) {
            counterTextView.setText("0");
        }

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = counterTextView.getText().toString();
                int n = Integer.valueOf(str);
                ++n;
                str = String.valueOf(n);
                counterTextView.setText(str);

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("counter", str);
                editor.apply();
            }
        });

        lessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = counterTextView.getText().toString();
                int n = Integer.valueOf(str);
                --n;
                str = String.valueOf(n);
                counterTextView.setText(str);

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("counter", str);
                editor.apply();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterTextView.setText("0");

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("counter", "0");
                editor.apply();
            }
        });
    }
}
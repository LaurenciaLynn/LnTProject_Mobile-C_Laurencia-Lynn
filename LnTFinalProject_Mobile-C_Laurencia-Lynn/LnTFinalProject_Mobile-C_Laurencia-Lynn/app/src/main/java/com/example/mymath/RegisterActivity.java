package com.example.mymath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText idBimbel, email, name, password, confirmPassword;
    Button create;
    TextView toLogin;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        idBimbel = findViewById(R.id.et_idbimbel);
        email = findViewById(R.id.et_email);
        name = findViewById(R.id.et_name);
        password = findViewById(R.id.et_password);
        confirmPassword = findViewById(R.id.et_confirmpassword);
        create = findViewById(R.id.bt_create);
        toLogin = findViewById(R.id.tv_tologin);
        sharedPref = getSharedPreferences("user_account", MODE_PRIVATE);

        toLogin.setOnClickListener(v -> {
            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
        });

        create.setOnClickListener(v -> {
            if (idBimbel.getText().toString().length() < 3) {
                Toast.makeText(this, "ID Bimbel must be at least 3 digits long", Toast.LENGTH_SHORT).show();
            } else if (!email.getText().toString().contains("@") || !email.getText().toString().contains(".com") || email.getText().toString().indexOf("@") > email.getText().toString().indexOf(".com")) {
                Toast.makeText(this, "Invalid email", Toast.LENGTH_SHORT).show();
            } else if (name.getText().toString().length() < 5) {
                Toast.makeText(this, "Name must be at least 5 characters long", Toast.LENGTH_SHORT).show();
            } else if (password.getText().toString().length() < 6) {
                Toast.makeText(this, "Password must be at least 6 characters long", Toast.LENGTH_SHORT).show();
            } else if (!password.getText().toString().equals(confirmPassword.getText().toString())) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            } else {
                SharedPreferences.Editor edit = sharedPref.edit();
                edit.putString("idBimbel", idBimbel.getText().toString());
                edit.putString("email", email.getText().toString());
                edit.putString("name", name.getText().toString());
                edit.putString("password", password.getText().toString());
                edit.apply();
                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
            }
        });
    }
}
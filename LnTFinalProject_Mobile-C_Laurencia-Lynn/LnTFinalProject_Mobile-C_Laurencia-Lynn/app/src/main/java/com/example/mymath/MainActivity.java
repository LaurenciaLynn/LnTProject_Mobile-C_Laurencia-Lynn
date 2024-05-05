package com.example.mymath;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button login;
    EditText email, password;
    SharedPreferences sharedPref;
    TextView toRegis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.bt_login);
        email = findViewById(R.id.et_emaillogin);
        password = findViewById(R.id.et_passwordlogin);
        toRegis = findViewById(R.id.tv_toregister);

        toRegis.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, RegisterActivity.class));
        });

        sharedPref = getSharedPreferences("user_account", MODE_PRIVATE);
        login.setOnClickListener(v -> {
            if (!email.getText().toString().contains("@") || !email.getText().toString().contains(".com") || email.getText().toString().indexOf("@") > email.getText().toString().indexOf(".com")) {
                Toast.makeText(this, "Invalid email", Toast.LENGTH_SHORT).show();
            } else if (email.getText().toString().equals(sharedPref.getString("email", "")) && password.getText().toString().equals(sharedPref.getString("password", ""))) {
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
            } else {
                Toast.makeText(this, "Email or password is wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
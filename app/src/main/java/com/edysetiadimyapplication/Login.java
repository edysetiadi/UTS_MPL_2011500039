package com.edysetiadimyapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText username, password;
    private Button loginbtn;
    private String nama = "Edy Setiadi";
    private String nim = "2011500039";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginbtn = findViewById(R.id.loginbtn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equalsIgnoreCase(nama) && password.getText().toString().equalsIgnoreCase(nim)) {
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);

                    Toast.makeText(Login.this, "LOGIN BERHASIL", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(Login.this, "Username atau Password Salah !!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
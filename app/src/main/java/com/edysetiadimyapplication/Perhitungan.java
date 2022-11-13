package com.edysetiadimyapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Perhitungan extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ImageView ivMenu;
    private RecyclerView rvMenu;
    private EditText etPanjang, etLebar;
    private Button btnHitung, btnClear;
    private TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perhitungan);

        drawerLayout = findViewById(R.id.drawer_layout);
        ivMenu = findViewById(R.id.ivMenu);
        rvMenu = findViewById(R.id.rvMenu);

        etPanjang = findViewById(R.id.etPanjang);
        etLebar = findViewById(R.id.etLebar);
        btnHitung = findViewById(R.id.btnHitung);
        btnClear = findViewById(R.id.btnClear);
        tvHasil = findViewById(R.id.tvHasil);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double Panjang = Double.valueOf(etPanjang.getText().toString().trim());
                double Lebar = Double.valueOf(etLebar.getText().toString().trim());
                double hasil;

                hasil = Panjang * Lebar;

                tvHasil.setText(String.valueOf(hasil));
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etPanjang.setText("");
                etLebar.setText("");
                tvHasil.setText("");
            }
        });

        //set layout manager
        rvMenu.setLayoutManager(new LinearLayoutManager(this));
        //set adapter
        rvMenu.setAdapter(new MainAdapter(this, MainActivity.arrayList,MainActivity.image));

        ivMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //buka drawernya
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        //tutup drawer
        MainActivity.closeDrawer(drawerLayout);
    }
}
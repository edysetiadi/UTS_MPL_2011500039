package com.edysetiadimyapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    //inisialsasi variable
    private DrawerLayout drawerLayout;
    private ImageView ivMenu;
    private RecyclerView rvMenu;
    static ArrayList<String> arrayList = new ArrayList<>();
    static ArrayList<Integer> image = new ArrayList<Integer>();
    MainAdapter adapter;

    public static void closeDrawer(DrawerLayout drawerLayout) {
        //cek kondisi
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        ivMenu = findViewById(R.id.ivMenu);
        rvMenu = findViewById(R.id.rvMenu);

        //clear array listnya
        arrayList.clear();

        //tambahkan menu item ke array list
        arrayList.add("BERANDA");
        arrayList.add("PERHITUNGAN");
        arrayList.add("BIODATA");
        arrayList.add("KELUAR");

        //tambahkan gambar
        image.add(R.drawable.ic_baseline_home_24);
        image.add(R.drawable.ic_baseline_calculate_24);
        image.add(R.drawable.ic_baseline_person_24);
        image.add(R.drawable.ic_baseline_login_24);

        //inisialisasi adapter
        adapter = new MainAdapter(this, arrayList, image);

        //set layout manager
        rvMenu.setLayoutManager(new LinearLayoutManager(this));

        //set adapter
        rvMenu.setAdapter(adapter);

        ivMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }
}
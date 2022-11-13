package com.edysetiadimyapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Biodata extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ImageView ivMenu;
    private RecyclerView rvMenu;
    private RelativeLayout rlHasil;
    private EditText etNama, etNim;
    private TextView tvNama, tvNim, tvJurusan, tvHobi;
    private Button btnTampil;
    private RadioButton rbMI, rbSI, rbTI;
    private CheckBox cbMakan, cbTidur, cbBelajar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata);

        drawerLayout = findViewById(R.id.drawer_layout);
        ivMenu = findViewById(R.id.ivMenu);
        rvMenu = findViewById(R.id.rvMenu);
        etNama = findViewById(R.id.etNama);
        etNim = findViewById(R.id.etNim);
        btnTampil = findViewById(R.id.btnTampil);
        rbMI = findViewById(R.id.rbMI);
        rbSI = findViewById(R.id.rbSI);
        rbTI = findViewById(R.id.rbTI);
        cbMakan = findViewById(R.id.cbMakan);
        cbTidur = findViewById(R.id.cbTidur);
        cbBelajar = findViewById(R.id.cbBelajar);
        rlHasil = findViewById(R.id.rlHasil);
        tvNama = findViewById(R.id.tvTampilNamaHasil);
        tvNim = findViewById(R.id.tvTampilNimHasil);
        tvJurusan = findViewById(R.id.tvTampilJurusanHasil);
        tvHobi = findViewById(R.id.tvTampilHobiHasil);

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

        //ketika button tampilkan di tekan
        btnTampil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nama = etNama.getText().toString().trim();
                String nim = etNim.getText().toString().trim();

                if (nama.isEmpty()){
                    Toast.makeText(Biodata.this, "Silahkan Masukkan Nama Anda Terlebih Dahulu!!",Toast.LENGTH_SHORT).show();
                }else if(nim.isEmpty()){
                    Toast.makeText(Biodata.this, "Silahkan Masukkan Nim Anda Terlebih Dahulu!!",Toast.LENGTH_SHORT).show();
                }else{

                    rlHasil.setVisibility(View.VISIBLE);

                    String jurusan = "";
                    String hobi = "";

                    //radio button

                    if (rbMI.isChecked()){
                        jurusan = "MI";
                    }else if (rbSI.isChecked()){
                        jurusan = "SI";
                    }else if(rbTI.isChecked()){
                        jurusan = "TI";
                    }else{
                        Toast.makeText(Biodata.this, "Silahkan Pilih Jurusan Anda!!",Toast.LENGTH_SHORT).show();
                    }


                    //checkBox
                    if (cbMakan.isChecked() && cbTidur.isChecked() && cbBelajar.isChecked()){
                        hobi = "Makan, Tidur & Belajar";
                    }
                    else if (cbMakan.isChecked() && cbTidur.isChecked()){
                        hobi = "Makan & Tidur";
                    }
                    else if (cbMakan.isChecked() && cbBelajar.isChecked()){
                        hobi = "Makan & Belajar";
                    }
                    else if (cbTidur.isChecked() && cbBelajar.isChecked()){
                        hobi = "Tidur & Belajar";
                    }
                    else if (cbMakan.isChecked()){
                        hobi = "Makan";
                    }
                    else if (cbTidur.isChecked()){
                        hobi = "Tidur";
                    }
                    else if (cbBelajar.isChecked()){
                        hobi = "Belajar";
                    }

                    tvNama.setText(nama);
                    tvNim.setText(nim);
                    tvJurusan.setText(jurusan);
                    tvHobi.setText(hobi);

                }
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
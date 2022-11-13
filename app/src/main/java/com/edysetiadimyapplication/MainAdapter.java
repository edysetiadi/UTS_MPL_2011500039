package com.edysetiadimyapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    //inisialisasi variable
    Activity activity;
    ArrayList<String> arrayList;
    ArrayList<Integer> image;

    public MainAdapter(Activity activity, ArrayList<String> arrayList, ArrayList<Integer> image) {
        this.activity = activity;
        this.arrayList = arrayList;
        this.image = image;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inisialisai view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drawer_main,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
        //set gambar menu
        holder.ivMenu.setImageResource(image.get(position));
        //set textnya dan agar bisa di tekan
        holder.tvMenu.setText(arrayList.get(position));
        holder.tvMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get posisi item
                int position = holder.getAdapterPosition();

                switch (position){
                    case 0 :
                        activity.startActivity(new Intent(activity, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;
                    case 1 :
                        //ketika posisi 1 maka akan membuka class Perhitungan
                        activity.startActivity(new Intent(activity, Perhitungan.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;
                    case 2 :
                        //ketika posisi 2 maka akan membuka class Biodata
                        activity.startActivity(new Intent(activity, Biodata.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;
                    case 3 :
                        //ketika posisi 3 maka akan menanyakan ingin keluar atau tidak
                        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                        //judul dialog
                        builder.setTitle("Keluar");
                        //pesan dialog
                        builder.setMessage("Kamu Yakin Ingin Keluar Dari Aplikasi?");
                        //jika ya
                        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                activity.startActivity(new Intent(activity, Login.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                            }
                        });
                        //jika tidak
                        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        //tampilkan dialog
                        builder.show();
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //inisialisai variable
        private TextView tvMenu;
        private ImageView ivMenu;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //find by id
            tvMenu = itemView.findViewById(R.id.tvMenu);
            ivMenu = itemView.findViewById(R.id.ivMenu);
        }
    }
}

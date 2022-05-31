package com.pcoding.kalkulatorpesanan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CostumAdapter extends RecyclerView.Adapter<CostumAdapter.MyViewHolder> {

    private Context context;
    private ArrayList id_pesanan, nama_pesanan, makanan_pesanan, harga_pesanan;

    CostumAdapter(Context context,
                  ArrayList id_pesanan,
                  ArrayList nama_pesanan,
                  ArrayList makanan_pesanan,
                  ArrayList harga_pesanan) {
        this.context = context;
        this.id_pesanan = id_pesanan;
        this.nama_pesanan = nama_pesanan;
        this.makanan_pesanan = makanan_pesanan;
        this.harga_pesanan = harga_pesanan;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.id_pesanan_txt.setText(String.valueOf(id_pesanan.get(position)));
        holder.nama_pesanan_txt.setText(String.valueOf(nama_pesanan.get(position)));
        holder.makanan_pesanan_txt.setText(String.valueOf(makanan_pesanan.get(position)));
        holder.harga_pesanan_txt.setText(String.valueOf(harga_pesanan.get(position)));
    }

    @Override
    public int getItemCount() {
        return id_pesanan.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id_pesanan_txt, nama_pesanan_txt, makanan_pesanan_txt, harga_pesanan_txt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id_pesanan_txt = itemView.findViewById(R.id.textView);
            nama_pesanan_txt = itemView.findViewById(R.id.nama);
            makanan_pesanan_txt = itemView.findViewById(R.id.makanan);
            harga_pesanan_txt = itemView.findViewById(R.id.harga);
        }
    }
}

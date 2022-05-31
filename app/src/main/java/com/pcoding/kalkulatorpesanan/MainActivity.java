package com.pcoding.kalkulatorpesanan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_btn;

    MyDatabaseHelper myDB;
    ArrayList<String> id_pesanan, nama_pesanan, makanan_pesanan, harga_pesanan;
    CostumAdapter costumAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        add_btn = findViewById(R.id.add_btn);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        myDB = new MyDatabaseHelper(MainActivity.this);
        id_pesanan = new ArrayList<>();
        nama_pesanan = new ArrayList<>();
        makanan_pesanan = new ArrayList<>();
        harga_pesanan = new ArrayList<>();

        storeDataInArrays();

        costumAdapter = new CostumAdapter(MainActivity.this, id_pesanan, nama_pesanan, makanan_pesanan, harga_pesanan);
        recyclerView.setAdapter(costumAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    void storeDataInArrays() {
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Tidak Ada Data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                id_pesanan.add(cursor.getString(0));
                nama_pesanan.add(cursor.getString(1));
                makanan_pesanan.add(cursor.getString(2));
                harga_pesanan.add(cursor.getString(3));
            }
        }
    }
}
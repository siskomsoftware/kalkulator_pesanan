package com.pcoding.kalkulatorpesanan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    Button btn_tambah;
    EditText et_nama;
    EditText et_makanan;
    EditText et_harga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        et_nama = findViewById(R.id.et_nama);
        et_makanan = findViewById(R.id.et_makanan);
        et_harga = findViewById(R.id.et_harga);
        btn_tambah = findViewById(R.id.btn_tambah);
        btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addPesanan(et_nama.getText().toString().trim(),
                        et_makanan.getText().toString().trim(),
                        et_harga.getText().toString().trim());
            }
        });
    }
}
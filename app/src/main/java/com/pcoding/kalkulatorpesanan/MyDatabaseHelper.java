package com.pcoding.kalkulatorpesanan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "DaftarPesanan.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABEL_NAME = "tb_pesanan";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAMA = "nama";
    private static final String COLUMN_BARANG = "barang";
    private static final String COLUMN_HARGA = "harga";


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABEL_NAME +
                        " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_NAMA + " TEXT," +
                        COLUMN_BARANG + " TEXT," +
                        COLUMN_HARGA + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABEL_NAME);
        onCreate(db);
    }

    void addPesanan (String nama, String barang, String harga) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAMA, nama);
        cv.put(COLUMN_BARANG, barang);
        cv.put(COLUMN_HARGA, harga);
        long result = db.insert(TABEL_NAME, null, cv);
        if (result == -1){
            Toast.makeText(context, "Data Gagal Ditambahakan", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Data Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData() {
        String query = "SELECT * FROM " + TABEL_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
}

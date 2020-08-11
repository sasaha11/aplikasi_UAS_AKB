package com.example.uas_10117265_abdurrahmansidiq;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class wisatasimpan extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    String SQLiteQuery;
    SQLiteDatabase sqLiteDatabase;
    ListView listwisata;
    private ArrayList<String> ListData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisatasimpan);

        listwisata = (ListView) findViewById(R.id.listwisata);
        ListData = new ArrayList<>();
        getData();
        listwisata.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ListData));



        Toolbar menuToolbar = findViewById(R.id.menuToolBar);
        menuToolbar.setTitle("Wisata Favorit");

        drawer = findViewById(R.id.drawer_daftarwisata);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, menuToolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setCheckedItem(R.id.daftar_wisata);
    }

    private void getData(){
        //Mengambil Repository dengan Mode Membaca
        sqLiteDatabase = openOrCreateDatabase("db_wisata.db", Context.MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM tabel_wisata",null);

        cursor.moveToFirst();//Memulai Cursor pada Posisi Awal
        //Melooping Sesuai Dengan Jumlan Data (Count) pada cursor
        if (cursor.getCount() == 0){
            Toast.makeText(wisatasimpan.this, "Data Kosong", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(wisatasimpan.this, MainActivity.class);
            startActivity(intent);
        }else{
        for(int count=0; count < cursor.getCount(); count++){

            cursor.moveToPosition(count);//Berpindah Posisi dari no index 0 hingga no index terakhir

            ListData.add(cursor.getString(1));//Menambil Data Dari Kolom 1 (Nama)
            //Lalu Memasukan Semua Datanya kedalam ArrayList
        }}
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.home:
                Intent intent1 = new Intent(wisatasimpan.this, MainActivity.class);
                startActivity(intent1);
                break;

            case R.id.profil:
                Intent intent2 = new Intent(wisatasimpan.this, profil.class);
                startActivity(intent2);
                break;

            case R.id.daftar_wisata:
                Intent intent3 = new Intent(wisatasimpan.this, daftarwisata.class);
                startActivity(intent3);
                break;

            case R.id.wisata_simpan:
                drawer.closeDrawer(GravityCompat.START);
                break;

            case R.id.exit :
                finish();
                System.exit(0);
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
//11-08-2020,10117265,AbdurrahmanSidiq,IF-8
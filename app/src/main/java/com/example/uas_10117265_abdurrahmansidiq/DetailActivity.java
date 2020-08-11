package com.example.uas_10117265_abdurrahmansidiq;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;


public class DetailActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener ,wisataINF.View{
    private DrawerLayout drawer;
    private Button button_simpan;
    ImageView gambar;
    TextView nama, Des ,longti,lati;
    String namawisata;
    String deskripsi;
    String longtitude;
    String latitude;
    String resName;
    int gambarwisata;
    private Button tombollokasi;
    String SQLiteQuery;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

            // casting id
            gambar = (ImageView) findViewById(R.id.gambar_dw);
            nama = (TextView)findViewById(R.id.text_judul);
            Des = (TextView)findViewById(R.id.text_detail);
            longti = (TextView)findViewById(R.id.text_long);
            lati = (TextView)findViewById(R.id.text_lat);

            // ambil nilai yang di kirim pada saat di klik
            namawisata = getIntent().getStringExtra("Nama");
            deskripsi = getIntent().getStringExtra("Deskripsi");
            longtitude = getIntent().getStringExtra("Longtitude");
            latitude = getIntent().getStringExtra("Latitude");
            gambarwisata = getIntent().getIntExtra("Gambar",0);

            // tampilkan di widged
            gambar.setImageResource(gambarwisata);
            nama.setText(namawisata);
            Des.setText("Deskripsi Wisata : "+deskripsi);

        Toolbar menuToolbar = findViewById(R.id.menuToolBar);
        menuToolbar.setTitle("Detail Wisata");

        drawer = findViewById(R.id.drawer_detail);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, menuToolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        tombollokasi = findViewById(R.id.button_lokasi);
        tombollokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(getApplicationContext(), MapActivity.class);
                //kirimkan parameter
                a.putExtra("Nama", namawisata);
                a.putExtra("Longtitude", longtitude);
                a.putExtra("Latitude", latitude);

                //kirimkan ke detail.java
                startActivity(a);
            }
        });


        button_simpan = findViewById(R.id.button_simpan);
        button_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqLiteDatabase = openOrCreateDatabase("db_wisata.db", Context.MODE_PRIVATE, null);
                sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS tabel_wisata (gambar_wisata INTEGER , nama_wisata VARCHAR PRIMARY KEY," +
                        "deskripsi_wisata VARCHAR,longtitude_wisata VARCHAR,latitude_wisata VARCHAR);");
                if (namawisata.equals(null)) {
                    //Jika kosong, maka tampilkan toast
                    Toast.makeText(DetailActivity.this, "Gagal Simpan", Toast.LENGTH_SHORT).show();
                } else {
                    //Jika edit teks tidak kosong, maka disimpan
                    SQLiteQuery = "INSERT INTO tabel_wisata (gambar_wisata,nama_wisata,deskripsi_wisata,longtitude_wisata,latitude_wisata) VALUES ('" +
                             gambarwisata+ "','" +
                            getNama_wisata() + "','" +
                            getDeskripsi_wisata() + "','" +
                            getLongtitude_wisata() + "','" +
                            getLatitude_wisata() + "');";
                    sqLiteDatabase.execSQL(SQLiteQuery);
                }
                Toast.makeText(DetailActivity.this, "Data Berhasil di Simpan", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DetailActivity.this, wisatasimpan.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.home:
                Intent intent1 = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent1);
                break;

            case R.id.profil:
                Intent intent2 = new Intent(DetailActivity.this, profil.class);
                startActivity(intent2);
                break;

            case R.id.daftar_wisata:
                Intent intent4 = new Intent(DetailActivity.this, daftarwisata.class);
                startActivity(intent4);
                break;

            case R.id.wisata_simpan:
                Intent intent3 = new Intent(DetailActivity.this, wisatasimpan.class);
                startActivity(intent3);
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

    @Override
    public String getNama_wisata() {
        return nama.getText().toString();
    }

    @Override
    public String getDeskripsi_wisata() {
        return Des.getText().toString();
    }

    @Override
    public String getLongtitude_wisata() {
        return longtitude;
    }

    @Override
    public String getLatitude_wisata() {
        return latitude;
    }

    @Override
    public String getGambar_wisata() {
        return resName = getResources().getResourceEntryName(R.id.gambar_dw);
    }

    @Override
    public void setNama_wisata(String nama_wisata) {
        this.nama.setText(namawisata);
    }

    @Override
    public void setDeskripsi_wisata(String deskripsi_wisata) {
        this.Des.setText(deskripsi);
    }

    @Override
    public void setLongtitude_wisata(String longtitude_wisata) {
        this.longti.setText(longtitude);
    }

    @Override
    public void setLatitude_wisata(String latitude_wisata) {
        this.lati.setText(latitude);
    }

    @Override
    public void setGambar_wisata(String gambar_wisata) {
    }
}
//11-08-2020,10117265,AbdurrahmanSidiq,IF-8
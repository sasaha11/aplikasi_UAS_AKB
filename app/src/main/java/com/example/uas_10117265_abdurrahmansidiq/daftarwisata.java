package com.example.uas_10117265_abdurrahmansidiq;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.lang.reflect.Field;

public class daftarwisata extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    // membuat array data list buah
    String list_nama[] = {
            "Wisata Gedung Sate",
            "Wisata Curug Cinulang",
            "Wisata Air Terjun Pelangi",
            "Wisata Stone Garden"
    };
    String deskripsi[] = {
            "Kota Bandung yang sejuk memiliki banyak nilai sejarah yang sisa-sisanya masih dapat kita nikmati hingga sekarang ini, salah satu yang kemudian menjadi ikon kota kembang ini adalah Gedung Sate. Disebut Gedung Sate karena pada bangunan bergaya kolonial Belanda ini ada ornamen yang menjadi ciri khas pada menara sentralnya yang bentuknya menyerupai tusuk sate. Meski telah berdiri sejak tahun 1920, hingga sekarang gedung ini masih beroperasi dengan kokoh yang berfungsi sebagai gedung pemerintahan Jawa Barat.Kini Gedung Sate masih berfungsi sebagaimana awal dibuat, selain tentunya menjadi salah satu objek tujuan wisatabagi wisatawan asing maupun domestik.",
            "Curug Cinulang atau Air Terjun Cinulang berada di Kecamatan Sindulang, Kabupaten Bandung Timur. Tepat berbatasan dengan Kabupaten Sumedang. Karena letaknya inilah, kadangkala curug ini disebut pula namanya dengan Curug Sindulang. Ada pula yang menyebut dengan Curug Cinulang Sumedang sebab letaknya yang berada di perbatasan Sumedang dan Bandung. Air terjun ini berada di lereng pegunungan dan masih dalam wilayah Gunung Masigit Kareumbi, yaitu Taman Bulu. Seperti air terjun lainnya yang berada di pegunungan, Curug Cinulang memiliki hawa yang sejuk serta air yang dingin. Anda yang tidak tahan terhadap dingin, sebaiknya tidak mencoba untuk berenang dan mengenakan jaket tebal saat berkunjung.Sama seperti tiket masuk wisata air terjun lainnya, biaya masuk ke Curug Cinulang sangatlah terjangkau, yaitu Rp. 8.000 saja. Rp. 5.000 untuk retribusi tiket masuk dan Rp. 3.000 sebagai biaya parkir.ampai di dekat lokasi, Anda akan dihadapkan pada pemandangan dua air terjun. Air yang jatuh dari ketinggian ini selalu mengalirkan air deras baik pada musim kering, terlebih penghujan. Tingginya yang mencapai 30 meter ini akan membuat siapapun takjub ketika melihat. Belum menyentuh airnya saja, sudah terasa kesegaran dari airnya.",
            "Curug Cimahi Bandung merupakan salah satu tempat wisata di Bandung yang belum banyak dikunjungi . Curug atau air terjun Cimahi mudah untuk dijangkau dan terletak persis di pinggir jalan raya kolonel Masturi dan tidak jauh dari Universitas Advent bandung.Dikutip dari Wikipedia , Curug atau juga Air Terjun Cimahi ini, memiliki ketinggian sekitar 87 meter. Merupakan salah satu curug yang tertinggi di wilayah Bandung dan sekitarnya.Nama Cimahi berasal dari nama sungai yang mengalir di atasnya yaitu Sungai Cimahi yang berhulu di Situ (danau) Lembang dan mengalir ke Kota Cimahi. Curug ini berada di ketinggian 1050 m dpl dengan suhu di kawasan ini berkisar 18-22 derajat Celsius.",
            "Stone  Garden, adalah sebutan nama untuk hamparan tanah yang diisi oleh  formasi batuan tak beraturan yang indah dan membentuk taman alam.Bandung  memiliki banyak wisata alam yang sangat luar biasa. Ternyata Bandung  memiliki wisata alam gua, yaitu Gua Pawon dan wisata Stone Garden.contoh Gua  Pawon merupakan gua yang terbentuk pada zaman purba.Gua ini digunakan  oleh manusia purba sebagai tempat berlindung. Dan uniknya di atas Gua  Pawon terdapat hamparan bebatuan yang sangat indah dengan pemandangan  luar biasa dikenal dengan nama Stone Garden -Taman Batu. Tidak kalah  indah dengan wisata alam Tangkuban Perahu, Kawah Putih Ciwidey, dan Situ  Patengan merupakan kawasan wisata alam yang sering dikunjungi oleh  banyak wisatawan lokal maupun mancanegara.Stone  Garden terletak di Kampung Girimulya Desa Gunung Masigit, Kecamatan  Cipatat Kabupaten Bandung Barat dengan memakan waktu tempuh 1 -- 2 jam  dari pusat kota Bandung."
    };

    String list_longtitude[] = {
            "107.619081",
            "107.882369",
            "107.578250",
            "107.435533"
    };
    String list_latitude[] = {
            "-6.902367",
            "-6.963013",
            "-6.799006",
            "-6.827844"
    };

    // daftar gambar
    int list_gambar[] = {
            R.drawable.gedungsate,
            R.drawable.curugcinulang,
            R.drawable.airterjuncimahi,
            R.drawable.stonegarden
    };


    ListView listwisata;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftarwisata);

        listwisata = (ListView) findViewById(R.id.listwisata);
        AdapterWisata adapter = new AdapterWisata(daftarwisata.this, list_nama, list_gambar, deskripsi , list_longtitude, list_latitude);
        listwisata.setAdapter(adapter);

        listwisata.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // inten ke detail.java dengan mengirimkan parameter yang berisi nama dan gambar
                Intent a = new Intent(getApplicationContext(), DetailActivity.class);
                //kirimkan parameter
                a.putExtra("Nama", list_nama[position]);
                a.putExtra("Gambar", list_gambar[position]);
                a.putExtra("Deskripsi", deskripsi[position]);
                a.putExtra("Longtitude", list_longtitude[position]);
                a.putExtra("Latitude", list_latitude[position]);

                //kirimkan ke detail.java
                startActivity(a);
            }
        });

        Toolbar menuToolbar = findViewById(R.id.menuToolBar);
        menuToolbar.setTitle("List Wisata");

        drawer = findViewById(R.id.drawer_daftarwisata);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, menuToolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setCheckedItem(R.id.daftar_wisata);
    }

    private class AdapterWisata extends ArrayAdapter {
        String list_nama[];
        String deskripsi[];
        String list_longtitude[];
        String list_latitude[];
        int list_gambar[];
        Activity activity;

        //konstruktor
        public AdapterWisata(daftarwisata dw, String[] list_nama, int[] list_gambar, String[] deskripsi, String[] list_longtitude, String[] list_latitude) {
            super(dw, R.layout.list_wisata, list_nama);
            this.list_gambar = list_gambar;
            activity = dw;
            this.list_nama = list_nama;
            this.deskripsi = deskripsi;
            this.list_longtitude = list_longtitude;
            this.list_latitude = list_latitude;

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // panggil layout list_buah
            LayoutInflater inflater = (LayoutInflater) activity.getLayoutInflater();
            View v = inflater.inflate(R.layout.list_wisata, null);
            // kenalkan widget yang ada pada list buah
            ImageView gambar;
            TextView nama;
            TextView des;

            //casting widget id
            gambar = (ImageView) v.findViewById(R.id.gambar_wisata);
            nama = (TextView) v.findViewById(R.id.judulwisata);
            des = (TextView) v.findViewById(R.id.infowisata);

            // set data kedalam image
            gambar.setImageResource(list_gambar[position]);
            nama.setText(list_nama[position]);
            des.setText(deskripsi[position]);

            return v;
        }
    }

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.home:
                    Intent intent1 = new Intent(daftarwisata.this, MainActivity.class);
                    startActivity(intent1);
                    break;

                case R.id.profil:
                    Intent intent2 = new Intent(daftarwisata.this, profil.class);
                    startActivity(intent2);
                    break;

                case R.id.daftar_wisata:
                    drawer.closeDrawer(GravityCompat.START);
                    break;

                case R.id.wisata_simpan:
                    Intent intent3 = new Intent(daftarwisata.this, wisatasimpan.class);
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

    }

//10-08-2020,10117265,AbdurrahmanSidiq,IF-8
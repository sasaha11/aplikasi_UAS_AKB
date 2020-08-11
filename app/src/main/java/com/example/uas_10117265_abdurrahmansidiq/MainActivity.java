package com.example.uas_10117265_abdurrahmansidiq;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    String SQLiteQuery;
    SQLiteDatabase sqLiteDatabase;
    private SlidePagerAdapter pagerAdapter;
    private TabLayout tabLayout;
    private ViewPager pager;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sqLiteDatabase = openOrCreateDatabase("db_wisata.db", Context.MODE_PRIVATE, null);
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS tabel_wisata (gambar_wisata INTEGER , nama_wisata VARCHAR PRIMARY KEY," +
                "deskripsi_wisata VARCHAR,longtitude_wisata VARCHAR,latitude_wisata VARCHAR);");
        Toolbar toolbar = findViewById(R.id.menuToolBar);
        toolbar.setTitle("Home");

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        List<Fragment> list = new ArrayList<>();
        list.add(new page_1());
        list.add(new page_2());
        list.add(new page_3());

        pager = findViewById(R.id.pager);
        pagerAdapter = new SlidePagerAdapter(getSupportFragmentManager(), list);
        pager.setAdapter(pagerAdapter);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.home:
                drawer.closeDrawer(GravityCompat.START);
                break;

            case R.id.profil:
                Intent intent1 = new Intent(MainActivity.this, profil.class);
                startActivity(intent1);
                break;

            case R.id.daftar_wisata:
                Intent intent2 = new Intent(MainActivity.this, daftarwisata.class);
                startActivity(intent2);
                break;

            case R.id.wisata_simpan:
                Intent intent3 = new Intent(MainActivity.this, wisatasimpan.class);
                startActivity(intent3);
                break;

            case R.id.exit:
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
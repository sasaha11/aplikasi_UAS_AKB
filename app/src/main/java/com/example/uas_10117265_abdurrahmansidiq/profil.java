package com.example.uas_10117265_abdurrahmansidiq;

import android.content.Intent;
import android.os.Bundle;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class profil extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        Toolbar menuToolbar = findViewById(R.id.menuToolBar);
        menuToolbar.setTitle("Profil");

        drawer = findViewById(R.id.drawer_profile);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, menuToolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setCheckedItem(R.id.profil);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.home:
                Intent intent1 = new Intent(profil.this, MainActivity.class);
                startActivity(intent1);
                break;

            case R.id.profil:
                drawer.closeDrawer(GravityCompat.START);
                break;

            case R.id.daftar_wisata:
                Intent intent2 = new Intent(profil.this, daftarwisata.class);
                startActivity(intent2);
                break;

            case R.id.wisata_simpan:
                Intent intent3 = new Intent(profil.this, wisatasimpan.class);
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

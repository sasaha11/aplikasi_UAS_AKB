package com.example.uas_10117265_abdurrahmansidiq;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.navigation.NavigationView;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback , NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    String longtitude;
    String latitude;
    String namawisata;
    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        namawisata = getIntent().getStringExtra("Nama");
        longtitude = getIntent().getStringExtra("Longtitude");
        latitude = getIntent().getStringExtra("Latitude");

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Toolbar menuToolbar = findViewById(R.id.menuToolBar);
        menuToolbar.setTitle("Google Map");

        drawer = findViewById(R.id.drawer_map);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, menuToolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.home:
                Intent intent1 = new Intent(MapActivity.this, MainActivity.class);
                startActivity(intent1);
                break;

            case R.id.profil:
                Intent intent2 = new Intent(MapActivity.this, profil.class);
                startActivity(intent2);
                break;

            case R.id.daftar_wisata:
                Intent intent4 = new Intent(MapActivity.this, daftarwisata.class);
                startActivity(intent4);
                break;

            case R.id.wisata_simpan:
                Intent intent3 = new Intent(MapActivity.this, wisatasimpan.class);
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
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        double valuelat = Double.parseDouble(latitude);
        double valuelong = Double.parseDouble(longtitude);

        LatLng lokasi = new LatLng(valuelat, valuelong);
        mMap.addMarker(new MarkerOptions().position(lokasi).title(namawisata));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lokasi));
    }
}
//10-08-2020,10117265,AbdurrahmanSidiq,IF-8
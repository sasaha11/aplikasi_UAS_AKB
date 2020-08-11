package com.example.uas_10117265_abdurrahmansidiq;

public class wisataClass {
    String nama_wisata;
    String deskripsi_wisata;
    String longtitude_wisata;
    String latitude_wisata;
    String gambar_wisata;

    public wisataClass(String nama_wisata, String deskripsi_wisata   , String longtitude_wisata,String latitude_wisata , String gambar_wisata) {
        this.nama_wisata = nama_wisata;
        this.deskripsi_wisata = deskripsi_wisata;
        this.longtitude_wisata = longtitude_wisata;
        this.latitude_wisata = latitude_wisata;
        this.gambar_wisata = gambar_wisata;
    }
    public String getNama_wisata() {
        return nama_wisata;
    }
    public String getDeskripsi_wisata() {
        return deskripsi_wisata;
    }
    public String getLongtitude_wisata() {
        return longtitude_wisata;
    }
    public String getLatitude_wisata() {
        return latitude_wisata;
    }
    public String getGambar_wisata() {
        return gambar_wisata;
    }
}
//11-08-2020,10117265,AbdurrahmanSidiq,IF-8
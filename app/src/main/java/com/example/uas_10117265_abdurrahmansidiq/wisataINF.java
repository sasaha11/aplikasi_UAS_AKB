package com.example.uas_10117265_abdurrahmansidiq;

import com.example.uas_10117265_abdurrahmansidiq.wisataClass;

public interface wisataINF {
    interface View {
        String getNama_wisata();
        String getDeskripsi_wisata();
        String getLongtitude_wisata();
        String getLatitude_wisata();
        String getGambar_wisata();

        void setNama_wisata(String nama_wisata);
        void setDeskripsi_wisata(String deskripsi_wisata);
        void setLongtitude_wisata(String longtitude_wisata);
        void setLatitude_wisata(String latitude_wisata);
        void setGambar_wisata(String gambar_wisata);
    }

    interface Presenter {
        void setView(View view);
        void getCurrentUser();
    }
    interface Model {
        wisataClass getWisataClass();

    }
}
//11-08-2020,10117265,AbdurrahmanSidiq,IF-8
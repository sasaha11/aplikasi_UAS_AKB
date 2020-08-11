package com.example.uas_10117265_abdurrahmansidiq;

import com.example.uas_10117265_abdurrahmansidiq.wisataClass;

public class wisataPresenter  implements wisataINF.Presenter{
    private wisataINF.View view;
    private wisataINF.Model model;

    @Override
    public void setView(wisataINF.View view) {
        this.view = view;
    }

    @Override
    public void getCurrentUser() {
    wisataClass wisataclass = model.getWisataClass();
    view.setNama_wisata(wisataclass.getNama_wisata());
    view.setDeskripsi_wisata(wisataclass.getDeskripsi_wisata());
    view.setLongtitude_wisata(wisataclass.getLongtitude_wisata());
    view.setLatitude_wisata(wisataclass.getLatitude_wisata());
    view.setGambar_wisata(wisataclass.getGambar_wisata());
    }
}
//11-08-2020,10117265,AbdurrahmanSidiq,IF-8
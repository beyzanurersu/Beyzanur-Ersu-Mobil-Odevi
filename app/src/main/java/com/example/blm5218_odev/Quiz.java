package com.example.blm5218_odev;

public class Quiz {

    private String soruno;
    private String soru;
    private String cevap1;
    private String cevap2;
    private String cevap3;
    private String cevap4;
    private String dogru_cevap;
    private String zorluk;
    private int photoid;

    public Quiz(String soruno, String soru, String cevap1, String cevap2, String cevap3, String cevap4, String dogru_cevap, String zorluk, int photoid) {
        this.soruno=soruno;
        this.soru = soru;
        this.cevap1 = cevap1;
        this.cevap2 = cevap2;
        this.cevap3 = cevap3;
        this.cevap4 = cevap4;
        this.dogru_cevap = dogru_cevap;
        this.zorluk=zorluk;
        this.photoid=photoid;
    }



    public String getSoruno() {
        return soruno;
    }

    public void setSoruno(String soruno) {
        this.soruno = soruno;
    }

    public String getSoru() {
        return soru;
    }

    public void setSoru(String soru) {
        this.soru = soru;
    }

    public String getCevap1() {
        return cevap1;
    }

    public void setCevap1(String cevap1) {
        this.cevap1 = cevap1;
    }

    public String getCevap2() {
        return cevap2;
    }

    public void setCevap2(String cevap2) {
        this.cevap2 = cevap2;
    }

    public String getCevap3() {
        return cevap3;
    }

    public void setCevap3(String cevap3) {
        this.cevap3 = cevap3;
    }

    public String getCevap4() {
        return cevap4;
    }

    public void setCevap4(String cevap4) {
        this.cevap4 = cevap4;
    }

    public String getDogru_cevap() {
        return dogru_cevap;
    }

    public void setDogru_cevap(String dogru_cevap) {
        this.dogru_cevap = dogru_cevap;
    }

    public String getZorluk() {
        return zorluk;
    }

    public void setZorluk(String zorluk) {
        this.zorluk = zorluk;
    }

    public int getPhotoid() {
        return photoid;
    }

    public void setPhotoid(int photoid) {
        this.photoid = photoid;
    }



}

package Modul3.soal2;

public class Negara {
    private String nama;
    private String jenisKepemimpinan;
    private String namaPemimpin;
    private int tanggalKemerdekaan;
    private int bulanKemerdekaan;
    private int tahunKemerdekaan; 

    public Negara(String nama, String jenisKepemimpinan, String namaPemimpin, int tanggalKemerdekaan, int bulanKemerdekaan, int tahunKemerdekaan){
        setNama(nama);
        setJenisKepemimpinan(jenisKepemimpinan);
        setNamaPemimpin(namaPemimpin);
        setTanggalKemerdekaan(tanggalKemerdekaan);
        setBulanKemerdekaan(bulanKemerdekaan);
        setTahunKemerdekaan(tahunKemerdekaan);
    };

    public Negara(String nama, String jenisKepemimpinan, String namaPemimpin){
        setNama(nama);
        setJenisKepemimpinan(jenisKepemimpinan);
        setNamaPemimpin(namaPemimpin);
    };


    public String getNama() {
        return nama;
    }

    public String getJenisKepemimpinan() {
        return jenisKepemimpinan;
    }

    public String getNamaPemimpin() {
        return namaPemimpin;
    }

    public int getTanggalKemerdekaan() {
        return tanggalKemerdekaan;
    }

    public int getBulanKemerdekaan(){
        return bulanKemerdekaan;
    }

    public int getTahunKemerdekaan() {
        return tahunKemerdekaan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJenisKepemimpinan(String jenisKepemimpinan) {
        this.jenisKepemimpinan = jenisKepemimpinan;
    }

    public void setNamaPemimpin(String namaPemimpin) {
        this.namaPemimpin = namaPemimpin;
    }

    public void setTanggalKemerdekaan(int tanggalKemerdekaan) {
        this.tanggalKemerdekaan = tanggalKemerdekaan;
    }

    public void setBulanKemerdekaan(int bulanKemerdekaan) {
        this.bulanKemerdekaan = bulanKemerdekaan;
    }

    public void setTahunKemerdekaan(int tahunKemerdekaan) {
        this.tahunKemerdekaan = tahunKemerdekaan;
    }
}
package Modul3.soal3;

public class Mahasiswa {
    private String nama;
    private String nim;

    public Mahasiswa(String nama, String nim){
        setNama(nama);
        setNim(nim);
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }
}
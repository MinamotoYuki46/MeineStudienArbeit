package Modul4.soal1;

public class HewanPeliharaan {
    private String nama;
    private String ras;

    public HewanPeliharaan(String r, String n){
        setNama(n);
        setRas(r);
    }

    public void display(){
        System.out.println("Detail Hewan Peliharaan:");
        System.out.println("Nama hewan peliharaanku adalah : " + getNama());
        System.out.println("Dengan ras : " + getRas());
    }

    public String getNama(){
        return this.nama;
    }

    public String getRas(){
        return this.ras;
    }

    public void setNama(String n){
        this.nama = n;
    }

    public void setRas(String r){
        this.ras = r;
    }
}
package PRAKTIKUM7.model;

public class Buku {
    private String buku_id;
    private String judul;
    private String penulis;
    private Double harga;
    private Integer stok;

    public Buku(String IDBuku, String judul, String penulis, Double harga, Integer stok){
        this.buku_id = IDBuku;
        this.judul = judul;
        this.penulis = penulis;
        this.harga = harga;
        this.stok = stok;
    }

    public String getIDBuku() {
        return this.buku_id;
    }

    public void setIDBuku(String IDBuku) {
        this.buku_id = IDBuku;
    }

    public String getJudul() {
        return this.judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return this.penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public Double getHarga() {
        return this.harga;
    }

    public String getHargaStr() {
        return String.format("%.2f", this.harga);
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }

    public Integer getStok() {
        return this.stok;
    }

    public String getStokStr(){
        return this.stok.toString();
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }
}

package PRAKTIKUM7.model;

public class Penjualan {
    private String penjualan_id;
    private Integer jumlah;
    private Double total_harga;
    private String pelanggan_id;
    private String buku_id;

    public Penjualan(String penjualan_id, Integer jumlah, Double total_harga, String pelanggan_id, String buku_id){
        this.penjualan_id = penjualan_id;
        this.jumlah = jumlah;
        this.total_harga = total_harga;
        this.pelanggan_id = pelanggan_id;
        this.buku_id = buku_id;
    }

    public String getPenjualan_id() {
        return this.penjualan_id;
    }

    public void setPenjualan_id(String penjualan_id) {
        this.penjualan_id = penjualan_id;
    }

    public Integer getJumlah() {
        return this.jumlah;
    }

    public String getJumlahStr() {
        return this.jumlah.toString();
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public Double getTotal_harga() {
        return this.total_harga;
    }

    public String getTotal_hargaStr() {
        return String.format("%.2f", this.total_harga);
    }

    public void setTotal_harga(Double total_harga) {
        this.total_harga = total_harga;
    }

    public String getPelanggan_id() {
        return this.pelanggan_id;
    }

    public void setPelanggan_id(String pelanggan_id) {
        this.pelanggan_id = pelanggan_id;
    }

    public String getBuku_id() {
        return this.buku_id;
    }

    public void setBuku_id(String buku_id) {
        this.buku_id = buku_id;
    }
}
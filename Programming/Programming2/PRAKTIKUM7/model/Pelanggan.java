package PRAKTIKUM7.model;

public class Pelanggan {
    private String pelanggan_id;
    private String nama;
    private String email;
    private String telepon;

    public Pelanggan(String pelanggan_id, String nama, String email, String nomor_teleppon){
        this.pelanggan_id = pelanggan_id;
        this.nama = nama;
        this.email = email;
        this.telepon = nomor_teleppon;
    }

    public String getPelanggan_id() {
        return this.pelanggan_id;
    }

    public void setPelanggan_id(String pelanggan_id) {
        this.pelanggan_id = pelanggan_id;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomor_telepon() {
        return this.telepon;
    }

    public void setNomor_telepon(String nomor_telepon) {
        this.telepon = nomor_telepon;
    }
}
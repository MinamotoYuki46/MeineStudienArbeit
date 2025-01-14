package PRAKTIKUM6.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Mahasiswa {
    private int id;
    private String nama;
    private String nim;

    public Mahasiswa(int id, String nama, String nim){
        this.id = id;
        this.nama = nama;
        this.nim = nim;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public StringProperty namaProperty() {
        return new SimpleStringProperty(nama);
    }

    public String getNim() {
        return this.nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public StringProperty nimProperty() {
        return new SimpleStringProperty(nim);
    }

    
}

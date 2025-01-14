package Modul4.soal2;

import Modul4.soal1.HewanPeliharaan;

public class Kucing extends HewanPeliharaan {
    private String warnaBulu;

    public Kucing(String r, String n, String w){
        super(r, n);
        setWarnaBulu(w);
    }

    public void displayDetailKucing(){
        display();
        System.out.println("Memiliki warna bulu : " + getWarnaBulu());
    }

    public String getWarnaBulu(){
        return this.warnaBulu;
    }

    public void setWarnaBulu(String w){
        this.warnaBulu = w;
    }
}

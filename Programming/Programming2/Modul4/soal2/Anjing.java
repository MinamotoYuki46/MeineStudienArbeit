package Modul4.soal2;

import Modul4.soal1.HewanPeliharaan;

public class Anjing extends HewanPeliharaan{
    private String warnaBulu;
    private String[] kemampuan;

    public Anjing(String n, String r, String w, String[] k){
        super(r, n);
        setWarnaBulu(w);
        setKemampuan(k);
    }

    public void displayDetailAnjing(){
        display();
        System.out.println("Memiliki warna bulu : " + getWarnaBulu());
        System.out.print("Memiliki kemampuan : ");
        
        for (String i : kemampuan){
            System.out.print(i + " ");
        }
    }

    public String getWarnaBulu(){
        return this.warnaBulu;
    }

    public String[] getKemampuan(){
        return this.kemampuan;
    }

    public void setWarnaBulu(String w){
        this.warnaBulu = w;
    }

    public void setKemampuan(String[] k){
        this.kemampuan = k;
    }
}

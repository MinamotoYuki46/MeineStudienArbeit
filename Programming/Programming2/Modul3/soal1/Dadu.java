package Modul3.soal1;

import java.util.Random;

public class Dadu {
    private Random random = new Random();
    private int nilai;

    public Dadu(){
        acakNilai();
    };

    private void acakNilai(){
        setNilai(random.nextInt(6) + 1); 
    }

    public int getNilai(){
        return this.nilai;
    }

    public void setNilai(int n){
        this.nilai = n;
    }
}
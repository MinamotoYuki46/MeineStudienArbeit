package Modul4.soal1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nama, ras;
    
        System.out.print("Nama Hewan Peliharaan: ");
        nama = sc.nextLine();
    
        System.out.print("Ras: ");
        ras = sc.nextLine();
    
        HewanPeliharaan hewan1 = new HewanPeliharaan(ras, nama);
    
        hewan1.display();
        sc.close();
    }
}

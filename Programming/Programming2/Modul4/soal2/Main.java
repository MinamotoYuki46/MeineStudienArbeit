package Modul4.soal2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opt;

        System.out.println("Pilih jenis hewan yang ingin diinputkan");
        System.out.println("1 = Kucing");
        System.out.println("2 = Anjing");


        while(true){
            System.out.print("Masukkan pilihan: ");
            opt = sc.nextInt(); sc.nextLine();

            if (opt != 1 && opt != 2){
                System.out.println("Pilihan tidak tersedia, harap masukkan kembali opsi");
            }
            else{
                break;
            }
        }

        String nama, ras, warnaBulu;
        
        System.out.print("Nama Hewan Peliharaan: ");
        nama = sc.nextLine();
    
        System.out.print("Ras: ");
        ras = sc.nextLine();

        System.out.print("Warna Bulu: ");
        warnaBulu = sc.nextLine();

        if (opt == 1){
            Kucing kucing = new Kucing(ras, nama, warnaBulu);
            kucing.displayDetailKucing();
        }
        else if (opt == 2){
            String[] kemampuan;

            System.out.print("Kemampuan: ");
            kemampuan = sc.nextLine().split(",");

            Anjing anjing = new Anjing(nama, ras, warnaBulu, kemampuan);
            anjing.displayDetailAnjing();
        }

        sc.close();;
    }
}

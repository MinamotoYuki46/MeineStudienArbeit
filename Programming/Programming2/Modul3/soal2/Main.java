package Modul3.soal2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Negara> ListNegara = new LinkedList<>();

        int n = sc.nextInt(); sc.nextLine();
        String nama, jenisKepemimpinan, namaPemimpin;
        int tanggalKemerdekaan, tahunKemerdekaan, bulanKemerdekaan;

        HashMap<Integer, String> namaBulan = new HashMap<>(){{
        put(1, "Januari");
        put(2, "Feburari");
        put(3, "Maret");
        put(4, "April");
        put(5, "Mei");
        put(6, "Juni");
        put(7, "Juli");
        put(8, "Agustus");
        put(9, "September");
        put(10, "Oktober");
        put(11, "November");
        put(12, "Desember");
    }};

    HashMap<String, String> kepalaPemerintahan = new HashMap<>(){{
        put("presiden", "Presiden");
        put("monarki", "Raja");
        put("perdana menteri", "Perdana Menteri");
    }};

        for(int i = 0; i < n; i++){
            nama = sc.nextLine();
            jenisKepemimpinan = sc.nextLine();
            namaPemimpin = sc.nextLine();

            if (jenisKepemimpinan.equals("monarki")) {
                ListNegara.add(new Negara(nama, jenisKepemimpinan, namaPemimpin));
            }
            else {
                tanggalKemerdekaan = sc.nextInt(); sc.nextLine();
                bulanKemerdekaan = sc.nextInt(); sc.nextLine();
                tahunKemerdekaan = sc.nextInt(); sc.nextLine();
                
                ListNegara.add(new Negara(nama, jenisKepemimpinan, namaPemimpin, tanggalKemerdekaan, bulanKemerdekaan, tahunKemerdekaan));
            }
        }

        for(Negara negara : ListNegara){
            System.out.printf("Negara %s memiliki %s bernama %s\n", negara.getNama(), kepalaPemerintahan.get(negara.getJenisKepemimpinan()), negara.getNamaPemimpin());
            if (negara.getJenisKepemimpinan().equals("monarki")) {
                System.out.println();
                continue;
            }
            System.out.printf("Deklarasi Kemerdekaan pada Tanggal %d %s %d\n", negara.getTanggalKemerdekaan(), namaBulan.get(negara.getBulanKemerdekaan()), negara.getTahunKemerdekaan());
            System.out.println();
        }
        sc.close();
    }
}
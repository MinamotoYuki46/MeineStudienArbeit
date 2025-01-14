package Modul3.soal3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static ArrayList<Mahasiswa> DaftarMahasiswa = new ArrayList<>();
    public static Set<String> UID = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opt;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa berdasarkan NIM");
            System.out.println("3. Cari Mahasiswa berdasarkan NIM");
            System.out.println("4. Tampilkan Daftar Mahasiswa");
            System.out.println("0. Keluar\n");

            System.out.print("Pilihan: ");
            while (!sc.hasNextInt()) {
                System.out.println("Masukkan angka yang valid!");
                System.out.print("Pilihan: ");
                sc.next();
            }
            opt = sc.nextInt(); sc.nextLine();

            switch (opt) {
                case 1:
                    tambahMahasiswa(sc);
                    break;
                case 2:
                    hapusMahasiswa(sc);
                    break;
                case 3:
                    tampilkanMahasiswa(sc);
                    break;
                case 4:
                    tampilkanSemuaMahasiswa();
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Opsi yang dimasukkan tidak tersedia");
            }
        } while (opt != 0);
        sc.close();
    }

    public static void tambahMahasiswa(Scanner sc) {
        String nama, nim;

        System.out.print("Masukkan Nama Mahasiswa: ");
        nama = sc.nextLine();

        while (true) {
            System.out.print("Masukkan NIM Mahasiswa: ");
            nim = sc.nextLine();

            if (UID.contains(nim)) {
                System.out.println("NIM sudah dipakai! Masukkan ulang NIM!");
            } 
            else {
                DaftarMahasiswa.add(new Mahasiswa(nama, nim));
                UID.add(nim);
                System.out.printf("Mahasiswa %s dengan NIM %s telah dimasukkan.\n", nama, nim);
                break;
            }
        }
    }

    public static void hapusMahasiswa(Scanner sc) {
        System.out.print("Masukkan NIM Mahasiswa: ");
        String nim = sc.nextLine();

        if (UID.contains(nim)) {
            Mahasiswa mhs = cariMahasiswa(nim);
            DaftarMahasiswa.remove(mhs);
            UID.remove(nim);
            System.out.printf("Mahasiswa dengan NIM %s telah dihapus.\n", nim);
            
        } 
        else {
            System.out.println("NIM tidak ditemukan.");
        }
    }

    public static Mahasiswa cariMahasiswa(String nim) {
        for (Mahasiswa mhs : DaftarMahasiswa) {
            if (mhs.getNim().equals(nim)) {
                return mhs;
            }
        }
        return null;
    }

    public static void tampilkanMahasiswa(Scanner sc) {
        System.out.print("Masukkan NIM Mahasiswa: ");
        String nim = sc.nextLine();

        if (UID.contains(nim)) {
            Mahasiswa mhs = cariMahasiswa(nim);
            System.out.println("Nama: " + mhs.getNama());
            System.out.println("NIM : " + mhs.getNim());
        } 
        else {
            System.out.println("NIM tidak ditemukan.");
        }
    }

    public static void tampilkanSemuaMahasiswa() {
        if (DaftarMahasiswa.isEmpty()) {
            System.out.println("Daftar mahasiswa kosong!");
        } 
        else {
            System.out.println("Daftar Mahasiswa:");
            System.out.printf("%-13s | %-40s\n", "NIM", "Nama");
            System.out.println("=".repeat(43));
            for (Mahasiswa mhs : DaftarMahasiswa) {
                System.out.printf("%-13s | %-40s\n", mhs.getNim(), mhs.getNama());
            }
        }
    }
}

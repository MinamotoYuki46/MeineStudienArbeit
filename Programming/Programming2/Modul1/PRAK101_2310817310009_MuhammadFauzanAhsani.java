package com.laporan.praktikum1;

import java.util.Scanner;

public class PRAK101_2310817310009_MuhammadFauzanAhsani {
	public static void main(String[] args) {
		String name, birthNation, monthText = "";
		int date, month, year;
		double height, weight;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Masukkan Nama Lengkap: ");
		name = sc.nextLine();
		
		System.out.print("Masukkan Tempat Lahir: ");
		birthNation = sc.nextLine();
		
		System.out.print("Masukkan Tanggal Lahir: ");
		date = sc.nextInt();
		
		System.out.print("Masukkan Bulan Lahir: ");
		month = sc.nextInt();
		
		System.out.print("Masukkan Tahun Lahir: ");
		year = sc.nextInt();
		
		System.out.print("Masukkan Tinggi Badan: ");
		height = sc.nextDouble();
		
		System.out.print("Masukkan Berat Badan: ");
		weight = sc.nextDouble();
		
		switch (month) {
		    case 1:  monthText = "Januari"; break;
		    case 2:  monthText = "Februari"; break;
		    case 3:  monthText = "Maret"; break;
		    case 4:  monthText = "April"; break;
		    case 5:  monthText = "Mei"; break;
		    case 6:  monthText = "Juni"; break;
		    case 7:  monthText = "Juli"; break;
		    case 8:  monthText = "Agustus"; break;
		    case 9:  monthText = "September"; break;
		    case 10: monthText = "Oktober"; break;  
		    case 11: monthText = "November"; break;
		    case 12: monthText = "Desember"; break;  
		}

		
		System.out.printf("Nama Lengkap %s, Lahir di %s pada Tanggal %d %s %d Tinggi Badan %.0f cm dan Berat Badan %.2f kilogram", name, birthNation, date, monthText, year, height, weight);
	}
		 
}
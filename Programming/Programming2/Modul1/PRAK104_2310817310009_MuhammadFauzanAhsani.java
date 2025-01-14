package com.laporan.praktikum1;

import java.util.Scanner;

public class PRAK104_2310817310009_MuhammadFauzanAhsani {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] tanganAbu = new String[3], tanganBagas = new String[3];
		int pemenang = 0;
		
		System.out.print("Tangan Abu: ");
		for(int i = 0; i < 3; i++) tanganAbu[i] = sc.next();
		
		System.out.print("Tangan Bagas: ");
		for(int i = 0; i < 3; i++) tanganBagas[i] = sc.next();
		
		for(int i = 0; i < 3; i++) {
			if (tanganAbu[i].equals("G") && tanganBagas[i].equals("K") ||
				tanganAbu[i].equals("K") && tanganBagas[i].equals("B") || 
				tanganAbu[i].equals("B") && tanganBagas[i].equals("G")) 
				pemenang++;
			else if (tanganAbu[i].equals(tanganBagas[i])) continue;
			else pemenang--;
		}
		
		if 		(pemenang > 0) 		System.out.print("Abu");
		else if (pemenang == 0) 	System.out.print("Seri");
		else						System.out.print("Bagas");
	}
}

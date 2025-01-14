package com.laporan.praktikum1;

import java.util.Scanner;

public class PRAK103_2310817310009_MuhammadFauzanAhsani {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(), start = sc.nextInt();
		
		do {
			if (start % 2 == 1) {
				System.out.print(start);
				n--;
				if (n > 0) System.out.print(", ");
			}
			
			start++;
		} while(n > 0);
	}
}

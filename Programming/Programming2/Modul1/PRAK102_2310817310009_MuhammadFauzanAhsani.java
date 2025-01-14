package com.laporan.praktikum1;

import java.util.Scanner;

public class PRAK102_2310817310009_MuhammadFauzanAhsani {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int i = 11, start = sc.nextInt();
		
		while(i > 0) {
			if (start % 5 == 0) System.out.print(start/5 - 1);
			else 				System.out.print(start);
									
			start++;
			i--;
			if (i > 0) System.out.print(",");
		}
	}
}

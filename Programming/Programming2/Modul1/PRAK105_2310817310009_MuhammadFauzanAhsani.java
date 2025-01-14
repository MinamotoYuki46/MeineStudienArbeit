package com.laporan.praktikum1;

import java.util.Scanner;

public class PRAK105_2310817310009_MuhammadFauzanAhsani {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		final double PI = 3.14;
		double rad, hgt;
		
		System.out.print("Masukkan jari-jari: ");
		rad = sc.nextDouble();
		
		System.out.print("Masukkan tinggi: ");
		hgt = sc.nextDouble();
		
		System.out.printf("Volume tabung dengan jari-jari %.1f cm dan tinggi %.1f cm adalah %.3f m3", rad, hgt, PI * hgt * Math.pow(rad, 2));
		
	}
}

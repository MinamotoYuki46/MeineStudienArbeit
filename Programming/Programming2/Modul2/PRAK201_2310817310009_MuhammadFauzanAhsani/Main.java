package PRAK201_2310817310009_MuhammadFauzanAhsani;

public class Main {
	public static void main(String args[]) {
		Buah apel = new Buah("Apel", 7000, 0.4, 40);
		Buah mangga = new Buah("mangga", 3500, 0.2, 15);
		Buah alpukat = new Buah("alpukat", 10000, 0.25, 12);
		
		apel.cetakInformasi();
		mangga.cetakInformasi();
		alpukat.cetakInformasi();
	}
}
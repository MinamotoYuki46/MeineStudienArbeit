package PRAK201_2310817310009_MuhammadFauzanAhsani;

public class Buah{
		private String nama;
		private final double rasioDiskon = 0.02;
		private double harga;
		private double berat;
		private double totalBerat;
		private double hargaBfrDiskon;
		private double potonganHarga;
		private double hargaAtrDiskon;
		
		public Buah (String namaBuah, double harga, double perKiloan, double totalBerat) {
			this.nama = namaBuah;
			this.harga = harga;
			this.berat = perKiloan;
			this.totalBerat = totalBerat;
			this.hargaBfrDiskon = this.harga / this.berat * this.totalBerat;
			this.potonganHarga = Math.floor(this.totalBerat / 4.0) * this.rasioDiskon * this.harga * 4.0;
			this.hargaAtrDiskon = this.hargaBfrDiskon - this.potonganHarga;
		}
		
		public void cetakInformasi(){
			System.out.printf("Nama Buah: %s %n", this.nama);
			System.out.printf("Berat: %s %n", this.berat);
			System.out.printf("Harga: %.1f %n", this.harga);
			System.out.printf("Jumlah Beli: %.1fkg %n", this.totalBerat);
			System.out.printf("Harga Sebelum Diskon: Rp%.2f %n", this.hargaBfrDiskon);
			System.out.printf("Total Diskon: Rp%.2f %n", this.potonganHarga);
			System.out.printf("Harga Setelah Diskon: Rp%.2f %n%n", this.hargaAtrDiskon);
		}
}

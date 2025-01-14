package PRAK203_2310817310009_MuhammadFauzanAhsani;

public class Soal3Main {
	public static void main(String[] args) {
		Pegawai p1 = new Pegawai();
//		Pada baris di bawah terjadi eror karena pada akhir baris tidak terdapat titik koma (;)
//		p1.nama = "Roi"
		p1.nama = "Roi";
		p1.asal = "Kingdom of Orvel";
		p1.setJabatan("Assasin");
		
// 		Kata "pegawai" tidak perlu ditampilkan
// 		System.out.println("Nama Pegawai: " + p1.getNama());
		System.out.println("Nama: " + p1.getNama());

		System.out.println("Asal: " + p1.getAsal());
		System.out.println("Jabatan: " + p1.jabatan);
// 		Pada baris di bawah ini atribut umur belum diberikan nilai sama sekali, maka perlu isi nilainya. Selain itu, kata "tahun" belum ditambahkan
// 		System.out.println("Umur: " + p1.umur);
		System.out.println("Umur: " + (p1.umur = 17) + " tahun");
	}
}
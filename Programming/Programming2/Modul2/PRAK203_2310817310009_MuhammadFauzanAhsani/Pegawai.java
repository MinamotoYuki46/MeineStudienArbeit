package PRAK203_2310817310009_MuhammadFauzanAhsani;

//Pada baris di bawah terjadi eror karena nama kelas dan nama file tidak sama, maka "Employee" diganti dengan "Pegawai"
//public class Employee
public class Pegawai {
	public String nama;
//	Pada baris di bawah perlu diperbaiki karena "asal" harusnya menyimpan sebuah kata (String), sedangkan char hanya menyimpan 1 huruf (karakter)
//	public char asal;
	public String asal;
	public String jabatan;
	public int umur;
	
	public String getNama() {
		return nama;
	}
	
	public String getAsal() {
		return asal;
	}
	
//	Pada baris di bawah terjadi eror karena tidak terdapat variabel parameter yang dijadikan acuan untuk memasukkan nilai pada atribut "jabatan"
//	public void setJabatan() {
	public void setJabatan(String j) {
		this.jabatan = j;
	}
}
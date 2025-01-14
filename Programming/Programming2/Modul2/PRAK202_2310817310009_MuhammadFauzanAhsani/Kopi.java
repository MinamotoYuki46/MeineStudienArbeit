package PRAK202_2310817310009_MuhammadFauzanAhsani;

public class Kopi {
    private String pembeli;
    private final double rasioPajak = 0.11;
    String namaKopi;
    String ukuran;
    double harga;

    public void setPembeli(String nama){
        this.pembeli = nama;
    }

    public String getPembeli(){
        return this.pembeli;
    }

    public double getPajak(){
        return this.harga * this.rasioPajak;
    }

    public void info(){
        System.out.printf("Nama Kopi: %s\n", this.namaKopi);
        System.out.printf("Ukuran: %s\n", this.ukuran);
        System.out.printf("Harga: Rp. %.1f\n", this.harga);
    }
}

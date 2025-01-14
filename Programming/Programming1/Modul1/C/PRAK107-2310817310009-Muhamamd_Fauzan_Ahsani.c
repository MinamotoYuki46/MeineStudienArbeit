#include <stdio.h>

void main(){
    int a = 4;
    int b = 5;
    int c = 7;
    int price = 85000;
    printf("Diketahui : \nPanjang sisi segitiga berturut-turut adalah %d, %d, dan %d\n", a, b,c );
    printf("Keliling Tanah Pak Dengklek adalah %d\n",  a + b + c );
    printf("Harga tanah Per Meter adalah  %d\n", price );
    printf("Jawaban : \nBiaya yang diperlukan Pak Dengklek adalah : Rp %d", (a + b +c)*price);
}
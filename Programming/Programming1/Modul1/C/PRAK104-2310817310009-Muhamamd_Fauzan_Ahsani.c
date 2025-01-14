#include <stdio.h>

void main(){
    double a = 400000;
    double b = 350000;

    printf("Harga sepatu A adalah %.0f\n", a);
    printf("Harga sepatu b adalah %.0f\n", b);
    printf("Sepatu A mendapat diskon 13%% sehingga harganya menjadi %.0f\n", a * (1 - .13));
    printf("Sepatu B mendapat diskon 21%% sehingga harganya menjadi %.0f\n", b * (1 - .21));
}
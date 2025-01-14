#include <stdio.h>

int main(){
    int selector;
    double val1, val2;

    while(1){
    printf("Pilih program\n1. Penjumlahan\n2. Pengurangan\n3. Perkalian\n4. Pembagian\n5. Exit\nMasukkan Pilihan : ");
    scanf("%d", &selector);

    if(selector < 5){
        printf("Masukkan nilai pertama : ");
        scanf("%lf",&val1);
        printf("Masukkan nilai kedua : ");
        scanf("%lf", &val2);
        if(selector == 1){
            printf("Hasil penjumlahan antata %.2lf dengan %.2lf adalah %.2lf\n", val1, val2, val1 + val2);
        }
        else if (selector == 2){
            printf("Hasil pengurangan antata %.2lf dengan %.2lf adalah %.2lf\n", val1, val2, val1 - val2);
        }
        else if (selector == 3){
            printf("Hasil perkalian antata %.2lf dengan %.2lf adalah %.2lf\n", val1, val2, val1 * val2);
        }
        else if (selector == 4){
            printf("Hasil pembagian antata %.2lf dengan %.2lf adalah %.2lf\n", val1, val2, val1 / val2);
        }
    }
    else if (selector == 5){
        printf("Terimakasih, telah menggunakan kalkulator Muhammad Fauzan Ahsani");
        break;
    }
    else {
        printf("Input anda salah, silahkan coba lagi\n");
    }
    }
    return 0;
}

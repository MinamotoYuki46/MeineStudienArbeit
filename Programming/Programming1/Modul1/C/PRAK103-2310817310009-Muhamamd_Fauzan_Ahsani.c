#include <stdio.h>

void main(){
    double a = 9;
    double b = 6;
    double x = 10;
    double y = 7;
    printf("Variabel a bernilai %.0f\n", a);
    printf("Variabel b bernilai %.0f\n", b);
    printf("Variabel x bernilai %.0f\n", x);
    printf("Variabel y bernilai %.0f\n", y);

    printf("Hasil dari a ditambah b dikali x dan dibagi y adalah %.2f", (a+b) *x/y);
}
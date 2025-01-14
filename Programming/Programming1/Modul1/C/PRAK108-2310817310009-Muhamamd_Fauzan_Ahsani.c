#include <stdio.h>

void main(){
    double turn = 5;
    double distance = 14000;
    
    printf("Diketahui : \nPak Dengklek mengelilingi taman = %.0f putaran \n", turn);
    printf("Jarak tempuh Pak Dengklek = %.0f Kilometer \n \n", distance / 1000);
    printf("Jawaban : \nJari-jari taman yang dikelilingi Pak Dengklek adalah %.2f Kilometer", (distance/turn) / (2 *3.14) / 1000 );
}
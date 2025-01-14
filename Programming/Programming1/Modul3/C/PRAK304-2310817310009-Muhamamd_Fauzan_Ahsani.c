#include <stdio.h>

int main(){
    int nilai;
    scanf("%d", &nilai);

    if(nilai>=100){
        printf("Anda Menginput Melebihi Limit Bilangan");
    }
    else if(nilai < 10 && nilai > 0){
        printf("Satuan");
    }
    else if(nilai >= 11 && nilai <= 19){
        printf("Belasan");
    }
    else if(nilai == 10 || nilai >= 20 && nilai <= 99){
        printf("Puluhan");
    }
    else if (nilai == 0){
        printf("Nol");
    }
    return 0;
}
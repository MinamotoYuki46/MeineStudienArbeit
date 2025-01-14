#include <stdio.h>

void Biodata(int birthYear, char name[], char dom[]){
    int tahun_sekarang = 2020;
    printf("Perkenalkan Nama Saya : %s\n", name);
    printf("Umur saya : %d\n", tahun_sekarang - birthYear);
    printf("Saya Adalah Angkatan : %d\n", tahun_sekarang);
    printf("Asal Saya dari : %s", dom);
}

int main(){
    int tahunLahir;
    char Namaku[20], Asal[15];

    scanf("%d\n", &tahunLahir);
    scanf("%[^\n]%*c", &Namaku);
    scanf("%[^\n]%*c", &Asal);

    Biodata(tahunLahir, Namaku, Asal);
    return 0;
}
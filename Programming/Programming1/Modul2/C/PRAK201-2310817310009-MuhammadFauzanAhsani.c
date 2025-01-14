#include <stdio.h>

void main(){
    char nama[20], NIM[15], paralel[5], TTL[100], alamat[200], hobi[200], no_hp[15];
    printf("Nama                 : ");
    gets(nama);
    printf("NIM                  : ");
    gets(NIM);
    printf("Kelas paralel        : ");
    gets(paralel);
    printf("Tempat/Tanggal Lahir : ");
    gets(TTL);
    printf("Alamat               : ");
    gets(alamat);
    printf("Hobby                : ");
    gets(hobi);
    printf("No. HP               : ");
    gets(no_hp);   

    printf("\nNama                 : %s", nama);
    printf("\nNIM                  : %s", NIM);
    printf("\nKelas Paralel        : %s", paralel);
    printf("\nTempat/Tanggal Lahir : %s", TTL);
    printf("\nAlamat               : %s", alamat);
    printf("\nHobby                : %s", hobi);
    printf("\nNo. HP               : %s", no_hp);
}
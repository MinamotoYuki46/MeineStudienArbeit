#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include <iostream>

using namespace std;

int random(int bil){
    int jumlah = rand() % bil;
    return jumlah;
}

void randomize(){
    srand(time(NULL));
}

void clrscr(){
    system("cls");
}

int main(){
    clrscr();
    int data[100];
    int cari = 20;
    int counter = 0;
    int flag = 0;
    int save;
    randomize();

    cout << "generating 100 number . . ." << endl;

    for(int i = 0; i < 100; i++){
        data[i] = random(100) + 1;
        cout << i << ':' << data[i] << ' ';
    }
    cout << endl << "done." << endl;

    for(int i = 0; i < 100; i++){
        if(data[i] == cari){
            counter++;
            flag = 1;
            save = i;
        }
    }

    if (flag == 1){
        cout << "Data ada,sebanyak " << counter << "!" << endl;
        cout << "pada indeks ke-" << save;
    }
    else{
        cout << "Data tidak ada!" << endl;
    }
    return 0;
}
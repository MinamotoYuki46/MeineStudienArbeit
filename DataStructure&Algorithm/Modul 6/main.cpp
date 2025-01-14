#include <bits/stdc++.h>
#include <conio.h>
using namespace std;

void binarySearching(){
    int n, kiri, kanan, tengah, temp, key;
    bool ketemu = false;

    cout << "Masukkan jumlah data ";
    cin >> n;
    int angka[n];

    for(int i = 0; i < n; i++){
        for(int j = 0; j < n - 1 ; j++){
            if (angka[j] > angka[j + 1]){
                temp = angka[j];
                angka[j] = angka[j + 1];
                angka[j + 1] = temp;
            }
        }
    }

    cout << "==================================" << endl;
    cout << "Data yang telah diurutkan adalah:" << endl;

    for(int i = 0; i < n; i++){
        cout << angka[i] << " ";
    }

    cout << endl << "=========================================" << endl;
    cout << "Masukkan angka yang dicari: ";
    cin >> key;

    kiri = 0;
    kanan = n - 1;

    while(kiri < kanan){
        tengah = (kiri + kanan) / 2;
        if (key == angka[tengah]){
            ketemu = true;
            break;
        }
        else if (key < angka[tengah]){
            kanan = tengah - 1;
        }
        else {
            kiri = tengah + 1;
        }
    }

    if(ketemu == true){
        cout << "Angka ditemukan!";
    }
    else{
        cout << "Angka tidak ditemukan";
    }
}

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

void seqeuntialSearching(){
    int data[100];
    int cari;
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

    cout << "Angka yang ingin di cari: ";
    cin >> cari;

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
}

void explain(){
    const int colWidth1 = 20;
    const int colWidth2 = 30;
    const int colWidth3 = 30;

    cout << "Sequential search atau linear search melakukan operasinya dengan cara men-traverse semua elemen dari indeks awal sampai akhir dan membandingkannya dengan target nilai yang akan dicari. Sedangkan binary search merupakan metode rekursif dengan melakukan operasinya dengan cara membandingkan nilai target dengan indeks tengah elemennya. Jika belum ditemukan, list atau array akan dibagi menjadi dua bagian, kiri dan kanan. Jika nilai target lebih kecil dari nilai elemen tengah, binary search akan dilakukan (lagi) pada list bagian kiri. Jika nilai target lebih besar dari nilai elemen tengah, binary search akan dilakukan (lagi) pada list bagian kanan. Proses ini akan terus berulang sampai nilai target telah ditemukan atau list sudah habis dibagi." << endl;

    cout << left << setw(colWidth1) << "Perbandingan"
        << setw(colWidth2) << "Sequential Search"
        << setw(colWidth3) << "Binary Search" << endl;

    cout << setw(colWidth1) << setfill('-') << ""
         << setw(colWidth2) << ""
         << setw(colWidth3) << "" << setfill(' ') << endl;

    cout << left << setw(colWidth1) << "Kompleksitas Waktu"
         << setw(colWidth2) << "O(n) worst, O(1) best [-]"
         << setw(colWidth3) << "O(log(n)) worst, O(1) best [+]" << endl;

    cout << left << setw(colWidth1) << "Bentuk data"
         << setw(colWidth2) << "Bebas [+]"
         << setw(colWidth3) << "Harus terurut" << endl;

    cout << left << setw(colWidth1) << "Efisiensi"
         << setw(colWidth2) << "Untuk data kecil"
         << setw(colWidth3) << "Untuk data besar [+]" << endl;

    cout << left << setw(colWidth1) << "Implementasi"
         << setw(colWidth2) << "Semua jenis struktur data"
         << setw(colWidth3) << "Hanya untuk struktur data yang memiliki dua arah gerak" << endl;
}

int main(){
    int opt;
    do{
        cout << "Pilih menu" << endl;
        cout << "1. Sequential Searching" << endl;
        cout << "2. Binary Searching" << endl;
        cout << "3. Jelaskan Perbedaan Sequantial Searching dan Binary Searching!" << endl;
        cout << "4. Exit" << endl;
        cout << "Pilih: ";
        cin >> opt;

        switch(opt){
            case 1:
                seqeuntialSearching();
                break;
            case 2:
                binarySearching();
                break;
            case 3:
                explain();
                break;
            default:
            cout << "\nTERIMA KASIH" << endl;
            cout << "Programme was made by Muhammad Fauzan Ahsani (2310817310009)" << endl;  
        }
        cout << "\nPress any key to continue!" << endl;
        getch();
        system("cls");
    }
    while(opt < 4);

    return 0;
}
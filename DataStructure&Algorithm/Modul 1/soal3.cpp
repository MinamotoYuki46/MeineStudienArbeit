#include<iostream>
#include <string>
using namespace std;

struct mindreader{
    string letter, word, number;
};

int main(){
    mindreader guess;
    cout << "Masukkan sebuah huruf = "; cin >> guess.letter;
    cout << "Masukkan sebuah kata = " ; cin >> guess.word;
    cout << "Masukkan Angka = "; cin >> guess.number;

    cout << "Huruf yang Anda masukkan adalah " << guess.letter << endl;
    cout << "Kata yang Anda masukkan adalah " << guess.word << endl;
    cout << "Angka yang Anda masukkan adalah " << guess.number << endl;

    return 0;
}
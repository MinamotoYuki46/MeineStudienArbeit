#include<iostream>
#include<conio.h>
#include<stdlib.h>

#define max 20

using namespace std;

struct stack{
    int atas , data[max];
};

stack Tumpuk;

void inisialisasi(){
    Tumpuk.atas = -1;
}

int kosong(){
    if(Tumpuk.atas == -1){
        return 1;
    }
    else{
        return 0;
    }
}

int penuh(){
    if(Tumpuk.atas == max -1){
        return 1;
    }
    else{
        return 0;
    }
}

void input(int val){
    if(penuh()==0){
        Tumpuk.atas++;
        Tumpuk.data[Tumpuk.atas] = val;
        cout << "Data " << Tumpuk.data[Tumpuk.atas] << " Masuk ke Stack. " << endl;
    }
    else{
        cout << "Tumpukan Penuh. " << endl;
    }

}

void hapus(){
    if(kosong()==0){
        cout << Tumpuk.data[Tumpuk.atas] << endl;
        cout << "Data Teratas Sudah Terambil. " << endl;
        Tumpuk.atas--;
    }
    else{
        cout << "Data Kosong. " << endl;
    }
}

void tampil(){
    if(kosong()==0){
        for(int i = Tumpuk.atas; i >= 0; i--){
            cout << "\nTumpukan Ke " << i << " = " << Tumpuk.data[i];
        }
        cout << endl;
    }
    else{
        cout << "Tumpukan Kosong. "<< endl;
    }
}

void bersih(){
    Tumpuk.atas = -1;
    cout << "Tumpukan Kosong! "<< endl;
}

char selection[1];
int opt;

int main(){
    inisialisasi();
    do{
        cout << "STACK" << endl;
        cout << "====================" << endl;
        cout << "1. PUSH" << endl;
        cout << "2. POP" << endl;
        cout << "3. PRINT STACK" << endl;
        cout << "4. CLEAR STACK" << endl;
        cout << "5. QUIT" << endl;
        cout << "SELECT : "; cin >> selection;
        opt = atoi(selection);

        switch(opt){
            case 1:
                int x;
                cout << "INSERT VALUE : "; cin >> x;
                input(x);
                break;
            case 2:
                hapus();
                break;
            case 3:
                tampil();
                break;
            case 4:
                bersih();
                break;
            default:
                cout << "THANK YOU" << endl;
                break;
        }
        cout << "press any key to continue" << endl;
        getch();
        system("cls");
    }
    while(opt < 5);
}

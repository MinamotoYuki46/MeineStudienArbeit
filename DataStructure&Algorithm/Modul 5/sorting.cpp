#include <bits/stdc++.h>
#include <conio.h>
using namespace std;

int menu;

void merge(string& str, int left, int mid, int right){
    int lSize = mid - left + 1;
    int rSize = right - mid;

    char *lSide = new char[lSize], *rSide = new char[rSize];

    for(int i = 0; i < lSize; i++){
        lSide[i] = str[left + i];
    }
    for(int j = 0; j < rSize; j++){
        rSide[j] = str[mid + j + 1];
    }

    int l = 0, r = 0, k = left;

    while(l < lSize && r < rSize){
        if (lSide[l] <= rSide[r]){
            str[k] = lSide[l];
            l++;
        }
        else{
            str[k] = rSide[r];
            r++;
        }
        k++;
    }

    while(l < lSize){
        str[k] = lSide[l];
        l++;
        k++;
    }

    while(r < rSize){
        str[k] = rSide[r];
        r++;
        k++;
    }
    delete lSide, rSide;
};

void insertionSort(string& str){
    char sorted;
    int i, j;

    for(i = 1; i < str.size(); i++){
        sorted = str[i];
        j = i - 1;
        
        while(sorted < str[j] && j >= 0){
            str[j + 1] = str[j];
            j--;
        }
        str[j + 1] = sorted;
    }
};

void mergeSort(string& str, int begin, int end){
    if (begin >= end){
        return;
    }

    int mid = begin + (end - begin) / 2;
    mergeSort(str, begin, mid);
    mergeSort(str, mid + 1, end);
    merge(str, begin, mid, end);
};

int partition(string& str, int begin, int end){
    char pivot = str[end];
    int i = begin - 1;

    for(int j = begin; j < end; j++){
        if(str[j] <= pivot){
            i++;
            swap(str[i], str[j]);
        }
    }
    swap(str[i + 1], str[end]);
    return i + 1;
};

void shellSort(string& str){
    for(int gap = str.size() / 2; gap > 0; gap /= 2){
        for(int i = gap; i < str.size(); i++){
            char temp = str[i];
            int j;

            for(j = i; j >= gap && str[j - gap] > temp; j -= gap){
                str[j] = str[j - gap];
            }
            str[j] = temp;
        }
    }
};

void quickSort(string& str, int begin, int end){
    if (begin < end){
        int piv = partition(str, begin, end);
        quickSort(str, begin, piv - 1);
        quickSort(str, piv + 1, end);
    }
};

void bubbleSort(string& str){
    bool swapped;
    do{
        swapped = false;
        for(int i = 1; i < str.size();i++){
            if(str[i-1] > str[i]){
                swap(str[i-1], str[i]);
                swapped = true;
            }
        }
    }
    while(swapped);
};

void selectionSort(string& str){
    int high;
    for(int i = 0;i < str.size() - 1; i++){
        high = i;
        for(int j = i + 1; j < str.size(); j++){
            if (str[high] > str[j]){
                high = j;
            }
        }
        swap(str[i], str[high]);
    }
};

int main(){
    string nama, nim;
    do{
        cout << "----------------------" << endl;
        cout << "|-------SORTING-------|" << endl;
        cout << "----------------------" << endl;
        cout << "1. Insertion Sort" << endl;
        cout << "2. Merge Sort" << endl;
        cout << "3. Shell Sort" << endl;
        cout << "4. Quick Sort" << endl;
        cout << "5. Bubble Sort" << endl;
        cout << "6. Selection Sort" << endl;
        cout << "7. Exit" << endl;
        cout << "---------------------" << endl;
        cout << "Masukkan Pilihan: ";
        cin >> menu;

        switch(menu){
            case 1:
                cout << "Masukkan nama: " ;
                cin >> nama;
                insertionSort(nama);
                cout << nama;
                break;
            case 2:
                cout << "Masukkan nama: " ;
                cin >> nama;
                mergeSort(nama, 0, nama.size() -1);
                cout << nama;
                break;
            case 3:
                cout << "Masukkan nama: " ;
                cin >> nama;
                shellSort(nama);
                cout << nama;
                break;
            case 4:
                cout << "Masukkan NIM: " ;
                cin >> nim;
                quickSort(nim, 0, nim.size() - 0);
                cout << nim;
                break;
            case 5:
                cout << "Masukkan NIM: " ;
                cin >> nim;
                bubbleSort(nim);
                cout << nim;
                break;
            case 6:
                cout << "Masukkan NIM: " ;
                cin >> nim;
                selectionSort(nim);
                cout << nim;
                break;
            default:
            cout << "\nTERIMA KASIH" << endl;
            cout << "Programme was made by Muhammad Fauzan Ahsani (2310817310009)" << endl;            
        }
        cout << "\nPress any key to continue!" << endl;
        getch();
        system("cls");
    }
    while(menu < 7);
    return 0;
}
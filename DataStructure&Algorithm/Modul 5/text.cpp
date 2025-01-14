#include <bits/stdc++.h>
using namespace std;

void cetak(string *str){
    cout << str << endl;
    cout << *str << endl;
}

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

void quickSort(string& str, int begin, int end){
    if (begin < end){
        int piv = partition(str, begin, end);
        quickSort(str, begin, piv - 1);
        quickSort(str, piv + 1, end);
    }
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

int main(){
    string tes, nama;
    //cin >> tes;
    //cetak(&tes);
    //cout << tes << endl;
    getline(cin, nama);
    mergeSort(nama, 0, nama.size() -1);
    cout << nama ;

    return 0;
}
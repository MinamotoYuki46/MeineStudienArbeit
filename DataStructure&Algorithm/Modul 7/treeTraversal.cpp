#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#include <iostream>

using namespace std;

struct node {
    int data;
    node *kiri, *kanan;
};

void tambah(node **root, int databaru){
    if (*root == NULL){
        node *baru;
        baru = new node;
        baru -> data = databaru;
        baru -> kiri = NULL;
        baru -> kanan = NULL;

        (*root) = baru;
        (*root) -> kiri = NULL;
        (*root) -> kanan = NULL;

        cout << "Data bertambah" ;
    }
    else if (databaru < (*root) -> data) tambah(&(*root) -> kiri, databaru);
    else if (databaru > (*root) -> data) tambah(&(*root) -> kanan, databaru);
    else if (databaru == (*root) -> data) cout << "Data sudah ada";
}

void preOrder(node *root){
    if (root != NULL){
        cout << root -> data << ' ';
        preOrder(root -> kiri);
        preOrder(root -> kanan);
    }
}

void inOrder(node *root){
    if (root != NULL){
        inOrder(root -> kiri);
        cout << root -> data << ' ';
        inOrder(root -> kanan);
    }
}

void postOrder(node *root){
    if (root != NULL){
        postOrder(root -> kiri);
        postOrder(root -> kanan);
        cout << root -> data << ' ';
    }
}

int main(){
    int pil, data;
    node *pohon = NULL;

    do{
        system("cls");
        cout << "1. Tambah" << endl;
        cout << "2. Preorder" << endl;
        cout << "3. Inorder" << endl;
        cout << "4. Postorder" << endl;
        cout << "5. Exit" << endl;
        cout << endl << "Pilihan : ";
        cin >> pil;

        switch(pil){
            case 1:
                cout << endl << "Input" << endl;
                cout << "---------" << endl;
                cout << "Data baru : ";
                cin >> data;
                tambah(&pohon, data);
                break;

            case 2:
                cout << endl << "Preorder" << endl;
                cout << "---------------" << endl;
                if (pohon != NULL) preOrder(pohon);
                else cout << "Masih kosong";
                break;
            
            case 3:
                cout << endl << "Inorder" << endl;
                cout << "---------------" << endl;
                if (pohon != NULL) inOrder(pohon);
                else cout << "Masih kosong";
                break;
            
            case 4:
                cout << endl << "Postorder" << endl;
                cout << "---------------" << endl;
                if (pohon != NULL) postOrder(pohon);
                else cout << "Masih kosong";
                break;
            
            case 5:
                return 0;
        }
        _getch();
    } while(pil != 5);
    return EXIT_FAILURE;
}
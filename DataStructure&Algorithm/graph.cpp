#include <bits/stdc++.h>
using namespace std;

typedef struct tipeS{
    struct tipeS *left, *right;
    int val;    
};

typedef struct tipeS node;

node *P, *first, *last, *PVertex, *PEdge, *Q, *R, *S;
node *PointS[5];

int main(){
    int A[5][5] = {
        0, 5, 0, 2, 0,
        6, 0, 3, 0, 0,
        0, 0, 0, 0, 9,
        0, 0, 12, 0, 7,
        0, 14, 0, 0, 0 
    };

    string NmS = "ABCDE";
    int i = 0, j = 0;

    P = new node;
    P -> val = NmS[0];
    first = P;
    last = P;
    P -> left = NULL;
    P -> right = NULL;

    PointS[0] = P;

    printf("%c", P -> val);
    printf(" alamat %d", PointS[0]);

    for(i = 1; i <= 4; i++){
        P = new node;
        P -> val = NmS[i];
        last -> left = P;
        last = last -> left;
        P -> left = NULL;
        P -> right = NULL;
        PointS[i] = P;
        printf("\n%c", P -> val);
        printf(" alamat %d ", PointS[i]);
    }
    cout << endl;
    Q = first;

    for(i = 0; i <= 4; i++){
        R = Q;
        printf("Vertex %c .... ", Q -> val);
        for(j = 0; j <= 4; j++){
            if (A[i][j] != 0){
                P = new node;
                P -> val = A[i][j];
                R -> right = P;
                P -> left = PointS[j];
                printf(" berhubungan dengan %c: ", P -> left -> val);
                printf("bobot %d", P -> val);
                P -> right = NULL;
                R = P;
            }
        }
        printf("\n");
        Q = Q -> left;
    }
    return 0;
}

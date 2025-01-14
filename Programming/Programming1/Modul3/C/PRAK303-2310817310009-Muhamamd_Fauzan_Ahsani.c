#include <stdio.h>

int main(){
    int nilai;
    scanf("%d", &nilai);

    if(nilai>0){
        printf("positif");
    }
    else if(nilai < 0){
        printf("negatif");
    }
    else{
        printf("nol");
    }
    return 0;
}
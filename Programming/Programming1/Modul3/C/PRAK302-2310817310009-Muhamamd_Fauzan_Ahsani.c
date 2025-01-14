#include <stdio.h>

int main(){
    int nilai;
    scanf("%d", &nilai);

    if(nilai>=80){
        printf("A");
    }
    else if(nilai <= 79 && nilai >=70){
        printf("B");
    }
    else if(nilai <= 69 && nilai >=60){
        printf("C");
    }
    else if(nilai <= 59 && nilai >=50){
        printf("D");
    }
    else if(nilai < 50){
        printf("E");
    }
    return 0;
}
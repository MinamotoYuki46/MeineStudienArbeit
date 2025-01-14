#include <stdio.h>

int main(){
    int val;

    scanf("%d", &val);

    for (int i = 1; i <= val; i++){
        if(i % 2 == 1){
            printf("%d ", i);
        }   
    }
    printf("\n");
    for (int j = val; j >= 1; j--){
        if(j % 2 == 0){
            printf("%d ", j);
        }
    }
    return 0;
}

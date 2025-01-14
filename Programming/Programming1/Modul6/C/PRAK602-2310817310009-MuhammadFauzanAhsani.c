#include <stdio.h>

int main(){
    int  column;
    scanf("%d",&column);
    int array[1][column];

    for (int i = 0; i < column ; i++){
        scanf("%d", &array[0][i]);
    }

    for (int i = 0; i < column ; i++){
            printf("%d ", array[0][i] * (i + 1));
    }
    return 0;
}
#include <stdio.h>

int main(){
    int column1, column2;
    scanf("%d %d", &column1, &column2);

    if (column1 != column2){
        printf("Jumlah tidak sama");
    }
    else{
        int arr1[1][column1], arr2[1][column2];

        for (int i = 0; i < column1 ; i++){
            scanf("%d", &arr1[0][i]);
        }
        
        for (int i = 0; i < column2 ; i++){
            scanf("%d", &arr2[0][i]);
        }

        for (int i = 0; i < column1 ; i++){
            printf("%d ", arr1[0][i] * arr2[0][i]);
        }
    }
    return 0;
}
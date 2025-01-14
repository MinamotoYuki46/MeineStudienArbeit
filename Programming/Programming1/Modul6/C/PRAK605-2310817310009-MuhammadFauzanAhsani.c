#include <stdio.h>

int main() {
    int arrA[101][101];
    int arrB[101][101];
    int arrC[101][101];

    int dimension;
    scanf("%d", &dimension);

    printf("Matriks A\n");
    for (int i = 1; i <= dimension; i++) {
        for (int j = 1; j <= dimension; j++) {
            scanf("%d", &arrA[i][j]);
        }
    }

    printf("Matriks B\n");
    for (int j = 1; j <= dimension; j++) {
        for (int k = 1; k <= dimension; k++) {
            scanf("%d", &arrB[j][k]);
        }
    }
    printf("Matriks AXB\n");
    for (int i = 1; i <= dimension; i++) {
        for (int k = 1; k <= dimension; k++) {
            int result = 0;
            for (int j = 1; j <= dimension; j++) {
                result = result + arrA[i][j] * arrB[j][k];
            }
            printf("%d ", result);
        }
        printf("\n");
    }

    return 0;
}
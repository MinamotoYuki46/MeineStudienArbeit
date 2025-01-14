#include <stdio.h>

int main(){
    int val1, val2;
    scanf("%d %d", &val1, &val2);

    for(int i = 1; i <= val1; i++){
        for(int j = 1; j <= i; j++){
            if (i == j){
                printf("(%d * %d) = ", i-j, val2);
            }
            else {
                printf("(%d * %d) + ", i-j, val2);
            }
        }
        printf("%d\n", (i * (i + 1) /2) * val2);
    }
    printf("%d", (val1 * (val1+1) * (val1+2)) * val2 / 6);
    return 0;    
}

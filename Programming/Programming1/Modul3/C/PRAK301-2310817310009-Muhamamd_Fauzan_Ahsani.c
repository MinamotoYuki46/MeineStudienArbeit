#include <stdio.h>

int main(){
    int num1, num2;
    scanf("%d %d", &num1, &num2);

    if (num1 > num2){
        printf("%d %d", num2, num1);
    }
    else if (num1 < num2){
        printf("%d %d", num1, num2);
    }
    return 0;
}
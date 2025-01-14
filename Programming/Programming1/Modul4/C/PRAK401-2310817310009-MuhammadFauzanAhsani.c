#include <stdio.h>

int main(){
    int val;
    char symbol;

    scanf("%d %c", &val, &symbol);

    for (int i = 1; i <= 50; i++){
        if (i % val == 0){
            printf("%c ", symbol);
        }
        else {
            printf("%d ", i);
        }
    }
    return 0;
}
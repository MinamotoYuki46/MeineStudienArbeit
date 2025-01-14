#include <stdio.h>
#include <math.h>

int main(){
    int val1, val2;

    scanf("%d %d", &val1, &val2);

    for (int i = 0; i < (abs(val2 - val1) + 1); i++){
        if (val1 < val2){
            if (i == (abs(val2 - val1))){
                printf("%d %d", val1 + i, val2 - i);
            }
            else {
                printf("%d %d - ", val1 + i, val2 - i);
            }
        }
        else if (val1 > val2){
            if (i == (abs(val2 - val1))){
                printf("%d %d", val1 - i, val2 + i);
            }
            else {
                printf("%d %d - ", val1 - i, val2 + i);
            }
        }
    }
    return 0;
}
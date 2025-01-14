#include <stdio.h>

int reverse(int x){ 
    int temp = x;
    int ret = 0;

    while (temp>0){
        ret = (ret* 10) + (temp % 10);
        temp /= 10;
    }
    return ret;}

int main(){
    int A, B;
    scanf("%d %d", &A, &B);
    A = reverse(A);
    B = reverse(B);
    int C = A + B;
    printf("%d", reverse(C));

    return 0;
}
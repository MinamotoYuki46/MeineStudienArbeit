#include <stdio.h>

void main(){
    float a, b, i, j, x, y; ;
    scanf("%f %f %f %f %f %f", &a, &b, &i, &j, &x, &y );
    printf("%.3f", (a - b) * i / j - (x + y));
}
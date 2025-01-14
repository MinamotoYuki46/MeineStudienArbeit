#include <stdio.h>

void main(){
    double radius, height, pi = 22.0 / 7.0;
    scanf("%lf %lf", &radius, &height);

    printf("Volume = %.2lf \n", radius*radius * pi * height);
    printf("Luas = %.2lf \n", 2 * ((pi * radius) * (radius + height)) );
    printf("Keliling = %.2lf \n", 2 * pi * radius );
}
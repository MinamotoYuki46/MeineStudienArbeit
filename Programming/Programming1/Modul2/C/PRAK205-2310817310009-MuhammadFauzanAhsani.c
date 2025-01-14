#include <stdio.h>
#include <math.h>

void main(){
    double a, b ;
    scanf("%lf %lf", &a, &b);
    double c = sqrt(pow(b, 2) - pow(a, 2));
    printf("Alas = %.0lf cm\n", c);
    printf("Tinggi = %.0lf cm\n", a );
    printf("Keliling = %.0lf cm\n", a + b + c );
    printf("Luas = %.0lf cm^2\n", .5 * c * a );
}
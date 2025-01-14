#include <stdio.h>
#include <math.h>

void main(){
    double base = 5;
    double height = 12;
    double hypotenuse = sqrt(base*base + height*height ); 
  
    printf("Diketahui : \nAlas = %.0f cm \nTinggi = %.0f cm \n \n", base, height);
    printf("Jawab : \nSisi A = %.0f cm\nSisi B = %.0f cm\nSisi C = %.0f cm\n", height, base, hypotenuse);
    printf("Keliling = %.0f cm\nLuas = %.0f cm", base + height + hypotenuse, .5 * base * height );
}
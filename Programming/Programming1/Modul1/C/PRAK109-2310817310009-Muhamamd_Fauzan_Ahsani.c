#include <stdio.h>

void main(){
    double YuZhongArmy = 958730;
    double heroes = 5;
  
    printf("Jumlah pasukan yang dibawa Yu Zhong = %.0f\n", YuZhongArmy);
    printf("Jumlah pahlawan = %.0f\n", heroes);
    printf("Jumlah pasukan yang harus dikalahkan setiap pahlawan adalah %.0f pasukan", YuZhongArmy/heroes );
}
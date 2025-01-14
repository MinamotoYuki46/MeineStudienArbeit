#include <stdio.h>
#include <math.h>

int main(){
    int sec, days, hours, minutes, seconds;
    scanf("%d", &sec);

    hours = floor(sec / 3600);
    minutes = floor(sec / 60);
    if (minutes >=60){
        minutes = minutes - floor(minutes / 60) * 60;
    }
    seconds = sec % 60;

    if (hours >= 24){
        days = floor(hours/24);
        hours = hours - days*24;
        printf("%d hari %02d:%02d:%02d", days, hours, minutes, seconds);
    }
    else {
        printf("%02d:%02d:%02d", hours, minutes, seconds);
    }
    return 0;
}
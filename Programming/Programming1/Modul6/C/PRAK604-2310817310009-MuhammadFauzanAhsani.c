#include <stdio.h>
#include <string.h>

int main(){
    char msg1[1001], msg2[1001];
    scanf("%[^\n]%*c %[^\n]%*c", &msg1, &msg2);
    char result[1001];
    int asterisk = 0, hash = 0;
    if (strlen(msg1) != strlen(msg2)){
        printf("Panjang kalimat berbeda, pesan palsu");
    }
    else{
        for (int i = 0 ; i < strlen(msg1); i++){
            if (msg1[i] == msg2[i]) {
                if (msg1[i] == ' '){
                    continue;
                }
                strcat(result, "*");  
                asterisk++;
                 
            } 
            else {
                strcat(result, "#");  
                hash++;
            }
        }
        printf("%s\n", result);
        printf("* = %d\n", asterisk);
        printf("# = %d\n", hash);
        
        if (asterisk >= hash){
            printf("Pesan Asli");
        }
        else{
            printf("Pesan Palsu");
        }
    }
    return 0;
}
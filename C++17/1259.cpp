// https://www.acmicpc.net/problem/1259
// First Written : 20201229
// Last Modified : 20201229

#include <cstdio>

int main(){
    int N, i;
    int save[5];
    bool is_pal;
    
    while(true) {
        scanf("%d", &N);

        if(N == 0)
            break;
        
        else{
            is_pal = true;
            for(i = 0; N != 0; i++){
                save[i] = N % 10;
                N /= 10;
            }

            for(int j = 0; j < i / 2; j++){
                if(save[j] != save[i - j - 1]){
                    is_pal = false;
                    break;    
                }
            }

            if(is_pal)
                printf("yes\n");
            else
                printf("no\n");
        }
    }

    return 0;
}
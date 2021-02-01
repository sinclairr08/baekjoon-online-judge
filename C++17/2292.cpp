// https://www.acmicpc.net/problem/2292
// First Written : 20210106
// Last Modified : 20210106

#include <cstdio>

int main(){
    int N;
    scanf("%d", &N);

    if(N == 1)
        printf("1");
    
    else{
        N--;
        int radius = 1;

        while(N > 0){
            N -= radius * 6;
            radius++;
        }

        printf("%d", radius);
    }


    return 0;
}
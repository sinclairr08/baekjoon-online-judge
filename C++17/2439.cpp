// https://www.acmicpc.net/problem/2439
// First Written : 20210106
// Last Modified : 20210106

#include <cstdio>

int main(){
    int N;
    scanf("%d", &N);

    for(int i = 0; i < N; i++){
        for(int j = N - 1; j > i; j--)
            printf(" ");
        
        for(int j = i; j >= 0; j--)
            printf("*");

        printf("\n");
    }

    return 0;
}
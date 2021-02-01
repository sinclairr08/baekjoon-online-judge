// https://www.acmicpc.net/problem/2438
// First Written : 20210106
// Last Modified : 20210106

#include <cstdio>

int main(){
    int N;
    scanf("%d", &N);

    for(int i = 0; i < N; i++){
        for(int j = 0; j <= i; j++)
            printf("*");
        printf("\n");
    }

    return 0;
}
// https://www.acmicpc.net/problem/2742
// First Written : 20210107
// Last Modified : 20210107

#include <cstdio>

int main(){
    int N;
    scanf("%d", &N);

    for(int i = 0; i < N; i++){
        printf("%d\n", N - i);
    }

    return 0;
}
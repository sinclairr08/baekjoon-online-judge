// https://www.acmicpc.net/problem/2739
// First Written : 20210107
// Last Modified : 20210107

#include <cstdio>

int main(){
    int N;
    scanf("%d", &N);

    for(int i = 1; i < 10; i++){
        printf("%d * %d = %d\n", N, i, N*i);
    }

    return 0;
}
// https://www.acmicpc.net/problem/10872
// First Written : 20210118
// Last Modified : 20210118

#include <cstdio>

int main(){
    int N;
    int result = 1;
    scanf("%d", &N);

    while(N)
        result *= (N--);

    printf("%d", result);

    return 0;
}
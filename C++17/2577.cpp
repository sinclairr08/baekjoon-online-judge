// https://www.acmicpc.net/problem/2577
// First Written : 20210107
// Last Modified : 20210107

#include <cstdio>

int main(){
    int A, B, C;
    scanf("%d %d %d", &A, &B, &C);

    int result = A * B * C;
    int answer[10] = {0};
    
    while(result != 0){
        answer[(result % 10)]++;
        result /= 10;
    }

    for(int i = 0; i < 10; i++)
        printf("%d\n", answer[i]);
    
    return 0;
}
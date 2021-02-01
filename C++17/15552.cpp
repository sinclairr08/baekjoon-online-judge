// https://www.acmicpc.net/problem/15552
// First Written : 20210120
// Last Modified : 20210120

#include <cstdio>

int main(){
    int Test_case;
    int A, B;
    scanf("%d", &Test_case);

    while (Test_case--){
        scanf("%d %d", &A, &B);
        printf("%d\n", A+B);
    }
    
    return 0;
}
// https://www.acmicpc.net/problem/10869
// First Written : 20210118
// Last Modified : 20210118

#include <cstdio>

int main(){
    int a, b;
    scanf("%d %d", &a, &b);
    printf("%d\n%d\n%d\n%d\n%d\n", a+b, a-b, a*b, a/b, a%b);

    return 0;
}
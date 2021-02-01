// https://www.acmicpc.net/problem/10817
// First Written : 20210118
// Last Modified : 20210118

#include <cstdio>

#define MAX(X, Y) (((X) > (Y)) ? (X) : (Y))
#define MIN(X, Y) (((X) > (Y)) ? (Y) : (X))

int main(){
    int a, b, c;
    scanf("%d %d %d", &a, &b, &c);
    printf("%d", a + b + c - MAX(MAX(a,b), c) - MIN(MIN(a,b), c));
    
    return 0;
}
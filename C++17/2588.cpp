// https://www.acmicpc.net/problem/2588
// First Written : 20210107
// Last Modified : 20210107

#include <cstdio>

int main(){
    int a, b, copied_b, digit;

    scanf("%d %d", &a, &b);
    copied_b = b;

    while (copied_b != 0){
        digit = copied_b % 10;
        printf("%d\n", a * digit);

        copied_b /= 10;
    }

    printf("%d\n", a * b);
    
    


    return 0;
}
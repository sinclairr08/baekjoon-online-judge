// https://www.acmicpc.net/problem/1629
// First Written : 20210101
// Last Modified : 20210101

#include <cstdio>

long long exponent(long long base, long long exp, long long div){
    if(exp == 0)
        return 1;
    else if(exp == 1){
        base %= div;
        return base;
    }
    else{
        long long old_base = base;
        base = exponent(base, exp / 2, div);

        if(exp % 2 == 0){
            base *= base;
        }
        else{
            base = (base * base) % div;
            base *= old_base;
        }

        base %= div;
        return base;
    }
        
}

int main(){
    long long base, exp, div;
    long long result = 1;
    scanf("%lld %lld %lld", &base, &exp, &div);

    printf("%lld", exponent(base, exp, div));

    return 0;
}
// https://www.acmicpc.net/problem/18222
// First Written : 20210129
// Last Modified : 20210129

#include <cstdio>
#include <cmath>

long long find_complement(long long idx){
    long long floor_log = (long long)ceil(log2((double)idx));
    long long closest = (long long)pow(2, floor_log - 1);

    return idx - closest;
}

int main(){
    long long N;
    scanf("%lld", &N);
    bool is_reversed = false;

    while(N != 1){
        N = find_complement(N);
        is_reversed = !is_reversed;
    }

    if(is_reversed)
        printf("1");
    else
        printf("0");
    return 0;
}
// https://www.acmicpc.net/problem/11444
// First Written : 20210119
// Last Modified : 20210119

#include <cstdio>
#include <utility>
#define DIVIDER 1000000007

using namespace std;


pair<long long, long long> fibo_pair(long long odd_n, long long even_n){
    if(odd_n == 1)
        return pair<long long, long long>(1, 1);

    long long half_n = even_n / 2;
    bool is_half_odd = false;

    if(half_n % 2 == 1){
        half_n++;
        is_half_odd = true;
    }

    pair<long long, long long> half_result = fibo_pair(half_n-1, half_n);
    if(is_half_odd){
        long long temp = half_result.second - half_result.first;
        half_result.second = half_result.first;
        half_result.first = temp;
    }

    long long res_odd, res_even;

    res_odd = half_result.second * half_result.second + 
              half_result.first * half_result.first;
    res_odd %= DIVIDER;
    if(res_odd < 0)
        res_odd += DIVIDER;

    res_even = half_result.second * half_result.second + 
               2 * half_result.second * half_result.first;
    res_even %= DIVIDER;
    if(res_even < 0)
        res_even += DIVIDER;


    return pair<long long, long long>(res_odd, res_even);

}

int main(){
    long long N;
    long long result;
    scanf("%lld", &N);

    if(N == 0)
        result = 0;
    
    else if(N % 2 == 1)
        result = fibo_pair(N, N+1).first;

    else
        result = fibo_pair(N-1, N).second;

    printf("%lld\n", result);
    

    return 0;
}
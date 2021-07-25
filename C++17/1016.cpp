// https://www.acmicpc.net/problem/1016
// 20201217

#include <cstdio>
#include <cmath>
#include <vector>

using namespace std;

int main(){
    long long min, max, multiple_sq;

    scanf("%lld %lld", &min, &max);

    int N = max - min + 1;
    int sqrt_max = (int)(ceil(sqrt(max)));

    /* If a[i] is true, then i is prime */
    vector<bool> is_prime(sqrt_max + 1, true);

    /* If a[i] is true, then "min + i" is not divided by any square number */
    vector<bool> is_sqprime(N, true);

    /* The vector that stores the squares of the primes under max */
    vector<long long> primes_sq;

    int multiple;

    for(int i = 2; i <= sqrt_max; i++){
        if(is_prime[i]){
            multiple = i + i;
            while(multiple <= sqrt_max){
                is_prime[multiple] = false;
                multiple += i;
            }

        }
    }

    for(int i = 2; i <= sqrt_max; i++){
        if(is_prime[i]){
            primes_sq.push_back((long long)i * (long long)i);
        }
    }
    
    
    for(auto& prime_sq :primes_sq){
        multiple_sq = (long long)(ceil(((double)min) / ((double)prime_sq))) * prime_sq;

        while(multiple_sq <= max){
            is_sqprime[multiple_sq - min] = false;
            multiple_sq += prime_sq;
        }

    }

    int cnt = 0;    
    for(auto iter = is_sqprime.begin(); iter != is_sqprime.end(); iter++){
        if(*iter)
            cnt++;
    }

    printf("%d\n", cnt);

    return 0;
}
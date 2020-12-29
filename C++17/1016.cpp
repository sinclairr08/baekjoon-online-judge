// https://www.acmicpc.net/problem/1016
// 20201217

#include <cstdio>
#include <cmath>
#include <vector>

using namespace std;

void add_primes(vector<long long> &primes, long long upper_bdd){
    primes.push_back(4);
    bool is_prime;

    for(long long candidate = 3; candidate < upper_bdd + 1; candidate += 2){
        is_prime = true;

        for(long long divider = 2; divider < ceil(sqrt(candidate)) + 1; divider++){
            if(candidate % divider == 0){
                is_prime = false;
                break;
            }
        }

        if(is_prime){
            primes.push_back(candidate * candidate);
        }
    }

    return;
}
 

int main(){
    long long min, max, erat_num;
    int N, cnt = 0;
    scanf("%lld %lld", &min, &max);

    N = max - min + 1;

    vector<bool> is_sqprimes(N, true);
    vector<long long> primes_sq;
    
    add_primes(primes_sq, (long long)(ceil(sqrt(max))));
    
    for(auto& prime_sq :primes_sq){
        erat_num = (long long)(ceil(((double)min) / ((double)prime_sq))) * prime_sq;

        while(erat_num <= max){
            is_sqprimes[erat_num - min] = false;
            erat_num += prime_sq;
        }

    }
    
    for(auto iter = is_sqprimes.begin(); iter != is_sqprimes.end(); iter++){
        if(*iter)
            cnt++;
    }
   

    printf("%d\n", cnt);

    return 0;
}
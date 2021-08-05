// https://www.acmicpc.net/problem/1978
// First Written : 20210716
// Last Modified : 20210716

#include <cstdio>
#include <vector>
#include <cmath>

void find_primes(std::vector<int> &primes, int max_num){
    bool is_prime;
    int divider, divider_max, idx;
    primes.push_back(2);
    
    for(int candidate = 3; candidate <= max_num; candidate += 2){
        is_prime = true;
        idx = 0;
        divider = primes[idx++];
        divider_max = ceil(sqrt(candidate));

        while(divider <= divider_max){
            if(candidate % divider == 0){
                is_prime = false;
                break;
            }
            
            if(idx == primes.size())
                break;
            
            divider = primes[idx++];
        }
        
        if(is_prime)
            primes.push_back(candidate);
    }

    return;
}

int main(){
    int min_num, max_num;
    std::vector<int> primes;
    
    scanf("%d %d", &min_num, &max_num);
    find_primes(primes, max_num);
    
    for(auto it:primes){
        if(it >= min_num)
            printf("%d\n", it);
    }

    return 0;
}
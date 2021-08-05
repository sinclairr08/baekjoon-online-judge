// https://www.acmicpc.net/problem/1978
// First Written : 20210716
// Last Modified : 20210716

#include <cstdio>
#include <vector>
#include <cmath>

void find_primes(std::vector<int> &primes, int min_num, int max_num){
    bool is_prime;

    if(min_num <= 2){
        primes.push_back(2);
        min_num = 3;
    }

    else if(min_num % 2 == 0){
        min_num++;
    }
    
    for(int candidate = min_num; candidate <= max_num; candidate += 2){
        is_prime = true;
        for(int divider = 2; divider < (int)(ceil(sqrt(candidate))) + 1; divider++){
            if(candidate % divider == 0){
                is_prime = false;
                break;
            }
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
    find_primes(primes, min_num, max_num);
    
    for(auto it:primes){
        printf("%d\n", it);
    }

    return 0;
}
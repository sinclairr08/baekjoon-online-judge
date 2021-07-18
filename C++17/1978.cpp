// https://www.acmicpc.net/problem/1978
// First Written : 20210104
// Last Modified : 20210716

#include <cstdio>
#include <vector>
#include <cmath>

#define MAX_INPUT 1000

using namespace std;

int main(){
    int N;
    int input;
    int cnt = 0;
    bool is_prime;
    vector<int> primes;
    
    scanf("%d", &N);
    primes.push_back(2);
    
    for(int candidate = 3; candidate < MAX_INPUT; candidate += 2){
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


    while(N--){
        scanf("%d", &input);
        is_prime = false;
        
        for(auto it:primes){
            if(input == it){
                is_prime = true;
                break;
            }
        }

        if(is_prime)
            cnt++;
    }

    printf("%d", cnt);

    return 0;
}
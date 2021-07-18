// https://www.acmicpc.net/problem/1929
// First Written : 20210716
// Last Modified : 20210716

#include <cstdio>
#include <vector>

int main(){
    int min_num, max_num;
    int multiple;
    
    scanf("%d %d", &min_num, &max_num);
    
    bool is_prime[max_num + 1] = {false};

    for(int i = 2; i <= max_num; i++){
        is_prime[i] = true;
    }

    for(int i = 2; i <= max_num; i++){
        if(is_prime[i]){
            multiple = i + i;
            while(multiple <= max_num){
                is_prime[multiple] = false;
                multiple += i;
            }

        }
    }

    for(int i = min_num; i <= max_num; i++){
        if(is_prime[i])
            printf("%d\n", i);
    }

    

    return 0;
}
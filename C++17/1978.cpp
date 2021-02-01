// https://www.acmicpc.net/problem/1978
// First Written : 20210104
// Last Modified : 20210104

#include <cstdio>
#include <vector>
#include <cmath>

#define MAX_INPUT 1000

using namespace std;



int main(){
    int N;
    int input;
    int cnt = 0;
    bool flag;
    vector<int> primes;
    
    scanf("%d", &N);
    primes.push_back(2);
    
    for(int i = 3; i < MAX_INPUT; i+= 2){
        flag = true;
        for(int div = 2; div < (int)(ceil(sqrt(i))) + 1; div++){
            if(i % div == 0){
                flag = false;
                break;
            }
        }
        if(flag)
            primes.push_back(i);
    }


    while(N--){
        scanf("%d", &input);
        flag = false;
        
        for(auto it:primes){
            if(input == it){
                flag = true;
                break;
            }
        }

        if(flag)
            cnt++;
 
    }
    printf("%d", cnt);
    

    return 0;
}
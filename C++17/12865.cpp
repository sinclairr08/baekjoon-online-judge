// https://www.acmicpc.net/problem/12865
// First Written : 20210120
// Last Modified : 20210120

#include <cstdio>
#define  MAX(X,Y) (((X) > (Y)) ? (X) : (Y))

int main(){
    int N, max_load;
    int cur_weight, cur_value;
    scanf("%d %d", &N, &max_load);

    int weights[N+1] = {0};
    int values[N+1] = {0};

    int dp[N + 1][max_load + 1];

    for(int i = 1; i <= N; i++){
        scanf("%d %d", &weights[i], &values[i]);
    }


    for(int idx = 0; idx <= N; idx++){
        cur_weight = weights[idx];
        cur_value = values[idx];

        for(int load = 0; load <= max_load; load++){
            if(idx == 0 || load == 0){
                dp[idx][load] = 0;
                continue;
            }
            
            else if(cur_weight > load){
                dp[idx][load] = dp[idx-1][load];
            }
            else{
                dp[idx][load] = MAX(
                    dp[idx-1][load],
                    dp[idx-1][load-cur_weight] + cur_value);
            }
        }
    }
    
    printf("%d", dp[N][max_load]);
    return 0;
}
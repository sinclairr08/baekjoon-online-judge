// https://www.acmicpc.net/problem/2098
// First Written : 20210106
// Last Modified : 20210106

#include <cstdio>

#define MIN(X,Y) (((X) < (Y)) ? (X) : (Y))
#define MAX_VAL 1999999999

int power_2(int exp){
    int base = 1;
    for(int i = 0; i < exp; i++)
        base *= 2;
    return base;
}

int TSP(int cur_city, int visited, int** weight, int** dp, const int N){
    visited += power_2(cur_city);

    if(visited == power_2(N) - 1){
        if(weight[cur_city][0] == 0)
            return MAX_VAL;
        
        else
            return weight[cur_city][0];
        
    }

    if(dp[cur_city][visited] != 0)
        return dp[cur_city][visited];


    int min_weight = MAX_VAL;
    int cur_weight;
    int copied_visited = visited;

    for(int city = 0; city < N; city++){
        if((copied_visited % 2 == 0) && (weight[cur_city][city] != 0)){
            cur_weight = TSP(city, visited, weight, dp, N) + weight[cur_city][city];
            min_weight = MIN(cur_weight, min_weight);
        }
            
        copied_visited /= 2;
    }

    dp[cur_city][visited] = min_weight;
    return min_weight;
    
}

int main(){
    int N;
    scanf("%d", &N);

    int** weight = new int*[N];
    int** dp = new int*[N];

    for(int i = 0; i < N; i++){
        weight[i] = new int[N];
        dp[i] = new int[power_2(N)]();
    }

    for(int i = 0; i < N; i++)
        for(int j = 0; j < N; j++)
            scanf("%d", &weight[i][j]);

    printf("%d", TSP(0, 0, weight, dp, N));
    
    for(int i = 0; i < N; i++)
        delete [] dp[i], weight[i];

    delete [] dp, weight;

    return 0;
}
// https://www.acmicpc.net/problem/1007
// 20201130

#include <stdio.h>
#include <limits>
#include <cmath>

int sum_arr(int* arr, int N);
long long combination(int ** grid, long long total_x, long long total_y, int* minus_arr, int index, const int N, long long optimal);

int main(){
    int T;
    scanf("%d", &T);

    for(int i = 0; i < T; i++){
        int N;
        long long total_x = 0, total_y = 0;
        long long optimal = __LONG_LONG_MAX__;
        scanf("%d", &N);

        int** grid = new int*[N];
        int* minus_arr = new int[N];
        for(int j = 0; j < N; j++){
            grid[j] = new int[2];
            scanf("%d %d", &grid[j][0], &grid[j][1]);
            total_x += grid[j][0];
            total_y += grid[j][1];

            minus_arr[j] = 0;
        }

        optimal = combination(grid, total_x, total_y, minus_arr, 0, N, optimal);
        double res = sqrt((double)optimal);

        printf("%lf\n", res);


        for(int j = 0; j < N; j++)
            delete [] grid[j];
        
        delete [] grid;

    }

    return 0;
}

long long combination(int ** grid, long long total_x, long long total_y, int* minus_arr, int index, const int N, long long optimal){
    if(sum_arr(minus_arr, N) == N / 2){
        for(int i = 0; i < N; i ++){
            if(minus_arr[i]){
                total_x -= 2 * grid[i][0];
                total_y -= 2 * grid[i][1];
            }

        }

        long long res = (total_x * total_x) + (total_y * total_y);
        if(res < optimal){
            optimal = res;
        }
        return optimal;
    }

    else if(index == N)
        return optimal;
    
    else{
        minus_arr[index] = 1;
        optimal = combination(grid, total_x, total_y, minus_arr, index + 1, N, optimal);
        minus_arr[index] = 0;
        optimal = combination(grid, total_x, total_y, minus_arr, index + 1, N, optimal);

        return optimal;
    }

}

int sum_arr(int* arr, int N){
    int sum = 0;
    for(int i = 0; i < N; i++)
        sum += arr[i];

    return sum;
}
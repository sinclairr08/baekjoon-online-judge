// https://www.acmicpc.net/problem/1149
// 20201223

#include <cstdio>
#define MIN(X, Y) (((X) < (Y)) ? (X) : (Y))

int main(){
    int N;
    scanf("%d", &N);
    int colors[1000][3];
    int sum_colors[1000][3];

    for(int i = 0; i < N; i++){
        scanf("%d %d %d", &colors[i][0], &colors[i][1], &colors[i][2]);
    }

    sum_colors[0][0] = colors[0][0];
    sum_colors[0][1] = colors[0][1];
    sum_colors[0][2] = colors[0][2];

    for(int i = 1; i < N; i++){
        sum_colors[i][0] = MIN(
            sum_colors[i - 1][1] + colors[i][0],
            sum_colors[i - 1][2] + colors[i][0]);

        sum_colors[i][1] = MIN(
            sum_colors[i - 1][0] + colors[i][1],
            sum_colors[i - 1][2] + colors[i][1]);
        
        sum_colors[i][2] = MIN(
            sum_colors[i - 1][0] + colors[i][2],
            sum_colors[i - 1][1] + colors[i][2]);
    }

    printf("%d\n", MIN(MIN(sum_colors[N-1][0], sum_colors[N-1][1]), sum_colors[N-1][2]));

    return 0;
}
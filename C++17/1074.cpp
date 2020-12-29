// https://www.acmicpc.net/problem/1074
// 20201223

#include <cstdio>

int Z_calc(int row, int col, int exp_N, int idx){
    if(exp_N == 1)
        return idx;
    
    exp_N /= 2;

    if(row > exp_N){
        row -= exp_N;
        idx += (exp_N * exp_N) * 2;
    }

    if(col > exp_N){
        col -= exp_N;
        idx += (exp_N * exp_N);
    }

    return Z_calc(row, col, exp_N, idx);
}

int main(){
    int N, row, col;
    int exp_N = 1;

    scanf("%d %d %d", &N, &row, &col);
    while(N--){
        exp_N *= 2;
    }

    printf("%d\n", Z_calc(row + 1, col + 1, exp_N, 0));


    return 0;
}
// https://www.acmicpc.net/problem/15999
// First Written : 20210129
// Last Modified : 20210129

#include <cstdio>

#define DIVIDER 1000000007

long long exponent_2(int exp){
    if(exp == 0){
        return 1;
    }
    else{
        long long res = exponent_2(exp / 2);
        res *= res;

        if(exp % 2 == 1){
            res *= 2;
        }

        return res % DIVIDER;
    }
}

int main(){
    int row, col;
    scanf("%d %d", &row, & col);
    char board[row][col];
    int indep_cnt = 0;
    char cur_val;
    

    for(int i = 0; i < row; i++){
        getchar();
        for(int j = 0; j < col; j++){
            scanf("%c", &board[i][j]);
        }
    }

    for(int i = 0; i < row; i++){
        for(int j = 0; j < col; j++){
            cur_val = board[i][j];

            if(i != 0 && cur_val != board[i-1][j]){
                continue;
            }
            else if(j != 0 && cur_val != board[i][j-1]){
                continue;
            }
            else if(i != row-1 && cur_val != board[i+1][j]){
                continue;
            }
            else if(j != col-1 && cur_val != board[i][j+1]){
                continue;
            }

            indep_cnt++;
        }
            
    }

    printf("%d", (int)exponent_2(indep_cnt));

    return 0;
}
// https://www.acmicpc.net/problem/1010
// 20201219

#include <cstdio>
#define MAX_SIZE 31

int get_combination(int comb[][31], int M, int N){
    if(comb[M][N] == 0)
        comb[M][N] = get_combination(comb, M - 1, N - 1) + get_combination(comb, M - 1, N);

    return comb[M][N];    
    
}

int main(){
    int comb[MAX_SIZE][MAX_SIZE] = {0};
    int test_case, N, M;

    for(int i = 0; i < MAX_SIZE; i++){
        comb[i][0] = 1;
        comb[i][i] = 1;
    }

    scanf("%d", &test_case);

    while(test_case--){
        scanf("%d %d", &N, &M);

        printf("%d\n", get_combination(comb, M, N));
    }



    return 0;
}
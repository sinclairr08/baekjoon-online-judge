// https://www.acmicpc.net/problem/15954
// First Written : 20210131
// Last Modified : 20210131

#include <cstdio>
#include <cmath>
#include <vector>

long double get_std(int * dolls, int num){
    long double mean = 0.;
    long double sum_sq = 0.;
    long double cur_doll;
    for(int i = 0; i < num; i++){
        cur_doll = dolls[i];
        mean += cur_doll;
        sum_sq += (cur_doll * cur_doll);
    }

    mean /= (long double)num;
    sum_sq /= (long double)num;
    sum_sq -= (mean * mean);

    return sqrt(sum_sq);
}

int main(){
    int N, K;
    scanf("%d %d", &N, &K);

    int dolls[N];
    long double optimal_std = 1.0e13;
    long double cur_std;


    for(int i = 0; i < N; i++){
        scanf("%d", &dolls[i]);
    }


    /* version 1
    for(; K <= N; K++){
        for(int i = 0; i <= N - K; i++){
            cur_std = get_std(dolls+i, K);
            if(cur_std < optimal_std){
                optimal_std = cur_std;
            }

        }

    }
    */

    long double sum_dolls;
    long double mean_dolls;
    long double sum_sq_dolls;
    long double cur_doll;
    

    for(int start = 0; start <= N - K; start++){
        sum_dolls = 0;
        sum_sq_dolls = 0;

        for(int i = start; i < start + K - 1; i++){
            cur_doll = (long double)dolls[i];
            sum_dolls += cur_doll;
            sum_sq_dolls += cur_doll * cur_doll;
        }

        for(int end = start + K - 1; end < N; end++){
            cur_doll = dolls[end];

            sum_dolls += cur_doll;
            sum_sq_dolls += cur_doll * cur_doll;

            mean_dolls = sum_dolls / (long double)(end - start + 1);

            cur_std = sum_sq_dolls / (long double)(end - start + 1);
            cur_std -= (mean_dolls * mean_dolls);
            cur_std = sqrt(cur_std);

            if(cur_std < optimal_std){
                optimal_std = cur_std;
            }

        }


    }

    printf("%.11Lf", optimal_std);


    return 0;
}
// https://www.acmicpc.net/problem/2839
// First Written : 20210108
// Last Modified : 20210108

#include <cstdio>

int cnt_3_by_remainder_5[5] = {0, 2, 4, 1, 3};

int main(){
    int N;
    scanf("%d", &N);

    int cnt_3 = cnt_3_by_remainder_5[N % 5];
    int N_5 = N - (3 * cnt_3);
    int cnt_5 = N_5 / 5;

    if(cnt_5 < 0)
        printf("-1");
    else
        printf("%d", cnt_3 + cnt_5);

    return 0;
}
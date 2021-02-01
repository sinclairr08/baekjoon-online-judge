// https://www.acmicpc.net/problem/1463
// First Written : 20201231
// Last Modified : 20201231

#include <cstdio>
#define MIN(X,Y) (((X) < (Y)) ? (X) : (Y))

int main(){
    int N;
    int optimal;
    scanf("%d", &N);

    int optimals[N + 1] = {0};
    for(int i = 2; i <= N; i++){
        optimal = optimals[i-1];

        if(i % 3 == 0){
            optimal = MIN(optimal, optimals[i / 3]);
        }

        if(i % 2 == 0){
            optimal = MIN(optimal, optimals[i / 2]);
        }

        optimals[i] = optimal + 1;
    }
    printf("%d", optimals[N]);

    return 0;
}
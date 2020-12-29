// https://www.acmicpc.net/problem/1003
// 20201219

#include <cstdio>

int main(){
    int Test_case;
    int N;
    int Fibos[42] = {0};
    Fibos[1] = 1;
    int cnt = 1;

    scanf("%d", &Test_case);

    while (Test_case--)
    {
        scanf("%d", &N);
        if(N == 0)
            printf("1 0\n");

        else if(N <= cnt)
            printf("%d %d\n", Fibos[N - 1], Fibos[N]);
        
        else{
            while(cnt != N){
                Fibos[cnt + 1] = Fibos[cnt] + Fibos[cnt - 1];
                cnt++;
            }

            printf("%d %d\n", Fibos[N - 1], Fibos[N]);
        }
    }
    
    return 0;
}
// https://www.acmicpc.net/problem/1065
// 20201223

#include <cstdio>

int main(){
    int N;
    scanf("%d", &N);

    if(N < 100)
        printf("%d\n", N);
    
    else{
        int cnt = 99;
        int di_1, di_10, di_100;
        
        while(N > 99){
            di_100 = N / 100;
            di_10 = (N / 10) - (di_100 * 10);
            di_1 = N % 10;

            if((di_1 - di_10) == (di_10 - di_100))
                cnt++;
            
            N--;
        }
        printf("%d\n", cnt);
    }



    return 0;
}
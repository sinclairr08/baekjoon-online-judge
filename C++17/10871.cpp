// https://www.acmicpc.net/problem/10871
// First Written : 20210118
// Last Modified : 20210118

#include <cstdio>

int main(){
    int N, max;
    int num;

    scanf("%d %d", &N, &max);
    while (N--){
        scanf("%d", &num);
        if(num < max)
            printf("%d ", num);
    }
    


    return 0;
}
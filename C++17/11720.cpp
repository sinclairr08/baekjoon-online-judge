// https://www.acmicpc.net/problem/11720
// First Written : 20210120
// Last Modified : 20210120

#include <cstdio>

int main(){
    int N;    
    int result = 0;
    char temp;

    scanf("%d", &N);
    getchar();

    while (N--){
        scanf("%c", &temp);
        result += (int)(temp -'0');
    }

    printf("%d", result);
    
    return 0;
}
// https://www.acmicpc.net/problem/2490
// First Written : 20210107
// Last Modified : 20210107

#include <cstdio>

char answer[5] = {'D', 'C', 'B', 'A', 'E'};

int main(){
    int result;
    int yut;

    for(int i = 0; i < 3; i++){
        result = 0;
        for(int j = 0; j < 4; j++){
            scanf("%d", &yut);
            result += yut;
        }

        printf("%c\n", answer[result]);
    }

    return 0;
}
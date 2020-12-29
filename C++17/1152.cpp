// https://www.acmicpc.net/problem/1152
// 20201228

#include <cstdio>

int main(){
    int num = 0;
    char c;
    char prev = ' ';

    while((c = getchar()) != EOF && c != '\n'){
        if(c != ' ' && prev == ' '){
            num++;
        }

        prev = c;
    }

    printf("%d\n", num);

    return 0;
}
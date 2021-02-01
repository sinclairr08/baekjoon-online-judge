// https://www.acmicpc.net/problem/1193
// First Written : 20201229
// Last Modified : 20201229

#include <cstdio>

int main(){
    int N;
    int mol, den;
    scanf("%d", &N);

    int line = 1;
    while(N > line){
        N -= line;
        line += 1;
    }

    if(line % 2 == 0){
        mol = N;
        den = line + 1 - N;
    }

    else{
        mol = line + 1 - N;
        den = N;
    }

    printf("%d/%d\n", mol, den);
    return 0;
}
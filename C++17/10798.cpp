// https://www.acmicpc.net/problem/10798
// First Written : 20210118
// Last Modified : 20210118

#include <cstdio>
char words[5][16];

int main(){
    for(int i = 0; i < 5; i++)
        for(int j = 0; j < 16; j++)
            words[i][j] = '\0';
    
    for(int i = 0; i < 5; i++)
        scanf("%s", words[i]);

    
    for(int j = 0; j < 16; j++)
        for(int i = 0; i < 5; i++)
            if(words[i][j])
                printf("%c", words[i][j]);

    return 0;
}
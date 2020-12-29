// https://www.acmicpc.net/problem/1018
// 20201222

#include <cstdio>
#define MAX_SIZE 51

using namespace std;

int main(){
    char board[MAX_SIZE][MAX_SIZE];
    int height, width;
    int minimum = 64;
    int count;

    scanf("%d%d", &height, &width);
    for(int i = 0; i < height; i++)
        scanf("%s", board[i]);

    for(int i = 0; i < height - 7; i++){
        for(int j = 0; j < width - 7; j++){
            count = 0;

            for(int k = i; k < i + 8; k++){
                for(int l = j; l < j + 8; l++){
                    if(((k + l) % 2)){
                        if(board[k][l] == 'W')
                            count++;
                    }
                    else{
                        if(board[k][l] == 'B')
                            count++;
                    }
                }
            }

            if(count > 32)
                count = 64 - count;
            
            if(count < minimum)
                minimum = count;
        }
    }
    

    printf("%d", minimum);


    return 0;
}   
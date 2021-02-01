// https://www.acmicpc.net/problem/9498
// First Written : 20210118
// Last Modified : 20210118

#include <cstdio>

int main(){
    int score;
    scanf("%d", &score);

    if(score >= 90){
        printf("A");
    } else if(score >= 80){
        printf("B");
    } else if(score >= 70){
        printf("C");
    } else if(score >= 60){
        printf("D");
    } else{
        printf("F");
    }


    return 0;
}
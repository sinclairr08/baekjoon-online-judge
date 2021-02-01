// https://www.acmicpc.net/problem/8958
// First Written : 20210108
// Last Modified : 20210108

#include <cstdio>

int main(){
    int Test_case;
    char words[80];
    int O_stack;
    int total;

    scanf("%d", &Test_case);
    while(Test_case--){
        scanf("%s", words);
        total = 0;
        O_stack = 0;

        for(int i = 0; words[i] != '\0'; i++){
            if(words[i] == 'O')
                total += ++O_stack;
            
            else
                O_stack = 0;

        }

        printf("%d\n", total);
    }

    return 0;
}
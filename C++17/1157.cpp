// https://www.acmicpc.net/problem/1157
// 20201228

#include <cstdio>
#include <cctype>

#define WORDS_LEN 26
#define MAX_LEN 1000001


int main(){
    int words[WORDS_LEN] = {0};
    char str[MAX_LEN] = {'\0'};
    
    int max_num = 0;
    int idx, answer_idx;

    scanf("%s", str);

    for(int i = 0; str[i] != '\0' && str[i] != '\n'; i++){
        if(islower(str[i])){
            idx = (int)(toupper(str[i]) - 'A');
        }
        else
        {
            idx = (int)(str[i] - 'A');
        }
        
        words[idx]++;
    }


    for(int i = 0; i < WORDS_LEN; i++){
        if(words[i] > max_num){
            answer_idx = i;
            max_num = words[i];
        }

        else if(words[i] == max_num){
            answer_idx = -1;
        }
    }

    if(answer_idx < 0){
        printf("?");
    }

    else{
        printf("%c", (char)(answer_idx + 'A'));
    }



    return 0;
}
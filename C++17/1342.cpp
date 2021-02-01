// https://www.acmicpc.net/problem/1342
// First Written : 20201231
// Last Modified : 20201231

#include <cstdio>
#include <string>
#include <vector>
#define MAX_STR_LEN 11
#define NUM_ALPHABETS 26

using namespace std;


int alphabets[NUM_ALPHABETS] = {0};
static int total = 0;

void stack_words(vector<int>& lucky_str, int max_len){
    if(lucky_str.size() == max_len){
        total++;
        return;
    }
    
    int lucky_str_size = lucky_str.size();
    for(int i = 0; i < NUM_ALPHABETS; i++){
        if(alphabets[i] > 0){
            if(lucky_str_size == 0 || i != lucky_str[lucky_str_size - 1]){
                lucky_str.push_back(i);
                alphabets[i]--;

                stack_words(lucky_str, max_len);

                lucky_str.pop_back();
                alphabets[i]++;
            }
        }
    }
    return;

}

int main(){
    char input_str[MAX_STR_LEN];   
    int factorial[11] = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800};
    
    scanf("%s", input_str);
    string str = input_str;

    for(int i = 0; i < str.size(); i++)
        alphabets[(int)(str[i] - 'a')]++;

    int max_val = 0;
    for(int i = 0; i < NUM_ALPHABETS; i++){
        if(alphabets[i] > max_val)
            max_val = alphabets[i];
    }
    
    if(max_val == 1){
        printf("%d", factorial[str.size()]);
    }

    else{
        vector<int> lucky_str;
        stack_words(lucky_str, str.size());
        printf("%d", total);
    }   

    return 0;
}
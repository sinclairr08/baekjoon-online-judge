// https://www.acmicpc.net/problem/9935
// First Written : 20210118
// Last Modified : 20210118

#include <cstdio>
#include <cstring>
#include <vector>

#define MAX_LEN 1000001
#define MAX_BOMB_LEN 37

using namespace std;

class Stack{
private:
    vector<char> list;
    vector<int> state_list;
public:

    void insert(char word){
        list.push_back(word);
        state_list.push_back(0);
    }

    void set_state(int state){
        state_list.pop_back();
        state_list.push_back(state);
    }

    void pops(int n_pop){
        while(n_pop--){
            list.pop_back();
            state_list.pop_back();
        }
    }

    int get_state(){
        if(state_list.size() == 0)
            return 0;
        
        else
            return state_list[state_list.size() - 1];
    }

    int get_size(){
        return list.size();
    }

    void print_result(){
        for(auto it:list)
            printf("%c", it);
    }

};

char original[MAX_LEN];
char bomb[MAX_BOMB_LEN];

int main(){
    scanf("%s", original);
    scanf("%s", bomb);

    int original_len = strlen(original);
    int bomb_len = strlen(bomb);
    int cur_match = 0;
    char cur_word;

    Stack stack;

    for(int i = 0; i < original_len; i++){
        cur_word = original[i];
        stack.insert(cur_word);

        if(cur_word == bomb[cur_match]){
            stack.set_state(++cur_match);

            if(cur_match == bomb_len){
                stack.pops(bomb_len);
                cur_match = stack.get_state();
            }
        }

        else{
            cur_match = 0;

            if(cur_word == bomb[cur_match]){
                stack.set_state(++cur_match);
            }
        }


    }

    if(stack.get_size() == 0)
        printf("FRULA");
    
    else
        stack.print_result();
    
    return 0;
}
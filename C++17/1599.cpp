// https://www.acmicpc.net/problem/1599
// First Written : 20210101
// Last Modified : 20210101

#include <cstdio>
#include <algorithm>
#include <string>

#define MAX_STR_LEN 51
#define NUM_ALPHABET 26

using namespace std;

// 'ng' is considered as 'z'
/*
'a' : 'a',
'b' : 'b',
'0'
'd' : 'd',
'e' : 'e',
'0'
'g' : 'g',
'h' : 'h',
'i' : 'i',
'0'
'k' : 'c',
'l' : 'l',
'm' : 'm',
'n' : 'n',
'o' : 'p',
'p' : 'q',
'0'
'r' : 'r',
's' : 's',
't' : 't',
'u' : 'u',
'0'
'w' : 'w',
'0'
'y' : 'y'
'z' == ng' : 'o',
*/
char MINSIK[NUM_ALPHABET] = {
    'a', 'b', '0', 'd', 'e', '0', 'g', 'h', 'i', 
    '0', 'c', 'l', 'm', 'n', 'p', 'q', '0', 'r', 
    's', 't', 'u', '0', 'w', '0', 'y', 'o'
};

string to_minsik(char* words){
    string s;
    bool prev_count = false;

    for(int i = 0; words[i] != '\0'; i++){
        if(prev_count){
            prev_count = false;
            continue;
        }

        if(words[i] == 'n' && words[i + 1] == 'g'){
            prev_count = true;
            s.push_back(MINSIK['z' - 'a']);
        }

        else{
            s.push_back(MINSIK[words[i] - 'a']);
        }


    }
    return s;

}

bool str_pair_compare(pair<string, string> p1, pair<string, string> p2){
    return p1.second < p2.second;
}

int main(){
    int N;
    scanf("%d", &N);

    char words[N][MAX_STR_LEN];
    pair<string, string> strs[N];

    for(int i = 0; i < N; i++){
        scanf("%s", words[i]);
        strs[i].first = words[i];
        strs[i].second = to_minsik(words[i]);
    }
    

    sort(strs, strs+N, str_pair_compare);

    for(int i = 0; i < N; i++){
        printf("%s\n", strs[i].first.c_str());
    }

    return 0;
}
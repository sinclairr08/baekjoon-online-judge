#include <cstdio>
#include <iostream>
#include <string>
#include <deque>

using namespace std;

string dp(int a, int b, int c, int state){
    // Initial State
    if(a + b + c + state == 0){
        return "";
    }

    // Impossible case
    if(state > a * b + b * c + c * a){
        return "-1";
    }

    string word = "";

    // Add "C" at the end of word
    if(c > 0 && state >= a + b){
        word = dp(a, b, c - 1, state - a - b);
        if(word != "-1"){
            word += "C";
            return word;
        }
    }
    
    // Add "B" at the end of word
    if(b > 0 && state >= a) {
        word = dp(a, b - 1, c, state - a);
        if(word != "-1"){
            word += "B";
            return word;
        }
    }

    // Add "A" at the end of word
    if(a > 0) {
        word = dp(a - 1, b, c, state);
        if(word != "-1"){
            word += "A";
            return word;
        }
    }

    // Exception
    return "-1";
}


int main() {
    int len_words, state;
    int a, b, c;
    string result;
    
    scanf("%d %d", &len_words, &state);

    // Divide a,b,c as evenly
    // It is possible since this divison assures the max/min states
    if(len_words % 3 == 0){
        a = len_words / 3 ;
        b = len_words / 3 ;
        c = len_words / 3 ;
    }
    else if(len_words % 3 == 1){
        a = len_words / 3 + 1;
        b = len_words / 3 ;
        c = len_words / 3 ;
    }
    else{
        a = len_words / 3 + 1;
        b = len_words / 3 + 1;
        c = len_words / 3 ;
    }

    result = dp(a, b, c, state);
    for(auto w: result){
        printf("%c", w);
    }

    return 0;
}
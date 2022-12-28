#include <iostream>
#include <vector>
#include <deque>

using namespace std;

string memos[51][51][51][2][3] = {""};

string dp(int a, int b, int c, int block_b, int block_c) {
    if(a + b + c == 0){
        return "";
    }

    if(memos[a][b][c][block_b][block_c] != "") {
        return memos[a][b][c][block_b][block_c];
    }

    string prev_string;
    int new_block_c = 0;

    if(block_c > 0) new_block_c = block_c - 1;

    if(a > 0) {
        prev_string = dp(a - 1, b, c, 0, new_block_c);

        if(prev_string != "-1"){
            memos[a][b][c][block_b][block_c] = prev_string + 'A';
            return memos[a][b][c][block_b][block_c];
        }
    }

    if(b > 0 && block_b == 0) {
        prev_string = dp(a, b - 1, c, 1, new_block_c);

        if(prev_string != "-1") {
            memos[a][b][c][block_b][block_c] = prev_string + 'B';
            return memos[a][b][c][block_b][block_c];               
        }
    }


    if(c > 0 && block_c == 0) {
        prev_string = dp(a, b, c - 1, 0, 2);

        if(prev_string != "-1") {
            memos[a][b][c][block_b][block_c] = prev_string + 'C';
            return memos[a][b][c][block_b][block_c];          
        }
        
    }

    memos[a][b][c][block_b][block_c] = "-1";
    return "-1";
}

int main() {
    string line;
    int N_a = 0, N_b = 0, N_c = 0;

    cin >> line;

    for(auto word: line) {
        if(word == 'A') N_a += 1;
        else if(word == 'B') N_b += 1;
        else if(word == 'C') N_c += 1;
    }

    cout << dp(N_a, N_b, N_c, 0, 0);

    return 0;
}
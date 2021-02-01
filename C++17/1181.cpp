// https://www.acmicpc.net/problem/1181
// First Written : 20201229
// Last Modified : 20201229

#include <cstdio>
#include <string>
#include <algorithm>

#define MAX_STR_SIZE 51

using namespace std;

bool str_compare(string a, string b){
    if(a.size() == b.size())
        return a < b;
    
    else
        return a.size() < b.size();
    
}

int main(){
    /*
    ios_base :: sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL);
    */

    int N;
    // cin >> N;
    scanf("%d", &N);

    string str[N];
    char temp[MAX_STR_SIZE];
    for(int i = 0; i < N; i++){
        //cin >> str[i];
        scanf("%s", temp);
        str[i] = temp;
    }

    sort(str, str+N, str_compare);

    for(int i = 0; i < N; i++){
        if(i == 0 || str[i] != str[i-1])
            printf("%s\n", str[i].c_str());
            // cout << str[i] << endl;
    }   

    return 0;
}
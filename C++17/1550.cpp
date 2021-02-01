// https://www.acmicpc.net/problem/1550
// First Written : 20210101
// Last Modified : 20200101

#include <cstdio>
#include <string>
#define MAX_STR_LEN 7

using namespace std;

int main(){
    char hex[MAX_STR_LEN];
    int sum = 0;
    char c;
    scanf("%s", hex);
    string str_hex = hex;

    for(int i = 0; i < str_hex.size(); i++){
        sum *= 16;
        
        c = str_hex[i];
        if(c >= '0' && c <= '9'){
            sum += (int)(c - '0');
        }

        else{
            sum += (int)(c - 'A') + 10;
        }
    }

    printf("%d", sum);

    return 0;
}
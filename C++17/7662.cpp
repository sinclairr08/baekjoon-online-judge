// https://www.acmicpc.net/problem/7662
// 20201204

#include <stdio.h>
#include <stdlib.h>
#include <cstring>
#include <map>

#define MAX_OP 1000000

using namespace std;


int main(){
    int N, T, val;
    char op, c;
    scanf("%d", &T);

    for(int i = 0; i < T; i++){
        scanf("%d", &N);
        map<int, int> maps;
        map<int, int>::iterator map_begin;
        map<int, int>::iterator map_end;

        for(int j = 0 ; j < N; j ++){
            getchar();
            scanf("%c %d", &op, &val);

            if(op == 'I'){
                if(maps.find(val) == maps.end())
                    maps[val] = 1;
                else
                    maps[val]++;
                
            }

            else if(maps.empty()) 
                    continue;
            
            else{
                if(val == 1){
                    map_end = --maps.end();
                    if(map_end -> second == 1)
                        maps.erase(map_end -> first);
                    
                    else
                        maps[map_end -> first]--;
                }


                else if(val == -1){
                    map_begin = maps.begin();
                    if(map_begin -> second == 1)
                        maps.erase(map_begin -> first);
                    
                    else
                        maps[map_begin -> first]--;
                }

                    

            }

        }

        if(maps.empty())
            printf("EMPTY\n");
        
        else{
            map_begin = maps.begin();
            map_end = --maps.end();
            printf("%d %d\n", map_end -> first, map_begin->first);
        }

        maps.clear();


    }

    return 0;
}
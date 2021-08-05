// https://www.acmicpc.net/problem/7662
// 20201203

#include <stdio.h>
#include <stdlib.h>
#include <cstring>
#include <map>

#define MAX_OP 1000000

using namespace std;

/*
class Hash{
public:
    int item;
    int count;



    Hash(){
        item = 0;
        count = 0;
    }

    void set_item(int _item){
        item = _item;
        count = 1;

    }

    void add_count(){
        count++;
    }

};
*/


class Deque {
public:
    int len_item;
    int *items;
    map<int, int> maps;

    Deque(){
        len_item = 0;
        items = new int[MAX_OP];
    }


    ~Deque(){
        delete [] items;
        maps.clear();
    }

    void insert(int _val){
        if(maps.find(_val) == maps.end()){
            maps[_val] = 1;
            insert_item(_val, 0, len_item);
        }

        else{
            maps[_val]++;
        }
            
    }

    void insert_item(int _val, int left, int right){
        if(left == right){
            if(len_item == left)
                items[left] = _val;
            
            else{
                int diff = len_item - left;
                memmove(&items[left+1], &items[left], sizeof(int) * diff );
                items[left] = _val;
            }
            
            len_item += 1;
            return;
        }

        int middle = left + (right - left) / 2;

        if(items[middle] > _val)
            insert_item(_val, left, middle);
        else
            insert_item(_val, middle + 1, right);
        
    }

    void delete_max(){
        int max_val = items[len_item - 1];
        
        if(maps[max_val] == 1){
            maps.erase(max_val);
            len_item--;
        }

        else{
            maps[max_val]--;
        }      

        return;
    }

    void delete_min(){
        int min_val = items[0];

        if(maps[min_val] == 1){
            maps.erase(min_val);
            if(len_item > 1)
                memmove(&items[0], &items[1], sizeof(int) * (len_item - 1) );
            len_item--;
        }

        else{
            maps[min_val]--;
        }     

        return;
    }

    /*
    void print_cur(){
        printf("cur_len : %d\n", len_item);
        for(int k = 0; k < len_item; k++)
            printf("%d ", items[k]);
        printf("\n");
    }
    */

        
};

int main(){
    int N, T, val;
    char op, c;
    scanf("%d", &T);

    for(int i = 0; i < T; i++){
        scanf("%d", &N);
        Deque *deque = new Deque();

        for(int j = 0 ; j < N; j ++){
            getchar();
            scanf("%c %d", &op, &val);

           

            if(op == 'I'){
                deque->insert(val);
            }

            else if(deque->len_item == 0) 
                    continue;
            
            else{
                if(val == 1)
                    deque->delete_max();
                

                else if(val == -1)
                    deque->delete_min();

            }
            

        }

        if(deque->len_item == 0)
            printf("EMPTY\n");
        
        else{
            printf("%d %d\n", deque->items[deque->len_item - 1], deque->items[0]);
        }

        delete deque;

    }

    return 0;
}
// https://www.acmicpc.net/problem/18111
// 20201019

#include <stdio.h>

void calc_blocks(int **blocks, int height, int N, int M, int &cost, int &req_block){
    int D;
    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            D = blocks[i][j] - height;

            if (D > 0){
                cost += 2 * D;
                req_block -= D;
            }
            else if (D < 0){
                cost -= D;
                req_block -= D;
            }
        }
    }

    return;
}

int main(){
    int N, M, B;
    int cost = 0, req_block = 0;
    int smallest_cost = __INT32_MAX__;
    int min_h = 256, max_h = 0;
    int cur_h, smallest_h;
    
    scanf("%d %d %d", &N, &M, &B);
    int** blocks = new int*[N];
    for(int i = 0; i < N; i++){
        blocks[i] = new int[M];
    } 

    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            scanf("%d", &blocks[i][j]);
            cur_h = blocks[i][j];
            if (cur_h < min_h)
                min_h = cur_h;
            if (cur_h > max_h)
                max_h = cur_h;
        }
    }

    for(int h = min_h; h <= max_h; h++){
        calc_blocks(blocks, h, N, M, cost, req_block);

        if (req_block > B){
            cost = 0;
            req_block = 0;
            break;
        }
        
        else if(cost <= smallest_cost){
            smallest_cost = cost;
            smallest_h = h;
        }

        cost = 0;
        req_block = 0;
    }
    
    printf("%d %d", smallest_cost, smallest_h);

    for(int i = 0; i < N; i++){
        delete [] blocks[i];
    } 
    delete [] blocks;  

    return 0;
}
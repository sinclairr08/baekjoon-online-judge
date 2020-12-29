// https://www.acmicpc.net/problem/1089
// 20201223

#include <cstdio>

int main(){
    int N_num;
    char lights[5][36];
    const char* answer[5] = {
        "###...#.###.###.#.#.###.###.###.###.###",
        "#.#...#...#...#.#.#.#...#.....#.#.#.#.#",
        "#.#...#.###.###.###.###.###...#.###.###",
        "#.#...#.#.....#...#...#.#.#...#.#.#...#",
        "###...#.###.###...#.###.###...#.###.###",
    };
    scanf("%d", &N_num);

    for(int i = 0; i < 5; i++){
        scanf("%s", lights[i]);
    }

    int base = 1;
    int cur_sum, cur_cnt;
    double average = 0.0;
    bool flag = true;
    for(int i = N_num - 1; i >= 0; i--){
        cur_sum = 0;
        cur_cnt = 0;

        for(int j = 0; j < 10; j++){  

            for(int k = 0; k < 5; k++){
                for(int l = 0; l < 3 ; l++){
                    if(lights[k][4 * i + l] == '#' && answer[k][4 * j + l] == '.'){
                        flag = false;
                        break;
                    }
                }
                if(!flag)
                    break;
            }
            if(flag){
                cur_sum += j;
                cur_cnt++;
            }           
            flag = true;
        }

        if(cur_cnt != 0)
            average += (((double)(cur_sum)) / ((double)(cur_cnt))) * (double(base));
        else
        {
            printf("%d\n", -1);    
            return 0;
        }
        
        base *= 10;
    }

    printf("%.8lf\n", average);
    return 0;
}
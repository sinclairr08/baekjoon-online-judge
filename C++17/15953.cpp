// https://www.acmicpc.net/problem/15953
// First Written : 20210120
// Last Modified : 20210120

#include <cstdio>

int prizes1[6] = {5000000, 3000000, 2000000, 500000, 300000, 100000};
int prizes2[5] = {5120000, 2560000, 1280000, 640000, 320000};

int con1(int rank){
    if(rank == 0)
        return 0;

    int idx = 1;
    int person_per_idx = 1;

    while(idx <= 6){
        if(rank <= person_per_idx)
            return prizes1[idx - 1];

        else{
            rank -= person_per_idx++;
            idx++;
        }
    }

    return 0;

}

int con2(int rank){
    if(rank == 0)
        return 0;
    
    int idx = 1;
    int person_per_idx = 1;

    while(idx <= 5){
        if(rank <= person_per_idx)
            return prizes2[idx - 1];

        else{
            rank -= person_per_idx;
            idx++;
            person_per_idx *= 2;
        }
    }

    return 0;

}

int main(){
    int Test_case;
    int rank1, rank2;
    scanf("%d", &Test_case);

    while (Test_case--){
        scanf("%d %d", &rank1, &rank2);
        printf("%d\n", con1(rank1) + con2(rank2));
    }   

    return 0;
}
// https://www.acmicpc.net/problem/9663
// First Written : 20210405
// Last Modified : 20210405

#include <cstdio>
#include <vector>

int v_visits[15] = {0};
int ld_visits[30] = {0};
int rd_visits[30] = {0};

std::vector<int> next_candidates(int depth, const int N){
    std::vector<int> candidates;
    for(int i = 0; i < N; i++){
        if(v_visits[i] == 1)
            continue;
        else if(ld_visits[i - depth + N - 1] == 1)
            continue;
        else if(rd_visits[i + depth] == 1)
            continue;

        candidates.push_back(i);
    }
    return candidates;
}

int backtrack(int depth, int total, const int N){
    if(depth == N){
        return total + 1;
    }

    else{
        std::vector<int> candidates = next_candidates(depth, N);

        for(auto j: candidates){
            v_visits[j] = 1;
            ld_visits[(j - depth + N - 1)] = 1;
            rd_visits[j + depth] = 1;

            total = backtrack(depth + 1, total, N);

            v_visits[j] = 0;
            ld_visits[(j - depth + N - 1)] = 0;
            rd_visits[j + depth] = 0;
            
        }

        return total;
    }
}

int main(){
    int N;
    scanf("%d", &N); 

    printf("%d", backtrack(0, 0, N));

    return 0;
}
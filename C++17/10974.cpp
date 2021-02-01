// https://www.acmicpc.net/problem/10974
// First Written : 20210118
// Last Modified : 20210118

#include <cstdio>
#include <vector>

std::vector<int> numbers;
bool visited[8] = {false};

void perm(int depth, const int N){
    if(depth < N){
        for(int i = 0; i < N; i++){
            if(!visited[i]){
                numbers.push_back(i + 1);
                visited[i] = true;

                perm(depth + 1, N);
                
                visited[i] = false;
                numbers.pop_back();
            }
        }
    }

    else{
        for(int i = 0; i < N; i++)
            printf("%d ", numbers[i]);
        printf("\n");
    }

}

int main(){
    int N;
    scanf("%d", &N);
    perm(0, N);

    return 0;
}
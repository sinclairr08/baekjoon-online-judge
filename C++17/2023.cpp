#include <cstdio>
#include <vector>
#include <deque>
#include <cmath>

using namespace std;

int odds[5] = {1, 3, 5, 7, 9};

bool is_prime(int N) {
    if(N <= 1) return false;
    if(N == 2) return true;

    for(int div = 2; div < (int) ceil(sqrt(N)) + 1; div++) {
        if(N % div == 0){
            return false;
        }
    }
    return true;
}

void dfs(int depth, int len_number, int value) {
    if(depth == len_number){
        printf("%d\n", value);
        return;
    }

    int next_value;

    for (int i = 0; i < 5; i++){
        if(depth + i == 0) next_value = value * 10 + 2;
        else next_value = value * 10 + odds[i];

        if(is_prime(next_value)){
            dfs(depth + 1, len_number, next_value);
        }

    }

    return;

}

int main() {
    int len_number;

    scanf("%d", &len_number);

    dfs(0, len_number, 0);

    return 0;
}
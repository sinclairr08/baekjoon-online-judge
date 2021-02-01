// https://www.acmicpc.net/problem/2193
// First Written : 20210105
// Last Modified : 20210105

#include <cstdio>
#include <vector>

int main(){
    int N;
    int idx;
    scanf("%d", &N);

    std::vector<long long> pinary;
    pinary.push_back(0);
    pinary.push_back(1);
    pinary.push_back(1);

    while(N >= pinary.size()){
        idx = pinary.size();
        pinary.push_back(
            pinary[idx - 1] + pinary[idx - 2]
        );

    }

    printf("%lld", pinary[N]);


    return 0;
}
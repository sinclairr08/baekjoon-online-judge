// https://www.acmicpc.net/problem/3955
// First Written : 20210108
// Last Modified : 20210626

#include <cstdio>
#include <vector>

int get_candy(int K, int C){
    long long r0 = K;
    long long r1 = C;
    long long r2 = K % C;
    
    std::vector<int> quotients;

    while(r2 != 0){
        quotients.push_back(r0 / r1);
        r0 = r1;
        r1 = r2;
        r2 = r0 % r1;
    }

    if(r1 != 1)
        return -1;
    
    std::vector<int> coeff_K;
    coeff_K.push_back(1);
    coeff_K.push_back(0);

    std::vector<int> coeff_C;
    coeff_C.push_back(0);
    coeff_C.push_back(1);
    
    int next_coeff_K, next_coeff_C;

    for(int q:quotients){
        next_coeff_K = coeff_K[coeff_K.size() - 2]
                       - q * coeff_K[coeff_K.size() - 1];
        
        next_coeff_C = coeff_C[coeff_C.size() - 2]
                       - q * coeff_C[coeff_C.size() - 1];

        coeff_K.push_back(next_coeff_K);
        coeff_C.push_back(next_coeff_C);

    }

    long long X_C = (long long)coeff_C.back();
    long long neg_X_K = (long long)coeff_K.back();

    while((X_C <= 0) || (neg_X_K >= 0)){
        X_C += K;
        neg_X_K -= C;
    }

    if(X_C > 1000000000)
        return -1;
    else
        return (int)X_C;

}

int main(){
    int Test_case;
    int K, C;

    scanf("%d", &Test_case);

    while(Test_case--){
        scanf("%d %d", &K, &C);
        int result = get_candy(K, C);
        
        if(result > 0)
            printf("%d\n", result);
        
        else
            printf("IMPOSSIBLE\n");
    }
    
    return 0;
}
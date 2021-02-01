// https://www.acmicpc.net/problem/3955
// First Written : 20210108
// Last Modified : 20210108

#include <cstdio>
#include <vector>

int get_candy(int K, int C){
    long long original_K = K;
    long long original_C = C;
    int remainder = K % C;
    std::vector<int>quotients;

    while(remainder != 0){
        quotients.push_back(K / C);
        K = C;
        C = remainder;
        remainder = K % C;
    }

    if(C != 1)
        return -1;
    
    std::vector<int> x_k;
    x_k.push_back(1);x_k.push_back(0);
    std::vector<int> x_c;
    x_c.push_back(0);x_c.push_back(1);
    int y_k, y_c;

    for(int q:quotients){
        y_k = x_k[x_k.size() - 2] - q * x_k[x_k.size() - 1];
        y_c = x_c[x_c.size() - 2] - q * x_c[x_c.size() - 1];

        x_k.push_back(y_k);
        x_c.push_back(y_c);

    }

    long long ans = x_c[x_c.size() - 1];

    while((ans <= 0) || (ans * original_C <= original_K)){
        ans += original_K;
    }

    if(ans > 1000000000)
        return -1;
    else
        return (int)ans;

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
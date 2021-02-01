// https://www.acmicpc.net/problem/15998
// First Written : 20210129
// Last Modified : 20210129

#include <cstdio>
#include <cstdlib>
#include <vector>

long long get_gcd(long long a, long long b){
    long long temp;
    while(b != 0){
        temp = a % b;
        a = b;
        b = temp;
    }

    return a;
}

int main(){
    int N;
    long long deposit, balance;
    long long cur_balance = 0;
    const long long max_val = 9000000000000000000;
    long long lower_bound = 0;

    std::vector<long long> candidates;
    scanf("%d", &N);

    while(N--){
        scanf("%lld %lld", &deposit, &balance);

        if(deposit > 0){
            if(cur_balance + deposit != balance){
                printf("-1");
                exit(0);
            }

        }

        else{
            if(cur_balance + deposit != balance){
                candidates.push_back(balance - cur_balance - deposit);

                if(lower_bound < balance)
                    lower_bound = balance;
            }
        }

        cur_balance = balance;
    }

    if(candidates.size() == 0)
        printf("1");
    else{
        long long gcd = candidates[0];

        if(gcd <= lower_bound){
            printf("-1");
            exit(0);
        }

        for(int i = 1; i < candidates.size(); i++){
            gcd = get_gcd(gcd, candidates[i]);

            if(gcd <= lower_bound){
                printf("-1");
                exit(0);
            }

        }

        if(gcd > max_val){
            printf("-1");
        }
        else{
            printf("%lld", gcd);
        }

    }

    return 0;
}

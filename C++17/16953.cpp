#include <cstdio>
#include <deque>

using namespace std;

struct info {
    long long value;
    int depth;
};

int main() {
    long long A, B;
    long long tw_value, ad_value;

    info cur_info;
    deque<info> queue;
    
    scanf("%lld %lld", &A, &B);
    queue.push_back({A, 1});

    while(!queue.empty()){
        cur_info = queue.front();
        queue.pop_front();

        tw_value = cur_info.value * 2;
        ad_value = cur_info.value * 10 + 1;

        if(tw_value == B){
            cur_info.value = tw_value;
            cur_info.depth += 1;
            break;
        }
        else if(tw_value < B){
            queue.push_back({tw_value, cur_info.depth + 1});
        }

        if(ad_value == B){
            cur_info.value = ad_value;
            cur_info.depth += 1;
            break;
        }
        else if(ad_value < B){
            queue.push_back({ad_value, cur_info.depth + 1});
        }
    }

    if(cur_info.value == B){
        printf("%d", cur_info.depth);
    }
    else{
        printf("-1");
    }

    return 0;
}
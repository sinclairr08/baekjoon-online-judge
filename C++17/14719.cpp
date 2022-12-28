#include <cstdio>
#include <deque>

using namespace std;

int total_water(deque<int> heights){
    if(heights.size() == 1) return 0;

    int start_height = 0;
    int sum = 0, total_sum = 0;
    deque<int> sub_heights;

    for (auto height: heights) {
        if (height >= start_height) {
            total_sum += sum;
            
            start_height = height;
            sum = 0;

            sub_heights.clear();
            sub_heights.push_front(height);
        }
        else {
            sum += start_height - height;
            sub_heights.push_front(height);
        }

    }

    total_sum += total_water(sub_heights);
    return total_sum;
}

int main(){
    int max_height, max_width;
    int height;

    deque<int> heights;

    scanf("%d %d", &max_height, &max_width);

    for(int i = 0; i < max_width ; i++){
        scanf("%d", &height);
        heights.push_back(height);
    }

    printf("%d", total_water(heights));
    
    return 0;
}
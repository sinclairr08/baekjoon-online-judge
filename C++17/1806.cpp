// https://www.acmicpc.net/problem/1806
// First Written : 20210515
// Last Modified : 20210515

#include <cstdio>
#include <vector>

#define MAX_ARR_SIZE 100000

int main(){
    int arr_size, input_num;
    int min_arr_size = MAX_ARR_SIZE + 1;

    long long target;
    long long partial_sum = 0;
    
    int start = 0, end = 0;

    std::vector<int> arr;

    scanf("%d %d", &arr_size, &target);
    for(int i = 0; i < arr_size; i++){
        scanf("%d", &input_num);
        arr.push_back(input_num);
    }

    while(end <= arr_size){
        if(partial_sum < target){
            partial_sum += arr[end++];
        }
        else if(partial_sum >= target){
            if((end - start) < min_arr_size)
                min_arr_size = end - start;
            partial_sum -= arr[start++];
        }

    }
    if(min_arr_size > MAX_ARR_SIZE)
        printf("0\n");
    else
        printf("%d\n", min_arr_size);

    return 0;
}
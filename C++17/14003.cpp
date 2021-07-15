// https://www.acmicpc.net/problem/14003
// First Written : 20210711
// Last Modified : 20210711

#include <cstdio>
#include <vector>

#define MAXLEN 1000000
#define LOWER_BOUND -1000000001

int input[MAXLEN+1] = {0};

/* The minumum end value of a subsequence whose length is its idx */
int endval_per_length[MAXLEN+1] = {LOWER_BOUND};

/* Index of the endval_per_length */
int endidx_per_length[MAXLEN+1] = {0};

/* Index of former value corresponding to current subsequence */
int prev_idx[MAXLEN+1] = {0};

/* Find the index of the certain value */
int binary_search_idx(int* arr, int left, int right, int val){
    int mid;
    while(left != right){
        mid = (left + right + 1) / 2;
        if(val <= arr[mid]){
            right = mid - 1;
        }
        else{
            left = mid;
        }

    }
    return left;
}

int main(){
    int input_length;
    int max_length = 0;
    int cur_length;

    scanf("%d", &input_length);
    for(int i = 1; i <= input_length; i++){
        scanf("%d", &input[i]);
    }

    for(int idx = 1; idx <=input_length; idx++){
        /* cur length means the maximum legth of subseq that ends with current value */
        cur_length = binary_search_idx(endval_per_length, 0, max_length, input[idx]) + 1;

        /* Update the max length */
        if(cur_length > max_length){
            max_length = cur_length;
        }

        /* update the end value as current value */
        endval_per_length[cur_length] = input[idx];
        endidx_per_length[cur_length] = idx;

        prev_idx[idx] = endidx_per_length[cur_length - 1];
    }

    printf("%d\n", max_length);

    std::vector<int> result;
    int cur_idx = endidx_per_length[max_length];

    /* Stack the value of the results at the vector */
    while(cur_idx != 0){
        result.push_back(input[cur_idx]);
        cur_idx = prev_idx[cur_idx];
    }

    /* Print the results in the right order */
    std::vector<int>::reverse_iterator rit;
    for(rit = result.rbegin(); rit != result.rend(); rit++){
        printf("%d ", *rit);
    }

    return 0;
}
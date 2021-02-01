// https://www.acmicpc.net/problem/2751
// First Written : 20210108
// Last Modified : 20210131

#include <cstdio>
#include <cstdlib>
#define MAX_SIZE 1000001

int arr[MAX_SIZE];
int sorted[MAX_SIZE];

inline void swap_idx(int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;

    return;
}

void merge(int left, int mid, int right){
    int left_idx = left;
    int right_idx = mid + 1;
    int sorted_idx = left;

    while((left_idx <= mid) && (right_idx <= right)){
        if(arr[left_idx] < arr[right_idx]){
            sorted[sorted_idx++] = arr[left_idx++];
        }else{
            sorted[sorted_idx++] = arr[right_idx++];
        }

    }

    if(left_idx > mid){
        while(right_idx <= right){
            sorted[sorted_idx++] = arr[right_idx++];
        }
    }

    else{
        while(left_idx <= mid){
            sorted[sorted_idx++] = arr[left_idx++];
        }
    }

    for(int i = left; i <= right; i++){
        arr[i] = sorted[i];
    }

    return;

}

void merge_sort(int left, int right){
    if(left == right){
        return;
    }

    int mid = (left + right) / 2;

    merge_sort(left, mid);
    merge_sort(mid+1, right);
    merge(left, mid, right);

    return;
}

int main(){
    int N;
    scanf("%d", &N);     

    for(int i = 0; i < N; i++){
        scanf("%d", &arr[i]);
    }

    merge_sort(0, N - 1);

    for(int i = 0; i < N; i++){
        printf("%d\n", arr[i]);
    }

    return 0;
}
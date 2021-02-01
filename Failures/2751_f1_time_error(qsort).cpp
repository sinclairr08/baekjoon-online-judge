// https://www.acmicpc.net/problem/2751
// First Written : 20210108
// Last Modified : 20210108
// Failure Code : Qsort is not suitable for this problem(20210131)

#include <cstdio>
#include <cstdlib>

int arr[1000001];


inline void swap_idx(int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;

    return;
}

int partition(int left, int right){
    swap_idx(left, (left + right) / 2);

    int pivot = arr[left];
    int low = left + 1;
    int high = right;

    if((low == high) && (pivot < arr[high]))
        high--;
    
    while(low < high){
        while((low < right) && (arr[low] < pivot))
            low++;
        
        while((high > left) && (arr[high] > pivot))
            high--;
        
        if(low < high)
            swap_idx(low, high);
    }

    swap_idx(left, high);
    return high;
}

void quick_sort(int left, int right){
    if(left < right){
        int pivot_idx = partition(left, right);

        quick_sort(left, pivot_idx - 1);
        quick_sort(pivot_idx + 1, right);

    }
    return;
}



int main(){
    int N;
    scanf("%d", &N);     

    for(int i = 0; i < N; i++){
        scanf("%d", &arr[i]);
    }

    quick_sort(0, N - 1);

    for(int i = 0; i < N; i++){
        printf("%d\n", arr[i]);
    }

    return 0;
}
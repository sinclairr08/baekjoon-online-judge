// https://www.acmicpc.net/problem/1927
// First Written : 20210101
// Last Modified : 20210101

#include <cstdio>
#include <vector>

using namespace std;

class Heap{
private:
    int* heaps;
    int size;

public:
    Heap(int N){
        heaps = new int[N]();
        size = 0;
    }

    ~Heap(){
        delete [] heaps;
    }

    void push(int val){
        heaps[++size] = val;
        int idx = size;
        
        while(idx != 1){
            if(heaps[idx] < heaps[get_parent(idx)]){
                swap(idx, get_parent(idx));
                idx = get_parent(idx);
            }

            else{
                break;
            }

        }

    }

    int pop(){
        if(size == 0)
            return 0;
        
        int val = heaps[1];
        heaps[1] = heaps[size--];

        int idx = 1;
        int idx_c = get_Schild(idx);

        while(idx_c > 0){
            if(heaps[idx_c] < heaps[idx]){
                swap(idx, idx_c);
                idx = idx_c;
                idx_c = get_Schild(idx);
            }
            else{
                break;
            }
        }

        return val;
    }

    static inline int get_parent(int idx){
        return idx / 2;
    }

    static inline int get_Lchild(int idx){
        return idx * 2;
    }

    static inline int get_Rchild(int idx){
        return (idx * 2) + 1;
    }

    int get_Schild(int idx){
        int L_c = get_Lchild(idx);
        int R_c = get_Rchild(idx);

        if(L_c > size){
            return -1;
        }
        else if(R_c > size){
            return L_c;
        }

        else{
            if(heaps[L_c] <= heaps[R_c])
                return L_c;
            
            else
                return R_c;
            
        }

    }

    void swap(int i, int j){
        int temp = heaps[i];
        heaps[i] = heaps[j];
        heaps[j] = temp;
    }



};

int main(){
    int N, val;
    scanf("%d", &N);

    Heap heap = Heap(N);

    while(N--){
        scanf("%d", &val);
        if(val == 0){
            printf("%d\n", heap.pop());
        }

        else
            heap.push(val);

    }

    return 0;
}
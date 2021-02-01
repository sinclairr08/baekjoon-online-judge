// https://www.acmicpc.net/problem/1932
// First Written : 20210104
// Last Modified : 20210104

#include <cstdio>
#include <vector>

#define MAX(X,Y) (((X) > (Y)) ? (X) : (Y))

using namespace std;

class Tri_tree{
private:
    vector<vector<int>> item;
    vector<vector<int>> max_sum;
    int size;

public:
    Tri_tree(int size){
        this->size = size;
        item.resize(size);
        max_sum.resize(size);

        for(int i = 0; i < size; i++){
            max_sum[i].resize(i + 1, 0);
        }
    }

    void add_item(int idx, int item){
        this->item[idx].push_back(item);
        return;
    }

    int max_route(int depth){
        if(depth == 0){
            max_sum[depth][0] = item[depth][0];
        }

        else{
            for(int i = 0; i <= depth; i++){
                if(i == 0){
                    max_sum[depth][i] = item[depth][i] + max_sum[depth - 1][i];
                }
                else if(i == depth){
                    max_sum[depth][i] = item[depth][i] + max_sum[depth - 1][i - 1];
                }
                else{
                    max_sum[depth][i] = MAX(item[depth][i] + max_sum[depth - 1][i],
                                            item[depth][i] + max_sum[depth - 1][i - 1]);
                }
            }
        }

        if(depth < this->size - 1)
            return max_route(depth + 1);
        
        else{
            int max = 0;
            for(int i = 0; i < this->size; i++){
                if(max_sum[this->size - 1][i] > max){
                    max = max_sum[this->size - 1][i];
                }
            }

            return max;
        }
            
        

    }

};

int main(){
    int N;
    int input;
    scanf("%d", &N);

    Tri_tree tree = Tri_tree(N);
    for(int i = 0; i < N; i++){
        for(int j = 0; j <= i; j++){
            scanf("%d", &input);
            tree.add_item(i, input);
        }
    }

    printf("%d", tree.max_route(0));


    return 0;
}
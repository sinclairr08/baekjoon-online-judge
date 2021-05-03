// https://www.acmicpc.net/problem/2623
// First Written : 20210502
// Last Modified : 20210502

#include <cstdio>
#include <vector>

using namespace std;

enum state_visit {not_vis, temp_vis, perm_vis};

class D_GRAPH{
private:
    int size;
    bool is_acyclic;
    state_visit* visited;
    vector<vector<int>> nodes;
    vector<int> results_rev;

public:
    D_GRAPH(int n){
        this->nodes.resize(n + 1);
        this->visited = new state_visit[n + 1];
        this->size = n;
        this->is_acyclic = true;
    }

    ~D_GRAPH(){
        delete [] visited;
    }

    void add_edge(int start, int end){
        nodes[start].push_back(end);
    }

    void topological_sort(){
        for(int i = 1; i <= this->size; i++){
            dfs(i);
        }
    }

    void dfs(int idx){
        if(visited[idx] == perm_vis)
            return;
        
        else if(visited[idx] == temp_vis){
            is_acyclic = false;
            return;
        }

        else{
            visited[idx] = temp_vis;
            for(int connected_idx : nodes[idx]){
                dfs(connected_idx);
            }
            visited[idx] = perm_vis;
            results_rev.push_back(idx);
            
            return;
        }
    }

    void print_result(){
        if(!is_acyclic)\
            printf("0\n");
        else{
            vector<int>::reverse_iterator rit;
            for(rit = results_rev.rbegin(); rit != results_rev.rend(); rit++)
                printf("%d\n", *rit);
        }

    }
};

int main(){
    char c;
    int graph_size, num_order, num_singer, cur_singer, prev_singer;
    scanf("%d %d", &graph_size, &num_order);
    
    D_GRAPH graph = D_GRAPH(graph_size);
    getchar();

    for(int i = 0; i < num_order; i++){
        prev_singer = 0;
        scanf("%d", &num_singer);

        for(int i = 0; i < num_singer; i++){
            scanf("%d", &cur_singer);
            if(prev_singer != 0){
                graph.add_edge(prev_singer, cur_singer);
            }
            prev_singer = cur_singer;
        }          

    }

    graph.topological_sort();
    graph.print_result();


    return 0;
}
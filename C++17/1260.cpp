// https://www.acmicpc.net/problem/1260
// First Written : 20201229
// Last Modified : 20201229

#include <cstdio>
#include <deque>

using namespace std;

struct Edge{
    int start, end;
};

class Graph{
private:
    bool** adj_list;
    deque<int> queue;
    bool* visited;
    int N_node;
    int cur_node;

public:
    Graph(int N_node){
        adj_list = new bool*[N_node + 1];
        for(int i = 1; i <= N_node; i++){
            adj_list[i] = new bool[N_node + 1]();
        }
        visited = new bool[N_node + 1]();
        this->N_node = N_node;
    }

    ~Graph(){
        for(int i = 1; i <= N_node; i++){
            delete [] adj_list[i];
        }
        delete [] adj_list;
        delete [] visited;
    }

    void init_visited(){
        delete [] visited;
        visited = new bool[this->N_node + 1]();
    }

    void add_edge(const Edge e){
        adj_list[e.start][e.end] = true;
        adj_list[e.end][e.start] = true;
    }


    void BFS(int init_node){
        queue.push_back(init_node);
        visited[init_node] = true;

        while(queue.size() != 0){
            cur_node = queue[0];
            queue.pop_front();

            printf("%d ", cur_node);

            for(int node = 1; node < this->N_node + 1; node++){
                if((!visited[node]) && adj_list[cur_node][node]){
                    visited[node] = true;
                    queue.push_back(node);
                }
            }
        }
    }

    void DFS(int cur_node){
        printf("%d ", cur_node);
        visited[cur_node] = true;

        for(int node = 1; node < this->N_node + 1; node++){
            if((!visited[node]) && adj_list[cur_node][node]){
                DFS(node);
            }
        }
    }

};

int main(){
    int N_node, N_edge, start_node;
    scanf("%d %d %d", &N_node, &N_edge, &start_node);

    Graph graph = Graph(N_node);
    Edge e;
    while(N_edge--){
        scanf("%d %d", &e.start, &e.end);
        graph.add_edge(e);
    }

    graph.DFS(start_node);
    printf("\n");
    graph.init_visited();
    graph.BFS(start_node);

    return 0;
}
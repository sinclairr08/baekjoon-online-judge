#include <cstdio>
#include <vector>
#include <deque>

using namespace std;

vector<int> dfs_result;
vector<int> bfs_result;
vector<int> is_visited;


void dfs(vector<vector<bool>> &graph, int cur_node) {
    is_visited[cur_node] = true;
    
    printf("%d ", cur_node);

    for(int adj_node = 1; adj_node < graph[cur_node].size(); adj_node++){
        if(graph[cur_node][adj_node] && !is_visited[adj_node]){
            dfs(graph, adj_node);
        }
    }

    return;
}

void bfs(vector<vector<bool>> &graph, int start_node) {
    deque<int> queue;

    is_visited[start_node] = true;
    queue.push_back(start_node);

    while(queue.size() != 0) {
        int cur_node = queue.front();
        queue.pop_front();

        printf("%d ", cur_node);

        for(int adj_node = 1; adj_node < graph[cur_node].size(); adj_node++){
            if(graph[cur_node][adj_node] && !is_visited[adj_node]){
                is_visited[adj_node] = true;
                queue.push_back(adj_node);
            }
        }

        
    }

    return;
}

int main() {
    int num_nodes, num_edges, start_node;
    int node1, node2;

    scanf("%d %d %d", &num_nodes, &num_edges, &start_node);

    vector<vector<bool>> graph(num_nodes + 1);

    for (auto &vec: graph){
        vec.assign(num_nodes + 1, false);
    }

    for(int i = 0; i < num_edges; i++){
        scanf("%d %d", &node1, &node2);
        graph[node1][node2] = true;
        graph[node2][node1] = true;
    }

    is_visited.assign(num_nodes + 1, false);
    dfs(graph, start_node);

    printf("\n");

    is_visited.assign(num_nodes + 1, false);
    bfs(graph, start_node);
    
    return 0;
}
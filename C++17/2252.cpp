// https://www.acmicpc.net/problem/2252
// First Written : 20210105
// Last Modified : 20210105

#include <cstdio>
#include <vector>

using namespace std;

struct Edge{
    int start;
    int end;
};

class DAG{
private:
    int size;
    bool* visitied;
    vector<vector<int>> nodes;

public:
    DAG(int n){
        nodes.resize(n + 1);
        visitied = new bool[n + 1]();
        this->size = n;
    }

    ~DAG(){
        delete [] visitied;
    }
    void add_edge(Edge e){
        nodes[e.end].push_back(e.start);
    }

    void topological_sort(vector<int>& result){
        for(int i = 1; i <= size; i++)
            if(!visitied[i])
                dfs(i, result);
    }

    void dfs(int idx, vector<int>& result){
        visitied[idx] = true;
        for(auto sub_idx : nodes[idx])
            if(!visitied[sub_idx])
                dfs(sub_idx, result);

        result.push_back(idx);
    }
};

int main(){
    int N, M;
    scanf("%d %d", &N, &M);

    Edge e;
    DAG graph = DAG(N);
    vector<int> result;

    while(M--){
        scanf("%d %d", &e.start, &e.end);
        graph.add_edge(e);
    }

    graph.topological_sort(result);
    for(auto it: result){
        printf("%d ", it);
    }

    return 0;
}
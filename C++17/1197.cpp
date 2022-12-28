#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

class disjoint {
public:
    vector<int> root;
    
    disjoint(int num_nodes) {
        for(int i = 0; i < num_nodes + 1; i ++){
            root.push_back(i);
        }
    }

    int find(int node) {
        // If x is a root node
        if(node == root[node]){
            return node;
        }

        root[node] = find(root[node]);
        return root[node];
    }

    // "union" is reserved word
    // If union is succeeds, return true. Otherwise false.
    bool unionset(int node1, int node2){
        int root1 = find(node1);
        int root2 = find(node2);

        if(root1 == root2) {
            return false;
        }
        else if(root1 < root2) {
            root[root2] = root1;
            return true;
        }
        else {
            root[root1] = root2;
            return true;
        }

    }

};

struct w_edge {
    int start;
    int end;
    int weight;
};

bool w_edge_compare(w_edge e1, w_edge e2) {
    return e1.weight < e2.weight;
}

int main() {
    int num_nodes, num_edges;
    int start, end, weight;
    int num_tree_edges = 0, tree_weight = 0;

    scanf("%d %d", &num_nodes, &num_edges);

    disjoint graph(num_nodes);
    vector<w_edge> edges;

    for(int i = 0; i < num_edges; i++) {
        scanf("%d %d %d", &start, &end, &weight);
        edges.push_back({start, end, weight});
    }

    sort(edges.begin(), edges.end(), w_edge_compare);

    for(auto edge: edges) {
        if(graph.unionset(edge.start, edge.end)){
            tree_weight += edge.weight;
            num_tree_edges += 1;

            if(num_tree_edges == num_nodes - 1){
                break;
            }
        }       
    }

    printf("%d", tree_weight);
    
    return 0;
}
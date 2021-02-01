// https://www.acmicpc.net/problem/1389
// First Written : 20201231
// Last Modified : 20201231

#include <cstdio>
#include <vector>

using namespace std;

struct Edge{
    int start;
    int end;
};

class Graph{
private:
    int N_node;
    vector<vector<int>> dist;
public:
    Graph(int N_user){
        dist.resize(N_user + 1);
        for(auto it = dist.begin(); it!=dist.end(); it++){
            (*it).resize(N_user + 1, 200);
        }

        for(int i = 1; i <= N_user; i++){
            dist[i][i] = 0;
        }
            
        this->N_node = N_user;
    }

    void add_edge(Edge e){
        dist[e.start][e.end] = 1;
        dist[e.end][e.start] = 1;
    }

    void floydd(){
        for(int k = 1; k <= N_node; k++){
            for(int i = 1; i <= N_node; i++){
                for(int j = 1; j <= N_node; j++){
                    if(dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
    }

    int get_kevin(){
        int min = 20000;
        int result;
        int kevin;

        for(int i = 1; i <= N_node; i++){
            result = 0;
            for(int j = 1; j <= N_node; j++){
                result += dist[i][j];
            }

            if(result < min){
                min = result;
                kevin = i;
                                
            }

        }
    
        return kevin;
    }
};

int main(){
    int N_user, N_edge;
    scanf("%d %d", &N_user, &N_edge);

    Graph graph = Graph(N_user);
    Edge e;

    while(N_edge--){
        scanf("%d %d", &e.start, &e.end);
        graph.add_edge(e);
    }

    graph.floydd();
    printf("%d", graph.get_kevin());

    return 0;
}
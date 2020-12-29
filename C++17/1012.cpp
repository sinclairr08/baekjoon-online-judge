// https://www.acmicpc.net/problem/1012
// 20201221

#include <cstdio>
#include <deque>

class Node{
public:
    int x;
    int y;

    Node(){
        x = 0;
        y = 0;
    }

    Node(int x_, int y_){
        x = x_;
        y = y_;
    }


    Node operator + (Node& n){
        x = x + n.x;
        y = y + n.y;

        return Node(x, y);
    }

    Node operator - (Node& n){
        x = x - n.x;
        y = y - n.y;

        return Node(x, y);
    }

    void print(){
        printf("%d %d\n", x, y);
    }

};

class Graph{
private:
    Node node;
    Node dir[4];
    int width, height;
    int** cabs;
    bool** visited;

    std::deque<Node> bfs_list;

public:
    int num_bug;
    Graph(int _width, int _height){
        width = _width;
        height = _height;
        num_bug = 0;

        cabs = new int*[height];
        visited = new bool*[height];
        for (int i = 0; i < height; i++){
            cabs[i] = new int[width]();
            visited[i] = new bool[width]();
        }

        dir[0] = Node(0, 1);
        dir[1] = Node(1, 0);
        dir[2] = Node(0, -1);
        dir[3] = Node(-1, 0);

    }

    ~Graph(){
        for (int i = 0; i < height; i++){
            delete [] cabs[i];
            delete [] visited[i];
        }

        delete [] cabs;
        delete [] visited;
        
    }

    void add_cab(int x, int y){
        cabs[y][x] = 1;
    }

    bool check_node(Node& n){
        if(n.x != width)
            return true;
        
        else if(n.y != height - 1){
            n.x = 0;
            n.y += 1;

            return true;
        }

        else
            return false;

    }

    bool check_boundary(Node n){
        if(n.x >= 0 && n.y >= 0 && n.x < width && n.y < height){
            return true;
        }
        
        else{
            return false;
        }
    }

    void BFS(){
        bfs_list.push_back(Node(0, 0));
        visited[0][0] = true;

        while(!bfs_list.empty()){
            node = bfs_list[0];
            bfs_list.pop_front();

            if(cabs[node.y][node.x] == 0){
                node = node + dir[1];
                
                while(check_node(node) && visited[node.y][node.x])
                    node = node + dir[1];

                if(!check_node(node))
                    break;
                
                bfs_list.push_back(node);
                visited[node.y][node.x] = true;

            }

            else{
                num_bug += 1;
                DFS(node);

                while(check_node(node) && visited[node.y][node.x])
                    node = node + dir[1];

                if(!check_node(node))
                    break;
                
                bfs_list.push_back(node);
                visited[node.y][node.x] = true;

            }

        }
    }

    void DFS(Node n){
        for(int i = 0; i < 4; i++){
            n = n + dir[i];

            if(check_boundary(n)){
                if(cabs[n.y][n.x] == 1 && (!visited[n.y][n.x])){
                    visited[n.y][n.x] = 1;

                    DFS(n);
                }

                else
                    visited[n.y][n.x] = 1;
            }
            n = n - dir[i];
        }

        return;

    }

};


int main(){
    int test_case;
    int width, height, num_cabs;
    int x, y;
    scanf("%d", &test_case);

    while(test_case--){
        scanf("%d %d %d", &width, &height, &num_cabs);
        Graph* graph = new Graph(width, height);

        while(num_cabs--){
            scanf("%d %d", &x, &y);
            graph->add_cab(x, y);
        }

        graph->BFS();
        printf("%d\n", graph->num_bug);

        delete graph;

    }

    return 0;
}
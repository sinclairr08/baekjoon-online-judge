// https://www.acmicpc.net/problem/1991
// First Written : 20210105
// Last Modified : 20210105

#include <cstdio>
#include <vector>

class Node{
private:
    char name;
public:
    Node* left;
    Node* right;
    Node* parent;

    Node(char name){
        this->left = nullptr;
        this->right = nullptr;
        this->parent = nullptr;
        this->name = name;
    }

    void add_left_c(Node* left_c){
        this->left = left_c;
        left_c->parent = this;
    }

    void add_right_c(Node* right_c){
        this->right = right_c;
    }

    inline bool is_left(){
        if(this->left)
            return true;
        
        else
            return false;
    }

    inline bool is_right(){
        if(this->right)
            return true;
        
        else
            return false;
    }

    char get_name(){
        return this->name;
    }

};

class Graph{
private:
    Node* root;

public:
    Graph(){
        Node * root_node = new Node('A');
        this->root = root_node;
    }

    Node* traverse(Node* root_node, char word){
        if(root_node->get_name() == word){
           return root_node;
        }
        else{
            Node* new_nodep;
            if(root_node->is_left()){
                new_nodep = traverse(root_node->left, word);
                if(new_nodep)
                    return new_nodep;
           }

            if(root_node->is_right()){
                new_nodep = traverse(root_node->right, word);
                if(new_nodep)
                    return new_nodep;
            }

            return nullptr;
       }
    }

    void add_item(char parent, char left, char right){
        Node* node = traverse(this->root, parent);

        if(!node){
            printf("fatal error!, %c\n", parent);
            return;
        }

        if(left != '.'){
            Node* new_lnode = new Node(left);
            node->left = new_lnode;
            new_lnode->parent = node;
        }

        if(right != '.'){
            Node* new_rnode = new Node(right);
            node->right = new_rnode;
            new_rnode->parent = node;
        }


    }

    void preorder(Node* root_node){
        printf("%c", root_node->get_name());

        if(root_node->is_left())
            preorder(root_node->left);
        
        if(root_node->is_right())
            preorder(root_node->right);
    }

    void inorder(Node* root_node){
        if(root_node->is_left())
            inorder(root_node->left);
        
        printf("%c", root_node->get_name());

        if(root_node->is_right())
            inorder(root_node->right);

    }

    void postorder(Node* root_node){
        if(root_node->is_left())
            postorder(root_node->left);

        if(root_node->is_right())
            postorder(root_node->right);

        printf("%c", root_node->get_name());
    }

    Node* get_root(){
        return this->root;
    }
};


int main(){
    int N;
    char parent, left, right;
    scanf("%d", &N);

    Graph* graph = new Graph();
    while(N--){
        scanf(" %c %c %c", &parent, &left, &right);
        graph->add_item(parent, left, right);
    }
    
    graph->preorder(graph->get_root());
    printf("\n");
    graph->inorder(graph->get_root());
    printf("\n");
    graph->postorder(graph->get_root());

    delete graph;

    return 0;
}
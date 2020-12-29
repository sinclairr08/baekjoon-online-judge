// https://www.acmicpc.net/problem/1043
// 20201222

#include <cstdio>
#include <vector>
#define MAX_SIZE 50

class Disjoint_set{
private:
    int N_items;
    int* items;
public:
    Disjoint_set(int N){
        N_items = N;
        items = new int[N_items + 1];
        for(int i = 0; i <= N_items; i++)
            items[i] = i;
    }

    ~Disjoint_set(){
        delete[] items;
    }

    void Union(int idx1, int idx2){
        int rank1 = 0, rank2 = 0;
        int root1 = Find(idx1, rank1);
        int root2 = Find(idx2, rank2);

        if(root1 == root2)
            return;

        else if (root1 == 0)
            items[root2] = items[root1];
        
        else if (root2 == 0)
            items[root1] = items[root2];
        
        else if (rank1 >= rank2)
            items[root2] = items[root1];
        
        else
            items[root1] = items[root2];
    }

    int Find(int idx, int& rank){
        if(items[idx] == idx)
            return idx;
        
        else{
            rank++;
            return Find(items[idx], rank);
        }
        
    }
};

bool belong_party(int party_person, std::vector<int> T_people){
    for(auto it = T_people.begin(); it != T_people.end(); it++){
        if((*it) == party_person){
            return true;
        }
    }

    return false;
}

int main(){
    int N_person, N_party;
    int N_Tperson, T_person;
    std::vector<int> T_people;
    int N_party_person;
    int parties[MAX_SIZE][MAX_SIZE + 1];

    scanf("%d %d", &N_person, &N_party);
    Disjoint_set DS = Disjoint_set(N_person);


    scanf("%d", &N_Tperson);

    for(int i = 0; i < N_Tperson; i++){
        scanf("%d", &T_person);
        DS.Union(0, T_person);
    }

    for(int i = 0; i < N_party; i++){
        scanf("%d", &N_party_person);

        for(int j = 0; j < N_party_person; j++){
            scanf("%d", &parties[i][j]);

            if(j != 0){
                DS.Union(parties[i][j -1], parties[i][j]);
            }
        }
        parties[i][N_party_person] = 0;

    }

    if(N_Tperson == 0){
        printf("%d\n", N_party);
        return 0;
    }

    int rank = 0;
    for(int i = 1; i <= N_person; i++){
        rank = 0;
        if(DS.Find(i, rank) == 0)
            T_people.push_back(i);
    }

    int F_party = 0;
    bool F_flag = true;

    for(int i = 0; i < N_party; i++){
        for(int j = 0; parties[i][j] != 0; j++){
            if(belong_party(parties[i][j], T_people)){
                F_flag = false;
                break;
            }


        }

        if(F_flag)
            F_party += 1;
        
        F_flag = true;

    }
    
    printf("%d\n", F_party);

    return 0;
}
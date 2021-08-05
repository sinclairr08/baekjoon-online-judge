// https://www.acmicpc.net/problem/15997
// First Written : 20210126
// Last Modified : 20210126

#include <cstdio>
#include <cstring>
#include <algorithm>

enum match_result {win = 0, tie = 1, lose = 2, none};

// Save the country names
char countries[4][11];

// Save the match results
enum match_result results[6] = {none, };

// Saves the probablity for each math
double predicts[6][3] = {.0};

// Saves the total probablity for each country
double total_probs[4] = {.0};

// Pair to sort the countires as points
std::pair<int, int> pts[4];

// Input : country pair, Output : match number
int pack(std::pair<int, int> con_pair){
    if(con_pair.first == 0 && con_pair.second == 1)
        return 0;
    else if(con_pair.first == 0 && con_pair.second == 2)
        return 1;
    else if(con_pair.first == 0 && con_pair.second == 3)
        return 2;
    else if(con_pair.first == 1 && con_pair.second == 2)
        return 3;
    else if(con_pair.first == 1 && con_pair.second == 3)
        return 4;
    else if(con_pair.first == 2 && con_pair.second == 3)
        return 5;
    else{
        exit(-1);
    }
}

// Input : match number, Output : country pair
std::pair<int, int> unpack(int idx){
    if(idx == 0)
        return std::pair<int,int>(0, 1);
    else if(idx == 1)
        return std::pair<int,int>(0, 2);
    else if(idx == 2)
        return std::pair<int,int>(0, 3);
    else if(idx == 3)
        return std::pair<int,int>(1, 2);
    else if(idx == 4)
        return std::pair<int,int>(1, 3);
    else if(idx == 5)
        return std::pair<int,int>(2, 3);
    else{
        exit(-1);
    }
}

// Initialize the points
void clear_points(){
    for(int i = 0; i < 4; i++){
        pts[i].first = i;
        pts[i].second = 0;
    }
}

// For sort function
bool pair_comp(std::pair<int, int> p1, std::pair<int, int> p2){
    return p1.second > p2.second;
}

// Set the points for each country as the result of match
void set_points(){
    std::pair<int, int> cons;
    for(int i = 0; i < 6; i++){
        cons = unpack(i);

        if(results[i] == win){
            pts[cons.first].second += 3;
        }

        else if(results[i] == tie){
            pts[cons.first].second += 1;
            pts[cons.second].second += 1;
        }

        else{
            pts[cons.second].second += 3;
        }
    }

    std::sort(pts, pts+4, pair_comp);
}

// Find index of country as its name
int find_idx_countries_as_name(char* name){
    for(int i = 0; i < 4; i++){
        if(strcmp(name, countries[i]) == 0)
            return i;
    }

    exit(-1);
}

// Use dfs for exhaustive search
void dfs(double prob, int depth){
    if(depth != 6){
        if(predicts[depth][win] != 0.0){
            results[depth] = win;
            dfs(prob * predicts[depth][win], depth + 1);
        }


        if(predicts[depth][tie] != 0.0){
            results[depth] = tie;
            dfs(prob * predicts[depth][tie], depth + 1);
        }

        if(prob != 0.0){
            results[depth] = lose;
            dfs(prob * predicts[depth][lose], depth + 1);
        }

        return;
    }

    else{
        if(prob == 0.0)
            return;
        
        clear_points();
        set_points();

        if(pts[0].second == pts[1].second && pts[1].second == pts[2].second && pts[2].second == pts[3].second){
            for(int i = 0; i < 4; i++){
                total_probs[i] += prob / 2;
            }
        }

        else if(pts[0].second == pts[1].second && pts[1].second == pts[2].second){
            total_probs[pts[0].first] += 2 * prob / 3;
            total_probs[pts[1].first] += 2 * prob / 3;
            total_probs[pts[2].first] += 2 * prob / 3;
        }
        
        else if(pts[1].second == pts[2].second && pts[2].second == pts[3].second){
            total_probs[pts[0].first] += prob;
            total_probs[pts[1].first] += prob / 3;
            total_probs[pts[2].first] += prob / 3;
            total_probs[pts[3].first] += prob / 3;
        }
        
        else if(pts[1].second == pts[2].second){
            total_probs[pts[0].first] += prob;
            total_probs[pts[1].first] += prob / 2;
            total_probs[pts[2].first] += prob / 2;
        }

        else{
            total_probs[pts[0].first] += prob;
            total_probs[pts[1].first] += prob;
        }

        return;

    }
}

int main(){
    char con_1[11];
    char con_2[11];
    int temp_idx;
    int idx_1;
    int idx_2;
    bool reversed;
    double w_r, t_r, l_r;

    for(int i = 0; i < 4; i++){
        scanf("%s", countries[i]);
    }

    for(int i = 0; i < 6; i++){
        scanf("%s", con_1);
        scanf("%s", con_2);
        scanf("%lf", &w_r);
        scanf("%lf", &t_r);
        scanf("%lf", &l_r);
        
        reversed = false;
        idx_1 = find_idx_countries_as_name(con_1);
        idx_2 = find_idx_countries_as_name(con_2);

        if(idx_2 < idx_1){
            int temp = idx_2;
            idx_2 = idx_1;
            idx_1 = temp;
            reversed = true;
        }

        temp_idx = pack(std::pair<int,int>(idx_1, idx_2));

        if(reversed){
            predicts[temp_idx][win] = l_r;
            predicts[temp_idx][tie] = t_r;
            predicts[temp_idx][lose] = w_r;
        }
        else{
            predicts[temp_idx][win] = w_r;
            predicts[temp_idx][tie] = t_r;
            predicts[temp_idx][lose] = l_r;
        }

    }

    dfs(1.0, 0);

    for(int i = 0; i < 4; i++){
        printf("%lf\n", total_probs[i]);
    }

    return 0;
}
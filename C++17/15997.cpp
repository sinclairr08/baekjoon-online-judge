// https://www.acmicpc.net/problem/15997
// First Written : 20210126
// Last Modified : 20210126

#include <cstdio>
#include <cstring>
#include <algorithm>

// 1 : ¾Õ ÆÀ ½Â¸®, 0 : ¹«½ÂºÎ, -1 : µÞ ÆÀ ½Â¸®
struct total_result{
    // 0 vs 1, 0 vs 2, 0 vs 3, 1 vs 2, 1 vs 3, 2 vs 3
    int result[6]; 
    double prob;
};

// countries
char contruies[4][11];

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
        printf("FATAL ERROR!_e2\n");
        exit(-1);
    }
}

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
        printf("FATAL ERROR!_e3\n");
        exit(-1);
    }
}

void clear_points(std::pair<int, int>* pts){
    for(int i = 0; i < 4; i++){
        pts[i].first = 0;
        pts[i].second = i;
    }
}

bool pair_comp(std::pair<int, int> p1, std::pair<int, int> p2){
    return p1.first > p2.first;
}

void get_points(int result[6], std::pair<int, int>* pts){
    std::pair<int, int> cons;
    for(int i = 0; i < 6; i++){
        cons = unpack(i);

        if(result[i] == 1){
            pts[cons.first].first += 3;
        }

        else if(result[i] == 0){
            pts[cons.first].first += 1;
            pts[cons.second].first += 1;
        }

        else{
            pts[cons.second].first += 3;
        }
    }

    std::sort(pts, pts+4, pair_comp);
}


int find_idx_contuires_as_name(char* name){
    for(int i = 0; i < 4; i++){
        if(strcmp(name, contruies[i]) == 0)
            return i;
    }

    printf("FATAL ERROR!_e1\n");
    exit(-1);

}


int main(){
    char con_1[11];
    char con_2[11];
    int temp_idx;
    int idx_1;
    int idx_2;
    bool reversed;
    double w_r, d_r, l_r;
    double predicts[6][3] = {.0};
    double total_probs[4] = {.0};

    for(int i = 0; i < 4; i++){
        scanf("%s", contruies[i]);
    }

    for(int i = 0; i < 6; i++){
        scanf("%s", con_1);
        scanf("%s", con_2);
        scanf("%lf", &w_r);
        scanf("%lf", &d_r);
        scanf("%lf", &l_r);
        
        reversed = false;
        idx_1 = find_idx_contuires_as_name(con_1);
        idx_2 = find_idx_contuires_as_name(con_2);

        if(idx_2 < idx_1){
            int temp = idx_2;
            idx_2 = idx_1;
            idx_1 = temp;
            reversed = true;
        }

        temp_idx = pack(std::pair<int,int>(idx_1, idx_2));

        if(!reversed){
            predicts[temp_idx][0] = l_r;
            predicts[temp_idx][1] = d_r;
            predicts[temp_idx][2] = w_r;
        }
        else{
            predicts[temp_idx][0] = w_r;
            predicts[temp_idx][1] = d_r;
            predicts[temp_idx][2] = l_r;
        }

    }

    total_result results[729];
    int cnt = 0;
    double temp_prob;
    for(int i1 = -1; i1 <= 1; i1++){
    for(int i2 = -1; i2 <= 1; i2++){
    for(int i3 = -1; i3 <= 1; i3++){
    for(int i4 = -1; i4 <= 1; i4++){
    for(int i5 = -1; i5 <= 1; i5++){
    for(int i6 = -1; i6 <= 1; i6++){
        results[cnt].result[0] = i1;
        results[cnt].result[1] = i2;
        results[cnt].result[2] = i3;
        results[cnt].result[3] = i4;
        results[cnt].result[4] = i5;
        results[cnt].result[5] = i6;

        temp_prob = 1;
        for(int i = 0; i < 6; i++){
            //Áï, i¹øÂ° ¸ÅÄ¡ÀÇ °á°ú¿¡ µû¶ó ½Â·üÀ» predict¿¡¼­ °¡Á®¿Â ÈÄ ±× °ªÀ» °öÇØÁÜ
            temp_prob *= predicts[i][results[cnt].result[i] + 1];
        }

        results[cnt++].prob = temp_prob;
    }
    }
    }
    }
    }
    }

    std::pair<int, int> pts[4];
    double cur_prob;
    for(int i = 0; i < 729; i++){
        cur_prob = results[i].prob;
        if(cur_prob == 0.0)
            continue;
        
        clear_points(pts);
        get_points(results[i].result, pts);

        if(pts[0].first == pts[1].first && pts[1].first == pts[2].first && pts[2].first == pts[3].first){
            for(int i = 0; i < 4; i++){
                total_probs[i] += cur_prob / 2;
            }
        }

        else if(pts[0].first == pts[1].first && pts[1].first == pts[2].first){
            total_probs[pts[0].second] += 2 * cur_prob / 3;
            total_probs[pts[1].second] += 2 * cur_prob / 3;
            total_probs[pts[2].second] += 2 * cur_prob / 3;
        }
        
        else if(pts[1].first == pts[2].first && pts[2].first == pts[3].first){
            total_probs[pts[0].second] += cur_prob;
            total_probs[pts[1].second] += cur_prob / 3;
            total_probs[pts[2].second] += cur_prob / 3;
            total_probs[pts[3].second] += cur_prob / 3;
        }
        
        else if(pts[1].first == pts[2].first){
            total_probs[pts[0].second] += cur_prob;
            total_probs[pts[1].second] += cur_prob / 2;
            total_probs[pts[2].second] += cur_prob / 2;
        }

        else{
            total_probs[pts[0].second] += cur_prob;
            total_probs[pts[1].second] += cur_prob;
        }

    }

    for(int i = 0; i < 4; i++){
        printf("%lf\n", total_probs[i]);
    }

    return 0;
}
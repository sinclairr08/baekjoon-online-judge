#include <cstdio>
#include <vector>
#include <deque>

using namespace std;

struct way {
    int hor;
    int ver;
    int diag;
    bool visited;

    int sum_all(){
        return hor + ver + diag;
    }
};

vector<vector<int>> arr;
vector<vector<way>> res;

way dp(int x, int y){
    way prev_hor, prev_ver, prev_diag;
    int cur_hor = 0, cur_ver = 0, cur_diag = 0;

    if(res[x][y].visited){
        return res[x][y];
    }

    if(arr[x][y]){
        res[x][y].visited = true;
        return res[x][y];
    }

    if(y - 1 >= 0 && arr[x][y - 1] == 0){
        prev_hor = dp(x, y - 1);
        cur_hor = prev_hor.hor + prev_hor.diag;
    }

    if(x - 1 >= 0 && arr[x - 1][y] == 0){
        prev_ver = dp(x - 1, y);
        cur_ver = prev_ver.ver + prev_ver.diag;
    }
    
    if(x - 1 >= 0 && y - 1 >= 0 && (arr[x][y - 1] + arr[x - 1][y] + arr[x - 1][y - 1] ) == 0){
        prev_diag = dp(x - 1, y - 1);
        cur_diag = prev_diag.diag + prev_diag.hor + prev_diag.ver;
    }

    res[x][y] = {cur_hor, cur_ver, cur_diag, true};
    return res[x][y];
}

int main() {
    int size, val;

    scanf("%d", &size);

    arr.resize(size);
    res.resize(size);

    for(int i = 0; i < size; i++){
        arr[i].resize(size);
        res[i].resize(size);

        for(int j = 0; j < size; j++){
            scanf("%d", &val);
            arr[i][j] = val;
            res[i][j] = {0, 0, 0, false};
        }
    }

    res[0][0] = {0, 0, 0, true};
    res[0][1] = {1, 0, 0, true};

    printf("%d\n", dp(size - 1, size - 1).sum_all());

    return 0;
}
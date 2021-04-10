// https://www.acmicpc.net/problem/2239
// First Written : 20210405
// Last Modified : 20210410

#include <cstdio>
#include <vector>

int arr[9][9] = {0};
bool is_finished = false;

// Get every valid candidates on the current block
std::vector<int> get_candidates(int row, int col){
    std::vector<int> candidates;
    bool not_visitable[10] = {0};
    
    int box_row = ((row / 3) * 3);
    int box_col = ((col / 3) * 3);

    // Remove invalid numbers
    for(int i = 0; i < 9; i++){
        if(arr[row][i] != 0){
            not_visitable[arr[row][i]] = true;
        }
        if(arr[i][col] != 0){
            not_visitable[arr[i][col]] = true;
        }
        if(arr[box_row + (i / 3)][box_col + (i % 3)] != 0){
            not_visitable[arr[box_row + (i / 3)][box_col + (i % 3)]] = true;
        }
    }

    for(int i = 1; i <= 9; i++){
        if(!not_visitable[i])
            candidates.push_back(i);
    }
    
    return candidates;
}

// Use backtracking to fill sudoku
void backtrack(int depth){
    // When the sudoku is filled, finish the function
    if(depth == 81){
        is_finished = true;
        return;
    }

    int row = depth / 9;
    int col = depth % 9;


    // If current block is not blank, then move to next block
    if(arr[row][col] != 0){
        backtrack(depth+1);
        return;
    }

    else{
        std::vector<int> candidates = get_candidates(row, col);

        // Repeat every possible values
        for(auto i : candidates){
            arr[row][col] = i;

            backtrack(depth+1);

            if(is_finished)
                return;
            
            arr[row][col] = 0;
        }
        
        return;

    }

}

int main(){
    for(int i = 0; i < 9; i++){
        for(int j = 0; j < 9; j++){
            scanf("%c", &arr[i][j]);
            arr[i][j] -= '0';
        }
        getchar();
    }

    backtrack(0);

    for(int i = 0; i < 9; i++){
        for(int j = 0; j < 9; j++){
            printf("%d", arr[i][j]);
        }
        printf("\n");
    }

    return 0;
}
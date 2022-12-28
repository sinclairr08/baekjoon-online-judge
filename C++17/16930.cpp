#include <iostream>
#include <vector>
#include <deque>
#include <string>

using namespace std;

struct location {
    int x;
    int y;
};

struct location_info {
    bool is_visited;
    int time;
    int start_step[4];
};

bool is_boundary(int x, int y, int max_x, int max_y){
    if (x > max_x || y > max_y || x < 1 || y < 1){
        return false;
    }
    return true;
}

location_info infos[1002][1002] = {false, 0, {0, 0, 0, 0}};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int dir_x[4] = {1, 0, 0, -1};
    int dir_y[4] = {0, 1, -1, 0};

    int height, width, max_step;
    int start_x, start_y, end_x, end_y;
    int cur_x, cur_y, new_x, new_y;

    location cur_location;
    location_info cur_info;

    deque<location> queue;

    cin >> height >> width >> max_step;

    string wall;
    vector<string> walls(height + 1);

    for(int i = 0 ; i <= height; i++){
        // First line is '\n'
        getline(cin, wall); 
        walls[i] = "#" + wall;
    }
   
    cin >> start_x >> start_y >> end_x >> end_y;
    
    infos[start_x][start_y].is_visited  = true;
    queue.push_back({start_x, start_y}); 

    while(queue.size() > 0) {
        cur_location = queue.front();
        cur_x = cur_location.x;
        cur_y = cur_location.y;

        cur_info = infos[cur_x][cur_y];
        queue.pop_front();

        for(int d = 0; d < 4; d++){
            if(cur_info.start_step[d] == -1) continue;
            for(int step = 1 + cur_info.start_step[d]; step <= max_step; step++){
                new_x = cur_x + step * dir_x[d];
                new_y = cur_y + step * dir_y[d];

                if(new_x == end_x && new_y == end_y){
                    cout << cur_info.time + 1;
                    return 0;
                }

                if(!is_boundary(new_x, new_y, height, width) || walls[new_x][new_y] == '#') {
                    while(step > 1 + cur_info.start_step[d]){
                        step--;
                        new_x = cur_x + step * dir_x[d];
                        new_y = cur_y + step * dir_y[d];

                        infos[new_x][new_y].start_step[d] = -1;                        
                    }

                    break;
                }
                
                // Change start step
                infos[new_x][new_y].start_step[d] = max_step - step;

                // Do not goes to backward
                infos[new_x][new_y].start_step[3 - d] = -1;

          
                if(!infos[new_x][new_y].is_visited){
                    infos[new_x][new_y].is_visited = true;
                    infos[new_x][new_y].time = cur_info.time + 1;
                    queue.push_back({new_x, new_y});
                }
            }
        }


    }

    cout << -1;
    
    return 0;
}



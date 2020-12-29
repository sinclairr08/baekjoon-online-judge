// https://www.acmicpc.net/problem/1002
// 20201219

#include <cstdio>

int find_intersect(int diff, int r_1, int r_2){
    int rdiff = (r_1 - r_2) * (r_1 - r_2);
    int rsum = (r_1 + r_2) * (r_1 + r_2);

    if(rdiff > diff)
        return 0;
    
    else if(rdiff == diff){
        if(diff == 0)
            return-1;
        else
            return 1;
    }

    else if(diff > rsum)
        return 0;    
        
    else if(diff == rsum)
        return 1;
    
    else if(diff < rsum)
        return 2;
    
    return 0;

}

int main(){
    int Test_case;
    int x_1, x_2, y_1, y_2, r_1, r_2;
    int diff;
    scanf("%d", &Test_case);

    while(Test_case--){
        scanf("%d %d %d %d %d %d", &x_1, &y_1, &r_1, &x_2, &y_2, &r_2);

        diff = ((x_1 - x_2) * (x_1 - x_2)) +((y_1 - y_2) * (y_1 - y_2));
        printf("%d\n", find_intersect(diff, r_1, r_2));
    }

    return 0;
}
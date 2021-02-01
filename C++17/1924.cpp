// https://www.acmicpc.net/problem/1924
// First Written : 20210101
// Last Modified : 20210101

#include <cstdio>
int months[12] = {
    31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
};
char months_name[7][4] = {
    "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"
};

int main(){
    int month, day;
    int sum = 0;
    scanf("%d %d", &month, &day);

    for(int i = 0; i < month - 1; i++){
        sum += months[i];
    }
    sum += day;

    printf("%s", months_name[sum % 7]);

    return 0;
}
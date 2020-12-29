// https://www.acmicpc.net/problem/1019
// 20201218

#include <cstdio>
#include <vector>
#include <cstring>

#define MAX_EXP 10

using namespace std;

int main(){
    int exp_of_10[MAX_EXP + 1];
    int digits_under_exp_of_10[MAX_EXP + 1];
    int zero_under_exp_of_10[MAX_EXP + 1];

    int digits[10] = { 0 };
    int number_list[11];
    int base = 1;

    for(int exp = 0; exp <= MAX_EXP; exp++){
        exp_of_10[exp] = base;
        digits_under_exp_of_10[exp] = base * (exp + 1);
        if(exp == 0)
            zero_under_exp_of_10[exp] = 1;
        else
            zero_under_exp_of_10[exp] = exp_of_10[exp] - exp_of_10[exp - 1];
        
        base *= 10;
    }

    int input_N, copied_N, cut_N;
    int digit, cnts, max_exp = 0;
    int i = 0, idx;
    scanf("%d", &input_N);

    copied_N = input_N;
    while(copied_N != 0){
        digit = copied_N - ((copied_N / 10) * 10);
        memmove(number_list + 1, number_list, (sizeof(int) * (i++)));
        number_list[0] = digit;

        digits[digit] += 1;
        copied_N /= 10;
        max_exp++;
    }


    for(int exp = 0; exp < max_exp; exp++){
        cnts = input_N % exp_of_10[exp + 1];
        if(cnts == 0)
            continue;

        cut_N = input_N - cnts;

        idx = max_exp - exp - 1;
        for(int j = 0; j < idx; j++)
            digits[number_list[j]] += cnts;
        
        for(int j = 0; j < number_list[idx]; j++)
            digits[j] += exp_of_10[exp];
        
        if(exp != 0){
            for(int j = 0; j < 10; j++)
                digits[j] += digits_under_exp_of_10[exp - 1] * number_list[idx];
            
        }

        input_N = cut_N;

    }

    int leading_zero = 0;

    for(int exp = 0; exp < max_exp; exp++){
        leading_zero += ((exp + 1) * (zero_under_exp_of_10[max_exp - exp - 1]));
    }

    digits[0] -= leading_zero;

    for(int j = 0; j < 10; j++)
        printf("%d ", digits[j]);

    return 0;
}
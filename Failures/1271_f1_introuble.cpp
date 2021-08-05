// https://www.acmicpc.net/problem/1271
// First Written : 20201230
// Last Modified : 20201230

#include <cstdio>
#include <cstring>
#include <utility>
#define MAX_LEN 1002

using namespace std;

class LargeUInt{
private:
    int* digits;
    int n_digit;

public:
    LargeUInt(int n_digit){
        digits = new int[MAX_LEN]();
        this->n_digit = n_digit;
    }

    LargeUInt(const LargeUInt& l, int n_digit){
        digits = new int[MAX_LEN]();

        int diff = n_digit - l.n_digit;
        memmove(this->digits + diff, l.digits, sizeof(int)*(l.n_digit));

        this->n_digit = n_digit;
    }

    LargeUInt(char * input, int n_digit){
        digits = new int[MAX_LEN]();

        for(int i = 0; i < n_digit; i++){
            digits[i] = (int)(input[i] - '0');
        }

        this->n_digit = n_digit;
    }

    ~LargeUInt(){
        delete [] digits;
    }

    bool operator > (const LargeUInt& l){
        if(this->n_digit != l.n_digit){
            return this->n_digit > l.n_digit;
        }

        else{
            for(int i = 0; i < this->n_digit; i++){
                if(this->digits[i] != l.digits[i])
                    return this->digits[i] > l.digits[i];
            }
            return false;
            
        }

    }
    
    LargeUInt operator - (const LargeUInt& l){
        LargeUInt cop_int = LargeUInt(*this, n_digit);
        LargeUInt sub_int = LargeUInt(l, n_digit);
        LargeUInt new_int = LargeUInt(n_digit);
        int upp_idx;

        for(int i = n_digit - 1; i >= 0; i--){
            if(cop_int.digits[i] >= sub_int.digits[i]){
                new_int.digits[i] = cop_int.digits[i] - sub_int.digits[i];
            }

            else{
                new_int.digits[i] = 10 + cop_int.digits[i] - sub_int.digits[i];
                upp_idx = 1;
                while (cop_int.digits[i - upp_idx] == 0 && i - upp_idx > 0)
                    cop_int.digits[i - (upp_idx++)] = 9;
                
                cop_int.digits[i - upp_idx]--;
                
            }
        }

        new_int.delete_leading_zeros();
        return new_int;
    }

    pair<LargeUInt, LargeUInt>  operator/ (const LargeUInt& l){
        LargeUInt quotient = LargeUInt(0);
        LargeUInt remainder = LargeUInt(*this, n_digit);


        while(remainder > l){
            ++quotient;
        }

        pair<LargeUInt, LargeUInt> division = 
                            make_pair(quotient, remainder);

        return division;
    }

    LargeUInt& operator++(){
        if(n_digit == 0){
            n_digit++;
            digits[0] = 1;
        }
        else{
            int idx = this->n_digit - 1;
            while(this->digits[idx] == 9 && idx > 0){
                this->digits[idx--] = 0;
            }

            this->digits[idx]++;
            if(this->digits[idx] == 10){
                this->digits[idx] = 0;
                memmove(this->digits + 1, this->digits, sizeof(int)*(n_digit));
                this->digits[0] = 1;
                n_digit++;
            }
        }

        return *this;
    }

    void delete_leading_zeros(){
        if(this->n_digit == 0)
            return;
        
        else{
            int n_leading_zero = 0;
            while(this->digits[n_leading_zero] == 0)
                n_leading_zero++;
            
            memmove(this->digits, this->digits + n_leading_zero, sizeof(int)*(this -> n_digit - n_leading_zero));
        }
    }

    void print(){
        for(int i = 0; i < this->n_digit; i++){
            printf("%d", this->digits[i]);
        }
        printf("\n");
    }

};

int main(){
    char money[MAX_LEN];
    char person[MAX_LEN];

    scanf("%s", money);
    scanf("%s", person);
    
    LargeUInt mon = LargeUInt(money, strlen(money));
    LargeUInt per = LargeUInt(person, strlen(person));

    pair<LargeUInt, LargeUInt> division = mon / per;
    division.first.print();
    division.second.print(); 

    return 0;
}
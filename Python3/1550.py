# https://www.acmicpc.net/problem/1550
# 20200421

import sys

dict_16 = {
    'A' : 10,
    'B' : 11,
    'C' : 12,
    'D' : 13,
    'E' : 14,
    'F' : 15
}

def Decimal_change(str_16):
    conv_num = 0
    base = 1
    split = []
    for i in str_16:
        if i > '9':
            i = dict_16[i]
        else:
            i = int(i)
        split.append(i)

    split.reverse()
    for digit in split:
        conv_num += base * digit
        base *= 16

    return conv_num

str_16 = sys.stdin.readline().strip()
num_10 = Decimal_change(str_16)

sys.stdout.write(str(num_10))

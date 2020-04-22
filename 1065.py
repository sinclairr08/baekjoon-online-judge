#https://www.acmicpc.net/problem/1065
# 20200422

import sys

def is_han(num):
    digit_3 = num // 100
    digit_2 = (num // 10) - (digit_3 * 10)
    digit_1 = num % 10

    return True if (digit_3 - digit_2) == (digit_2 - digit_1) else False


num = int(sys.stdin.readline().rstrip())

if num <= 99:
    sys.stdout.write(str(num))

else:
    han_num = 99
    while num > 99:
        if is_han(num):
            han_num += 1
        num -= 1
    sys.stdout.write(str(han_num))





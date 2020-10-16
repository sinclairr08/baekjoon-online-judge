#https://www.acmicpc.net/problem/2577
# 20200510

import sys

def cnt_digit(num):
    digits = [0] * 10

    if num == 0:
        digits[0] += 1
        return digits

    while num != 0:
        digits[num%10] += 1
        num //= 10

    return digits


a = int(sys.stdin.readline().rstrip())
b = int(sys.stdin.readline().rstrip())
c = int(sys.stdin.readline().rstrip())

digits = cnt_digit(a * b * c)
for i in digits:
    print(i)

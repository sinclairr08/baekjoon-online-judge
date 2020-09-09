#https://www.acmicpc.net/problem/8958
# 20200909

import sys

def calc_score(str):
    total = 0
    O_stack = 0

    for char in str:
        if char == 'O':
            O_stack += 1
            total += O_stack
        else:
            O_stack = 0

    return total


N = int(sys.stdin.readline())

for i in range(N):
    str = sys.stdin.readline().rstrip()
    print(calc_score(str))


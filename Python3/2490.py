#https://www.acmicpc.net/problem/2490
# 20200426

import sys

def yut(yut_list):
    if sum(yut_list) == 3:
        return 'A'
    elif sum(yut_list) == 2:
        return 'B'
    elif sum(yut_list) == 1:
        return 'C'
    elif sum(yut_list) == 0:
        return 'D'
    elif sum(yut_list) == 4:
        return 'E'


for _ in range(3):
    yut_list = list(map(int, sys.stdin.readline().split()))
    print(yut(yut_list))

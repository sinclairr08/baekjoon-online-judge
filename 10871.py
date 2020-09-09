#https://www.acmicpc.net/problem/10871
# 20200909

import sys

N, max = map(int, sys.stdin.readline().split())

seq = list(map(int, sys.stdin.readline().split()))

for num in seq:
    if num < max:
        print(num, end = ' ')

#https://www.acmicpc.net/problem/2439
# 20200426

import sys

N = int(sys.stdin.readline().rstrip())

for i in range(1, N + 1):
    print(" " * (N - i), end = '')
    print("*" * (i))
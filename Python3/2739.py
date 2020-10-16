#https://www.acmicpc.net/problem/2739
# 20200510

import sys

N = int(sys.stdin.readline().rstrip())

for i in range(1, 10):
    print("{} * {} = {}".format(N, i, N * i))
#https://www.acmicpc.net/problem/11720
# 20200909

import sys

N = int(sys.stdin.readline())
seq = sys.stdin.readline().rstrip()
total = 0

for num in seq:
    total += int(num)

print(total)


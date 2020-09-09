#https://www.acmicpc.net/problem/10817
# 20200909

import sys

a, b, c = map(int, sys.stdin.readline().split())

print(a + b + c - max(max(a,b),c) - min(min(a,b),c))

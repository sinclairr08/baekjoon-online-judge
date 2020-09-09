#https://www.acmicpc.net/problem/10430
# 20200909

import sys

a, b, c = map(int, sys.stdin.readline().split())

print((a + b) % c)
print(((a % c) + (b % c)) % c)
print((a * b) % c)
print(((a % c) * (b % c)) % c)

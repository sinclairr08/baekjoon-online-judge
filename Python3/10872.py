#https://www.acmicpc.net/problem/10872
# 20200909

import sys

def factorial(N):
    base = 1
    for i in range(1, N + 1):
        base *= i

    return base


N = int(sys.stdin.readline())

print(factorial(N))
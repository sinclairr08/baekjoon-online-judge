#https://www.acmicpc.net/problem/2588
# 20200510

import sys

a = int(sys.stdin.readline().rstrip())
b = int(sys.stdin.readline().rstrip())

num = b

while num != 0:
    last = num % 10
    print(a * last)

    num //= 10

print(a * b)


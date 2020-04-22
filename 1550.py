#https://www.acmicpc.net/problem/1550
# 20200421

import sys

money, person = map(int, sys.stdin.readline().split())

each = money // person
rest = money % person

print(each)
print(rest)
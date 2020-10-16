#https://www.acmicpc.net/problem/2292
# 20200426

import sys

def find_room(N):
    if N == 1:
        return 1

    else:
        N -= 1
        radius = 1

        while N > 0:
            N -= radius * 6
            radius += 1

        return radius

N = int(sys.stdin.readline().rstrip())
print(find_room(N))


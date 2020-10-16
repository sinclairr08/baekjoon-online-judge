#https://www.acmicpc.net/problem/1002
# 20200430

import sys

def find_connection(dist, r1, r2):
    rdiff = (r1 - r2) if r1 >= r2 else (r2 - r1)
    rdiff = rdiff ** 2
    rsum = (r1 + r2) ** 2

    if dist < rdiff:
        return 0

    elif dist == rdiff:
        if dist == 0:
            return -1
        else:
            return 1

    elif rsum > dist:
        return 2

    elif rsum == dist:
        return 1

    elif rsum < dist:
        return 0



N = int(sys.stdin.readline().rstrip())

for _ in range(N):
    x1, y1, r1, x2, y2, r2 = map(int, sys.stdin.readline().split())
    dist = ((x1 - x2) ** 2) + ((y1 - y2) ** 2)
    print(find_connection(dist, r1, r2))

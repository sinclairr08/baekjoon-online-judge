# https://www.acmicpc.net/problem/18111
# 20201016

import sys

N, M, B = map(int, sys.stdin.readline().split())

def calc_blocks(blocks, height):
    cost = 0
    req_block = 0

    for i in range(N):
        for j in range(M):
            D = blocks[i][j] - height

            if D > 0:
                cost += 2 * D
                req_block -= D
            elif D < 0:
                cost -= D
                req_block -= D

    return cost, req_block

blocks = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

max_H = max(map(max, blocks))
min_H = min(map(min, blocks))

smallest_cost = calc_blocks(blocks, min_H)[0]
smallest_H = min_H
buffer = -1

while min_H < max_H:
    mid_H = (min_H + max_H) // 2 + (min_H + max_H) % 2
    if mid_H == buffer:
        min_H += 1
        buffer = -1

    cost, req_block = calc_blocks(blocks, mid_H)

    if req_block > B or cost > smallest_cost:
        max_H = mid_H - 1
        buffer = -1

    else:
        smallest_cost = cost
        smallest_H = mid_H
        min_H += 1
        buffer = mid_H

print(smallest_cost, smallest_H)
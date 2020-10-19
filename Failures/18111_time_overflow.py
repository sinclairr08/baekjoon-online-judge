# https://www.acmicpc.net/problem/18111
# 20201016

import sys


def calc_blocks(blocks, height):
    cost = 0
    req_block = 0

    for block in blocks:
        D = block - height

        if D > 0:
            cost += 2 * D
            req_block -= D
        elif D < 0:
            cost -= D
            req_block -= D

    return cost, req_block

N, M, B = map(int, sys.stdin.readline().split())

blocks = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

max_H = max(map(max, blocks))
min_H = min(map(min, blocks))
smallest_cost = 999999999
smallest_H = 0

flattened = sum(blocks, [])


for H in range(min_H, max_H + 1):
    cost, req_block = calc_blocks(flattened, H)

    if req_block > B:
        continue

    elif cost <= smallest_cost:
            smallest_cost = cost
            smallest_H = H

print(smallest_cost, smallest_H)












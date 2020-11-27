# https://www.acmicpc.net/problem/1007
# 20201127

import sys
import math

MAX_VAL = 2e18


def combination(idx, grid, is_minus, N, optimal, total_x, total_y):
    if sum(is_minus) == N // 2:
        for idx in range(N):
            if is_minus[idx]:
                total_x -= 2 * grid[idx][0]
                total_y -= 2 * grid[idx][1]

        res = (total_x ** 2) + (total_y ** 2)
        if res < optimal:
            optimal = res

        return optimal

    elif idx == N:
        return optimal

    else:
        is_minus[idx] = True
        optimal = combination(idx + 1, grid, is_minus, N, optimal, total_x, total_y)
        is_minus[idx] = False
        optimal = combination(idx + 1, grid, is_minus, N, optimal, total_x, total_y)

        return optimal


if __name__ == "__main__":
    T = int(sys.stdin.readline().rstrip())

    for _ in range(T):
        N = int(sys.stdin.readline().rstrip())
        grid = [list(map(int, sys.stdin.readline().split())) for n in range(N)]

        total_x, total_y = sum(g[0] for g in grid), sum(g[1] for g in grid)
        is_minus = [False] * N

        res = combination(0, grid, is_minus, N, MAX_VAL, total_x, total_y)
        print(math.sqrt(res))


        del grid


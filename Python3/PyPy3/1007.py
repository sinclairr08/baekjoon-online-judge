# https://www.acmicpc.net/problem/1007
# 20201127

import sys
import math

from itertools import combinations

MAX_VAL = 2e18

if __name__ == "__main__":
    T = int(sys.stdin.readline().rstrip())

    for _ in range(T):
        N = int(sys.stdin.readline().rstrip())
        grid = [list(map(int, sys.stdin.readline().split())) for n in range(N)]

        total_x, total_y = sum(g[0] for g in grid), sum(g[1] for g in grid)

        optimal_len = MAX_VAL

        total_index = list(range(N))
        comb_index = list(combinations(total_index, N // 2))

        for comb in comb_index:
            cur_x = total_x
            cur_y = total_y
            minus_indicies = list(comb)
            for min_idx in minus_indicies:
                cur_x -= 2 * grid[min_idx][0]
                cur_y -= 2 * grid[min_idx][1]

            res = (cur_x ** 2) + (cur_y ** 2)
            if res < optimal_len:
                optimal_len = res


        del grid
        print(math.sqrt(optimal_len))

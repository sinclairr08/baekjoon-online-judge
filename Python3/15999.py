# https://www.acmicpc.net/problem/15999
# 20201126

import sys

DIV = 1000000007


def exponent_2(exp):
    if exp == 0:
        return 1
    else:
        res = exponent_2(exp // 2)
        res = res * res

        if exp % 2 != 0:
            res *= 2

        return res % DIV


if __name__ == "__main__":
    N, M = map(int, sys.stdin.readline().split())
    grid = []

    for _ in range(N):
        line = sys.stdin.readline().rstrip()
        grid.append([1 if i == 'W' else 0 for i in line])

    indep_cnt = 0

    for i in range(N):
        for j in range(M):
            val = grid[i][j]

            if i != 0 and val != grid[i-1][j]:
                continue

            elif j != 0 and val != grid[i][j-1]:
                continue

            elif i != N -1 and val != grid[i+1][j]:
                continue

            elif j != M -1 and val != grid[i][j+1]:
                continue

            indep_cnt += 1

    print(exponent_2(indep_cnt))




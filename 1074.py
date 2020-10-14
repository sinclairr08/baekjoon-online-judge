# https://www.acmicpc.net/problem/1074
# 20201013

import sys

def Z_calc(r, c, N_, index):
    if N_ == 1:
        return index
    N_ //= 2

    if r > N_:
        r -= N_
        index += (N_ ** 2) * 2

    if c > N_:
        c -= N_
        index += (N_ ** 2)

    return Z_calc(r, c, N_, index)

N, r, c = map(int, sys.stdin.readline().split())

print(Z_calc(r + 1, c + 1, N_ = 2 ** N, index=0))



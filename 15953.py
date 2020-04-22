# https://www.acmicpc.net/problem/15953
# 20200408

import sys

def _1st_prize(rank):
    if rank == 0:
        return 0

    crit = 1
    prizes = [5000000, 3000000, 2000000, 500000, 300000, 100000]
    while crit <= 6:
        if rank <= crit:
            return prizes[crit - 1]
        else:
            rank -= crit
            crit += 1

    return 0

def _2nd_prize(rank):
    if rank == 0:
        return 0

    crit = 0
    prizes = [5120000, 2560000, 1280000, 640000, 320000]
    while crit <= 4:
        if rank <= 2 ** crit:
            return prizes[crit]
        else:
            rank -= 2 ** crit
            crit += 1

    return 0

T = int(sys.stdin.readline())

for _ in range(T):
    r1, r2 = map(int, sys.stdin.readline().split())
    print(_1st_prize(r1) + _2nd_prize(r2))



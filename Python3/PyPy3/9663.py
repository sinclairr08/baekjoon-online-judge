# https://www.acmicpc.net/problem/9663
# 20201101

import sys

N = int(sys.stdin.readline().rstrip())
v_visits = [0] * N
ld_visits = [0] * (2 * N - 1)
rd_visits = [0] * (2 * N - 1)


def next_candidates(depth):
    candidates = []

    for j in range(N):
        if v_visits[j] == 1:
            continue
        if ld_visits[j - depth + N - 1] == 1:
            continue
        if rd_visits[j + depth] == 1:
            continue

        candidates.append(j)

    return candidates


def backtrack(depth, total):
    if depth == N:
        return total + 1

    else:
        candidates = next_candidates(depth)

        for j in candidates:
            v_visits[j] = 1
            ld_visits[(j - depth + N - 1)] = 1
            rd_visits[j + depth] = 1

            total = backtrack(depth + 1, total)

            v_visits[j] = 0
            ld_visits[(j - depth + N - 1)] = 0
            rd_visits[j + depth] = 0

        del candidates
        return total


print(backtrack(0, 0))
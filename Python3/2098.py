# https://www.acmicpc.net/problem/2098
# 20201103

import sys

MAX_VAL = 999999999

N_cities = int(sys.stdin.readline().rstrip())
N_visitied = (2 ** N_cities)

weights = [list(map(int, sys.stdin.readline().split())) for _ in range(N_cities)]
optimal = [[0] * N_visitied for _ in range(N_cities)]


def not_visited(visited):
    n_visited = []

    for i in range(N_cities):
        if visited % 2 == 0:
            n_visited.append(i)
        visited //= 2

    return n_visited


def TSP(current, visited):
    visited += (2 ** current)

    if visited == N_visitied - 1:
        if weights[current][0] == 0:
            return MAX_VAL
        else:
            return weights[current][0]

    else:
        if optimal[current][visited] != 0:
            return optimal[current][visited]

        min_weight = MAX_VAL

        for city in not_visited(visited):
            if weights[current][city] == 0:
                continue
            cur_weight = TSP(city, visited) + weights[current][city]

            if cur_weight < min_weight:
                min_weight = cur_weight

        optimal[current][visited] = min_weight
        return min_weight


print(TSP(0, 0))




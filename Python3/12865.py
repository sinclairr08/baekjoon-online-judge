# https://www.acmicpc.net/problem/12865
# 20201126

import sys

if __name__ == "__main__":
    N, max_load = map(int, sys.stdin.readline().split())

    dp = [[None] * (max_load + 1) for _ in range(N + 1)]

    weights = [0]
    values = [0]

    for _ in range(N):
        weight, value = map(int, sys.stdin.readline().split())

        weights.append(weight)
        values.append(value)

    for idx in range(N + 1):
        cur_weight = weights[idx]
        cur_value = values[idx]

        for load in range(max_load + 1):
            if idx == 0 or load == 0:
                dp[idx][load] = 0
                continue

            elif cur_weight > load:
                dp[idx][load] = dp[idx - 1][load]

            else:
                dp[idx][load] = max(dp[idx - 1][load],
                                    dp[idx - 1][load - cur_weight] + cur_value)


    print(dp[N][max_load])


# https://www.acmicpc.net/problem/1463
# 20201024

import sys

input_N = int(sys.stdin.readline().rstrip())
optimal_list = [0, 0]

for n in range(2, input_N + 1):
    res = optimal_list[n - 1]

    if n % 3 == 0:
        temp = optimal_list[n // 3]
        if temp < res:
            res = temp

    if n % 2 == 0:
        temp = optimal_list[n // 2]
        if temp < res:
            res = temp

    optimal_list.append(res + 1)

print(optimal_list[input_N])

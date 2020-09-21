# https://www.acmicpc.net/problem/1149
# 20200917

import sys

N = int(sys.stdin.readline().rstrip())
colors = []
sum_colors = []


for i in range(N):
    color = list(map(int, sys.stdin.readline().split()))
    colors.append(color)
    sum_colors.append([0] * 3)

sum_colors[0] = colors[0]
for i in range(1, N):
    sum_colors[i][0] =\
        min(sum_colors[i - 1][1] + colors[i][0], sum_colors[i - 1][2] + colors[i][0])
    sum_colors[i][1] = \
        min(sum_colors[i - 1][0] + colors[i][1], sum_colors[i - 1][2] + colors[i][1])
    sum_colors[i][2] = \
        min(sum_colors[i - 1][0] + colors[i][2], sum_colors[i - 1][1] + colors[i][2])

print(min(sum_colors[-1]))
print(sum_colors)
print(colors)






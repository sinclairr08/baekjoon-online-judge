# https://www.acmicpc.net/problem/1018
# 20200922

import sys

def compare_grid(gr1, gr2):
    diff = 0
    for i in range(8):
        for j, k in zip(gr1[i], gr2[i]):
            if (j + k) % 2 != 0:
                diff += 1

    return diff

height, width = map(int, sys.stdin.readline().split())
grid = []
grid_answer_1 = []
grid_answer_2 = []

ans = [[1, 0, 1, 0, 1, 0, 1, 0], [0, 1, 0, 1, 0, 1, 0, 1]]

for i in range(8):
    grid_answer_1.append(ans[i % 2])
    grid_answer_2.append(ans[(i + 1) % 2])

for _ in range(height):
    words = sys.stdin.readline().rstrip()
    line = []

    for w in words:
        if w == 'B':
            line.append(0)
        elif w == 'W':
            line.append(1)

    grid.append(line)
    del line


minimum = 64
for i in range(height - 7):
    for j in range(width - 7):
        grid_cut = [row[j:j+8] for row in grid[i:i+8]]
        optimal = min(compare_grid(grid_cut, grid_answer_1), compare_grid(grid_cut, grid_answer_2))
        if optimal < minimum:
            minimum = optimal

print(minimum)
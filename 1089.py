# https://www.acmicpc.net/problem/1089
# 20201007

import sys


N = int(sys.stdin.readline().rstrip())
numbers = []
for _ in range(N):
    numbers.append([])


# This means the location of "blank" for each numbers, for comparing input and numbers
numbers_inverse = [
    [4, 7, 10],
    [0, 1, 3, 4, 6, 7, 9, 10, 12, 13],
    [3, 4, 10, 11],
    [3, 4, 9, 10],
    [1, 4, 9, 10, 12, 13],
    [4, 5, 9, 10],
    [4, 5, 10],
    [3, 4, 6, 7, 9, 10, 12, 13],
    [4, 10],
    [4, 9, 10]
]

def compare_numbers(number):
    ret = []
    for i in range(10):
        if is_belong(number, numbers_inverse[i]):
            ret.append(i)

    return ret


def is_belong(sparse, inverse):
    diff = [item for item in sparse if item in inverse]

    if len(diff) != 0:
        return False
    else:
        return True

def calculate_average(pos_numbers):
    total_N = 1
    total_S = 0
    for pos in pos_numbers:
        total_N *= len(pos)

    for i in range(N):
        total_S += sum(pos_numbers[i]) * (10 ** (N - i - 1)) * (total_N // len(pos_numbers[i]))

    return total_S / total_N

for i in range(5):
    line = sys.stdin.readline().rstrip()

    for j in range(N):
        split = line[4 * j: 4 * j + 3]
        for k in range(3):
            if split[k] == '#':
                numbers[j].append(3 * i + k)

pos_numbers = []
for number in numbers:
    pos = compare_numbers(number)
    if len(pos) == 0:
        print(-1)
        break
    else:
        pos_numbers.append(pos)

if len(pos_numbers) == N:
    print(calculate_average(pos_numbers))













# https://www.acmicpc.net/problem/10974
# 20201008

import sys


"""
def perm(numbers, depth, n):
    if depth == n:
        print_numbers(numbers)
        return

    else:
        for i in range(depth, n):
            swap(numbers, i, depth)
            perm(numbers, depth + 1, n)
            swap(numbers, i, depth)
        return

def swap(numbers, i, j):
    if i == j:
        return
    temp = numbers[i]
    numbers[i] = numbers[j]
    numbers[j] = temp

    return

"""

def print_numbers(nums):
    for num in nums:
        print(num, end=" ")
    print()

def perm(numbers, depth, n):
    if depth < n:
        for i in range(n):
            if visited[i] == 0:
                numbers.append(i + 1)
                visited[i] = 1
                perm(numbers, depth + 1, n)
                visited[i] = 0
                numbers.pop()
    else:
        print_numbers(numbers)

N = int(sys.stdin.readline().rstrip())
numbers = []
visited= [0] * N

perm(numbers, 0, N)



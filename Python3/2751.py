# https://www.acmicpc.net/problem/2751
# 20201116

import sys
import random


def partition(numbers, left, right):
    rand_piv_idx = random.randrange(left, right+1)

    numbers[left], numbers[rand_piv_idx] = numbers[rand_piv_idx], numbers[left]

    pivot = numbers[left]
    low = left + 1
    high = right

    if low == high and pivot < numbers[high]:
        high -= 1

    while low < high:
        while low < right and numbers[low] < pivot:
            low += 1

        while high > left and numbers[high] > pivot:
            high -= 1

        if low < high:
            numbers[low], numbers[high] = numbers[high], numbers[low]

    numbers[left], numbers[high] = numbers[high], numbers[left]

    return high


def quick_sort(numbers, left, right):
    if left < right:
        pivot_idx = partition(numbers, left, right)

        quick_sort(numbers, left, pivot_idx - 1)
        quick_sort(numbers, pivot_idx + 1, right)

    return


if __name__ == "__main__":
    N = int(sys.stdin.readline().rstrip())
    numbers = []
    for _ in range(N):
        numbers.append(int(sys.stdin.readline().rstrip()))

    quick_sort(numbers, 0, N - 1)

    for number in numbers:
        print(number)




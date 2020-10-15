# https://www.acmicpc.net/problem/1342
# 20201008

import sys

S = sys.stdin.readline().rstrip()
L = len(S)

def stack_words(total):
    if len(lucky_str) == L:
        total += 1
        return total

    for i in range(26):
        if alphabets[i] > 0 and (not lucky_str or i != lucky_str[-1]):

            lucky_str.append(i)
            alphabets[i] -= 1

            total = stack_words(total)

            lucky_str.pop()
            alphabets[i] += 1
    return total

def factorial(i):
    base = 1
    for j in range(2, i + 1):
        base *= j
    return base

lucky_str = []
alphabets = [0] * 26
total = 0

for word in S:
    idx = ord(word) - ord('a')
    alphabets[idx] += 1

if max(alphabets) == 1:
    print(factorial(L))

else:
    print(stack_words(0))


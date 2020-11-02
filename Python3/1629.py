# https://www.acmicpc.net/problem/1629
# 20201030

import sys


def exponent_remainder(base, exponent, div, original_base):
    if exponent == 0:
        return 1
    elif exponent == 1:
        base %= div
        return base
    else:
        base = exponent_remainder(base, exponent // 2, div, original_base)
        if exponent % 2 == 0:
            base *= base
        elif exponent % 2 == 1:
            base *= original_base * base

        base %= div
        return base


base, exponent, div = map(int, sys.stdin.readline().split())

print(exponent_remainder(base, exponent, div, base))
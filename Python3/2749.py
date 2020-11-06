# https://www.acmicpc.net/problem/2749
# 20201106

import sys

divider = 1000000


def fibo_memo(odd_N, even_N):
    if odd_N == 1:
        return 1, 1

    else:
        half_N = even_N // 2
        is_half_odd = False

        if half_N % 2 == 1:
            half_N += 1
            is_half_odd = True

        half_sub, half_ = fibo_memo(half_N - 1, half_N)

        if is_half_odd:
            temp = half_ - half_sub
            half_ = half_sub
            half_sub = temp

        res_odd = half_ * half_ + half_sub * half_sub
        res_odd %= divider

        res_even = half_ * half_ + 2 * half_ * half_sub
        res_even %= divider

        return res_odd, res_even


if __name__ == "__main__":
    N = int(sys.stdin.readline().rstrip())
    if N == 0:
        print(0)

    elif N % 2 == 1:
        res, _ = fibo_memo(N, N + 1)
        print(res)

    else:
        _, res = fibo_memo(N - 1, N)
        print(res)



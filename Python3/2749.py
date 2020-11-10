# https://www.acmicpc.net/problem/2749
# 20201106

import sys

divider = 1000000


# Input: 2k-1, 2k
# Output : F_2k-1, F_2k
def fibonacci_pair(odd_N, even_N):
    # F_1, F_2 == 1, 1
    if odd_N == 1:
        return 1, 1

    else:
        half_N = even_N // 2
        is_half_odd = False

        # If k is odd, we calculate (F_k+1, F_k) rather than (F_k, F_k-1)
        if half_N % 2 == 1:
            half_N += 1
            is_half_odd = True

        # F_k, F_k+1 or F_k-1, F_k
        res_pre_half, res_half = fibonacci_pair(half_N - 1, half_N)

        # if F_k, F_k+1 case, get F_k-1 by using F_k, F_k+1
        if is_half_odd:
            temp = res_half - res_pre_half
            res_half = res_pre_half
            res_pre_half = temp

        # F_2k-1 = (F_k)^2 + (F_k-1)^2
        res_odd = res_half * res_half + res_pre_half * res_pre_half
        res_odd %= divider

        # F_2k = (F_k)^2 + 2*(F_k)*(F_k-1)
        res_even = res_half * res_half + 2 * res_half * res_pre_half
        res_even %= divider

        return res_odd, res_even


if __name__ == "__main__":
    N = int(sys.stdin.readline().rstrip())

    # F_0 == 0
    if N == 0:
        result = 0

    # fibonacci pair function requires (odd, even) input
    # So divide case where n == odd and n == even
    elif N % 2 == 1:
        result, _ = fibonacci_pair(N, N + 1)

    else:
        _, result = fibonacci_pair(N - 1, N)

    print(result)

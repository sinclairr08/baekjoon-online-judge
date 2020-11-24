# https://www.acmicpc.net/problem/18222
# 20201122

import sys
import math

# N -= 2^(floor(lgN))
def find_complement(N):
    floor_log = math.ceil(math.log(N, 2)) - 1
    closest_point = 2 ** floor_log

    return N - closest_point


if __name__ == "__main__":
    N = int(sys.stdin.readline().rstrip())
    is_reversed = False

    while N != 1:
        N = find_complement(N)
        is_reversed = not is_reversed

    print(1) if is_reversed else print(0)



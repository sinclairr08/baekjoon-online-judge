#https://www.acmicpc.net/problem/1978
# 20200426

import sys
import math

def is_prime(num):
    if num == 1:
        return False

    elif num == 2:
        return True

    else:
        for i in range(2, math.ceil(math.sqrt(num)) + 1):
            if num % i ==0:
                return False

        return True


N = int(sys.stdin.readline().rstrip())
nums = map(int, sys.stdin.readline().split())

num_p = 0
for num in nums:
    num_p += 1 if is_prime(num) else 0

print(num_p)
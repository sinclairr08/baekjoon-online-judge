#https://www.acmicpc.net/problem/1016
# 20200427

import sys
import math

primes = [2]

def non_sq(min, max):
    erat_bool = [True] * (max + 1 - min)

    for sq_prime in sq_primes:
        sq_num = (math.ceil(min / sq_prime)) * sq_prime

        while sq_num <= max:
            erat_bool[sq_num - min] = False
            sq_num += sq_prime

    return erat_bool.count(True)

def prime_list(num):
    for cand in range(3, num + 1, 2):
        is_prime = True
        for i in range(2, math.ceil(math.sqrt(cand)) + 1):
            if cand % i == 0:
                is_prime = False
                break
        if is_prime:
            primes.append(cand)

    return None

min, max = map(int, sys.stdin.readline().split())
prime_list(math.ceil(math.sqrt(max)))
sq_primes = [x * x for x in primes]

print(non_sq(min, max))

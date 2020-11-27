# https://www.acmicpc.net/problem/15998
# 20201125

import sys
import math

if __name__ == "__main__":
    N = int(sys.stdin.readline().rstrip())
    MAX_VAL = 9 * 1e18

    prev_balance = 0

    candidates = []
    lower_bound = 0

    for _ in range(N):
        deposit, balance = map(int, sys.stdin.readline().split())

        # If withdrawn and charged
        if deposit < 0 and prev_balance + deposit != balance :

            # Add every M * k
            candidates.append(balance - deposit - prev_balance)

            if lower_bound < balance:
                lower_bound = balance

        # If deposit or not charged
        else:
            if prev_balance + deposit != balance:
                print(-1)
                quit()

        prev_balance = balance

    # If there is no charge
    if len(candidates) == 0:
        print(1)

    else:
        gcd = candidates[0]

        if gcd <= lower_bound:
            print(-1)
            quit()

        for i in range(1, len(candidates)):
            gcd = math.gcd(gcd, candidates[i])

            if gcd <= lower_bound:
                print(-1)
                quit()

        if gcd > MAX_VAL:
            print(-1)

        else:
            print(gcd)


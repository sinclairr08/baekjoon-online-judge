# https://www.acmicpc.net/problem/15954
# 20200411

import sys
from decimal import *

getcontext().prec = 28
n, k = map(int, sys.stdin.readline().split())

dolls = list(map(Decimal, sys.stdin.readline().split()))
min_std = Decimal(500000)

for stp in range(n - k + 1):
    sum_dolls = sum(dolls[stp : stp + k - 1])
    sum_dolls_sq = sum([i * i for i in dolls[stp : stp + k - 1]])

    for edp in range(k, n - stp + 1):
        sum_dolls += dolls[stp + edp - 1]
        sum_dolls_sq += dolls[stp + edp - 1] ** 2

        mean_dolls = sum_dolls / Decimal(edp)

        var = (sum_dolls_sq / Decimal(edp)) - (mean_dolls ** 2)
        std = var.sqrt()

        min_std = min(min_std, std)

sys.stdout.write(str(min_std))
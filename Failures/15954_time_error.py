import sys
from decimal import Decimal

n, k = map(int, sys.stdin.readline().split())

dolls = list(map(Decimal, sys.stdin.readline().split()))
dollsq = [i * i for i in dolls]
min_std = Decimal(500000)

for j in range(k, n + 1):
    means = []
    num_ranges = Decimal(j)
    mean = sum(dolls[:j])
    means.append(mean / num_ranges)

    for i in range(n - j):
        mean += dolls[i+j] - dolls[i]
        means.append(mean / num_ranges)

    for i in range(n - j + 1):
        std = ((sum(dollsq[i: i + j]) / num_ranges) -  (means[i] ** 2)).sqrt()
        min_std = min(min_std, std)


sys.stdout.write(str(min_std))
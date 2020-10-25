import sys

n, k = map(int, sys.stdin.readline().split())

dolls = list(map(int, sys.stdin.readline().split()))
dollsq = [i * i for i in dolls]
min_std = float(500000)

for j in range(k, n + 1):
    means = []
    mean = sum(dolls[:j])
    means.append(mean / j)

    for i in range(n - j):
        mean += dolls[i+j] - dolls[i]
        means.append(mean / j)

    for i in range(n - j + 1):
        var = (sum(dollsq[i: i + j]) / j) -  (means[i] ** 2)
        std = var ** 0.5

        min_std = min(min_std, std)

sys.stdout.write(str(min_std))
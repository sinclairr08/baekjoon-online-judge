#https://www.acmicpc.net/problem/1010
# 20200424

import sys

class Comb:
    def __init__(self):
        self.comb = []
        for i in range(31):
            self.comb.append([0] * 31)
            self.comb[i][0] = 1
            self.comb[i][i] = 1

    def count(self, n, k):
        if self.comb[n][k] == 0:
            self.comb[n][k] = self.count(n - 1, k - 1) + self.count(n - 1, k)

        return self.comb[n][k]

N =  int(sys.stdin.readline())
c = Comb()

for i in range(N):
    left, right = map(int, sys.stdin.readline().split())
    print(c.count(right, left))
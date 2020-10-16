#https://www.acmicpc.net/problem/2193
# 20200426

import sys


class ichin:
    def __init__(self):
        self.ich_list = [0, 1, 1]

    def calc(self, N):
        if N < len(self.ich_list):
            return self.ich_list[N]

        while N >= len(self.ich_list):
            temp = self.ich_list[-1] + self.ich_list[-2]
            self.ich_list.append(temp)

        return self.ich_list[N]


N = int(sys.stdin.readline().rstrip())
I = ichin()

print(I.calc(N))
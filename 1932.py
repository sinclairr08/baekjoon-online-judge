#https://www.acmicpc.net/problem/1932
# 20200424

import sys

class Tree:
    def __init__(self):
        self.size = int(sys.stdin.readline().rstrip())
        self.elem = []
        self.max = []

        for i in range(self.size):
            self.elem.append(list(map(int, sys.stdin.readline().split())))

        for i in range(self.size):
            self.max.append([0] * (i + 1))

    def max_route(self, depth):
        if depth == 0:
            self.max[depth][0] = self.elem[depth][0]

        else:
            for i in range(depth + 1):
                if i == 0:
                    self.max[depth][i] = self.elem[depth][i] + self.max[depth - 1][i]

                elif i == depth:
                    self.max[depth][i] = self.elem[depth][i] + self.max[depth - 1][i - 1]

                else:
                    self.max[depth][i] = max(
                        self.max[depth - 1][i - 1] + self.elem[depth][i],
                        self.max[depth - 1][i] + self.elem[depth][i]
                    )

        if depth < self.size - 1:
            self.max_route(depth + 1)

        return max(self.max[-1])


t = Tree()
print(t.max_route(0))


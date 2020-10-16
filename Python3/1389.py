#https://www.acmicpc.net/problem/1389
# 20200910

import sys

N_user, N_rel = map(int, sys.stdin.readline().split())

class Graph:
    def __init__(self, N_user):
        self.N_user = N_user
        self.kevin = [0] * N_user
        self.d = []
        for i in range(N_user):
            temp = [200] * N_user
            temp[i] = 0
            self.d.append(temp)


    def add_relation(self, X, Y):
        self.d[X - 1][Y - 1] = 1
        self.d[Y - 1][X - 1] = 1

    def floydd(self):
        for k in range(self.N_user):
            for i in range(self.N_user):
                for j in range(self.N_user):
                    if self.d[i][j] > self.d[i][k] + self.d[k][j]:
                        self.d[i][j] = self.d[i][k] + self.d[k][j]

    def get_kevin(self):
        for i in range(N_user):
            self.kevin[i] = sum(self.d[i])

        minimum = min(self.kevin)
        return self.kevin.index(minimum) + 1



graph = Graph(N_user)
for _ in range(N_rel):
    X, Y = map(int, sys.stdin.readline().split())
    graph.add_relation(X, Y)

graph.floydd()
print(graph.get_kevin())

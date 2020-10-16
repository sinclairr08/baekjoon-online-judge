# https://www.acmicpc.net/problem/1012
# 20200921

import sys

sys.setrecursionlimit(50000)

def add_t(x1, y1, x2, y2):
    return x1 + x2, y1 + y2

class Graph:
    def __init__(self, width, height):
        self.width = width
        self.height = height
        self.cabs = []
        self.visited = [0] * (self.width * self.height)
        self.bug = 0
        self.directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]

        for _ in range(self.height):
            self.cabs.append([0] * self.width)

    def add_cab(self, X , Y):
        self.cabs[Y][X] = 1

    def BFS(self):
        queue = [0]
        self.visited[0] = 1

        while len(queue) != 0:
            node = queue.pop(0)

            Y, X = node // self.width, node % self.width
            if self.cabs[Y][X] == 0:
                node += 1
                while node < self.height * self.width and self.visited[node] != 0:
                    node += 1

                if node >= self.height * self.width:
                    break
                queue.append(node)
                self.visited[node] = 1

            else:
                self.bug += 1
                self.adjacent_DFS(X, Y)

                while node < self.height * self.width and self.visited[node] != 0:
                    node += 1

                if node >= self.height * self.width:
                    break
                queue.append(node)
                self.visited[node] = 1

    def adjacent_DFS(self, X, Y):
        for dir1, dir2 in self.directions:
            X_, Y_ = add_t(dir1, dir2, X, Y)
            Z_ = Y_ * self.width + X_

            if X_ >= 0 and X_ < self.width and Y_ >= 0 and Y_ < self.height:
                if self.cabs[Y_][X_] == 1 and \
                        self.visited[Z_] == 0:
                    self.visited[Z_] = 1
                    self.adjacent_DFS(X_, Y_)
                else:
                    self.visited[Z_] = 1


num_test = int(sys.stdin.readline().rstrip())

for i in range(num_test):
    width, height, num_cabs = map(int, sys.stdin.readline().split())
    cab_graph = Graph(width, height)

    for _ in range(num_cabs):
        X, Y = map(int, sys.stdin.readline().split())
        cab_graph.add_cab(X, Y)

    cab_graph.BFS()

    print(cab_graph.bug)
    del cab_graph



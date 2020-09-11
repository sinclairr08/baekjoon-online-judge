#https://www.acmicpc.net/problem/1260
# 20200911

import sys

N_node, N_edge, init_node = map(int, sys.stdin.readline().split())

class Graph:
    def __init__(self, N_node):
        self.N_node = N_node
        self.nodes = []
        for _ in range(self.N_node + 1):
            self.nodes.append([0] * (self.N_node + 1))

    def add_edge(self, node1, node2):
        self.nodes[node1][node2] = 1
        self.nodes[node2][node1] = 1

    def is_connected(self, node1, node2):
        return True if self.nodes[node1][node2] == 1 else False

    def BFS(self, init_node):
        visited = [0] * (self.N_node + 1)
        queue = [init_node]
        visited[init_node] = 1

        while len(queue) != 0:
            node = queue[0]
            queue.pop(0)

            print(node, end=' ')

            for i in range(1, self.N_node + 1):
                if self.nodes[node][i] == 1:
                    if visited[i] == 0:
                        visited[i] = 1
                        queue.append(i)

    def DFS(self, init_node):
        visited = [0] * (self.N_node + 1)

        self.DFScall(init_node, visited)

    def DFScall(self, node, visited):
        print(node, end=' ')
        visited[node] = 1

        for i in range(1, self.N_node + 1):
            if self.nodes[node][i] == 1:
                if visited[i] == 0:
                    self.DFScall(i, visited)



graph = Graph(N_node)
for _ in range(N_edge):
    n1, n2 = map(int, sys.stdin.readline().split())
    graph.add_edge(n1, n2)

graph.DFS(init_node)
print()
graph.BFS(init_node)

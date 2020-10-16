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

    def init_search(self):
        self.visited = [0] * (self.N_node + 1)

    def BFS(self, init_node):
        queue = [init_node]
        self.visited[init_node] = 1

        while len(queue) != 0:
            node = queue[0]
            queue.pop(0)

            print(node, end=' ')

            for i in range(1, self.N_node + 1):
                if self.nodes[node][i] == 1:
                    if self.visited[i] == 0:
                        self.visited[i] = 1
                        queue.append(i)

    def DFS(self, node):
        print(node, end=' ')
        self.visited[node] = 1

        for i in range(1, self.N_node + 1):
            if self.nodes[node][i] == 1:
                if self.visited[i] == 0:
                    self.DFS(i)



graph = Graph(N_node)
for _ in range(N_edge):
    n1, n2 = map(int, sys.stdin.readline().split())
    graph.add_edge(n1, n2)

graph.init_search()
graph.DFS(init_node)
print()
graph.init_search()
graph.BFS(init_node)

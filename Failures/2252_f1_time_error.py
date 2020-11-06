# https://www.acmicpc.net/problem/2252
# 20201105

import sys


class Node:
    def __init__(self, item):
        self.item = item
        self.indegree = 0
        self.connected = []


class DAG:
    def __init__(self, N_students):
        self.nodes = [Node(0)]
        self.len = N_students

        self.visited = [False] * (N_students + 1)

        self.N_visited = 0
        self.queue = []

        for i in range(1, N_students + 1):
            self.nodes.append(Node(i))

    def add_edge(self, idx1, idx2):
        self.nodes[idx1].connected.append(idx2)
        self.nodes[idx2].indegree += 1

    def find_zero(self):
        for i in range(1, self.len + 1):
            if not self.visited[i] and self.nodes[i].indegree == 0:
                if i not in self.queue:
                    self.queue.append(i)
        return

    def topological_sort(self):
        result_list = []

        while self.N_visited != self.len:
            self.find_zero()

            if len(self.queue) == 0:
                break
            target_node = self.queue[0]
            self.queue = self.queue[1:]
            result_list.append(target_node)

            self.visited[target_node] = True
            self.N_visited += 1
            for idx in self.nodes[target_node].connected:
                self.nodes[idx].indegree -= 1

        return result_list


if __name__ == "__main__":
    N, M = map(int, sys.stdin.readline().split())
    dag = DAG(N)
    for _ in range(M):
        idx1, idx2 = map(int, sys.stdin.readline().split())
        dag.add_edge(idx1, idx2)

    result = dag.topological_sort()
    for res in result:
        print(res, end = ' ')


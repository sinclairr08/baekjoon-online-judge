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

        for i in range(1, N_students + 1):
            self.nodes.append(Node(i))

    def add_edge(self, idx1, idx2):
        self.nodes[idx1].connected.append(idx2)
        self.nodes[idx2].indegree += 1

    def dfs(self, idx, result_list):
        self.visited[idx] = True
        for sub_idx in self.nodes[idx].connected:
            if not self.visited[sub_idx]:
                self.dfs(sub_idx, result_list)

        result_list.append(idx)
        return

    def topological_sort(self):
        result_list = []

        for idx in range(1, self.len + 1):
            if not self.visited[idx]:
                self.dfs(idx, result_list)

        result_list.reverse()
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


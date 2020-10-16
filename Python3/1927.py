# https://www.acmicpc.net/problem/1927
# 20201016

import sys

class m_Heap:
    def __init__(self):
        self.heap = [0]
        self.len = 0

    def insert(self, new_val):
        self.heap.append(new_val)
        self.len += 1

        self.heapify(index= self.len, mode = 'i')

    def delete(self):
        if self.len == 0:
            return 0

        val = self.heap[1]
        if self.len == 1:
            self.heap.pop()
        else:
            self.heap[1] = self.heap.pop()

        self.len -= 1
        self.heapify(index=1, mode = 'd')

        return val

    def get_parent(self, index):
        return index // 2

    def get_Lchild(self, index):
        return index * 2

    def get_Rchild(self, index):
        return index * 2 + 1

    def get_Schild(self, index):
        L_child = self.get_Lchild(index)
        R_child = self.get_Rchild(index)

        if L_child > self.len:
            return -1

        elif R_child > self.len:
            return L_child

        else:
            if self.heap[L_child] <= self.heap[R_child]:
                return L_child
            else:
                return R_child

    def swap_index(self, i, j):
        temp = self.heap[i]
        self.heap[i] = self.heap[j]
        self.heap[j] = temp

    def heapify(self, index, mode):
        if mode == 'i':
            if index == 1:
                return

            index_p = self.get_parent(index)
            if self.heap[index] < self.heap[index_p]:
                self.swap_index(index, index_p)
                return self.heapify(index_p, mode)

            else:
                return

        if mode == 'd':
            index_c = self.get_Schild(index)
            if index_c < 0:
                return

            elif self.heap[index_c] < self.heap[index]:
                self.swap_index(index_c, index)
                self.heapify(index_c, mode)

N = int(sys.stdin.readline().rstrip())
heap = m_Heap()

for _ in range(N):
    val = int(sys.stdin.readline().rstrip())

    if val == 0:
        print(heap.delete())

    else:
        heap.insert(val)


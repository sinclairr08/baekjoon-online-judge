# https://www.acmicpc.net/problem/7662
# 20201014

import sys

class D_Heap:
    def __init__(self):
        self.min_heap = [0]
        self.max_heap = [0]
        self.len = 0

    def insert(self, new_val):
        self.min_heap.append(new_val)
        self.max_heap.append(new_val)
        self.len += 1

        self.max_heapify(index= self.len, mode = 'i')
        self.min_heapify(index= self.len, mode = 'i')

    def delete_min(self):
        if self.len == 0:
            return

        min_val = self.min_heap[1]
        if self.len == 1:
            self.min_heap.pop()
        else:
            self.min_heap[1] = self.min_heap.pop()

        min_idx = self.max_heap.index(min_val)

        if min_idx == self.len:
            self.max_heap.pop()
        else:
            self.max_heap[min_idx] = self.max_heap.pop()

        self.len -= 1
        self.min_heapify(index=1, mode = 'd')

    def delete_max(self):
        if self.len == 0:
            return

        max_val = self.max_heap[1]
        if self.len == 1:
            self.max_heap.pop()
        else:
            self.max_heap[1] = self.max_heap.pop()

        max_idx = self.min_heap.index(max_val)

        if max_idx == self.len:
            self.min_heap.pop()
        else:
            self.min_heap[max_idx] = self.min_heap.pop()

        self.len -= 1
        self.max_heapify(index=1, mode = 'd')

    def get_parent(self, index):
        return index // 2

    def get_childs(self, index):
        return index * 2, index * 2 + 1

    def swap_index(self, list, i, j):
        temp = list[i]
        list[i] = list[j]
        list[j] = temp

    def max_heapify(self, index, mode):
        if mode == 'i':
            if index == 1:
                return

            index_p = self.get_parent(index)
            if self.max_heap[index] > self.max_heap[index_p]:
                self.swap_index(self.max_heap, index, index_p)
                return self.max_heapify(index_p, mode)

            else:
                return

        if mode == 'd':
            index_c1, index_c2 = self.get_childs(index)

            if index_c1 > self.len:
                return

            else:
                if self.max_heap[index_c1] >= self.max_heap[index]:
                    self.swap_index(self.max_heap, index_c1, index)
                    self.max_heapify(index_c1, mode)

                elif index_c2 <= self.len:
                    if self.max_heap[index_c2] <= self.max_heap[index]:
                        self.swap_index(self.max_heap, index_c2, index)
                        self.max_heapify(index_c2, mode)

                else:
                    return

    def min_heapify(self, index, mode):
        if mode == 'i':
            if index == 1:
                return

            index_p = self.get_parent(index)
            if self.min_heap[index] < self.min_heap[index_p]:
                self.swap_index(self.min_heap, index, index_p)
                return self.max_heapify(index_p, mode)

            else:
                return

        if mode == 'd':
            index_c1, index_c2 = self.get_childs(index)

            if index_c1 > self.len:
                return

            else:
                if self.min_heap[index_c1] <= self.min_heap[index]:
                    self.swap_index(self.min_heap, index_c1, index)
                    self.min_heapify(index_c1, mode)

                elif index_c2 <= self.len:
                    if self.min_heap[index_c2] <= self.min_heap[index]:
                        self.swap_index(self.min_heap, index_c2, index)
                        self.min_heapify(index_c2, mode)

                else:
                    return


T = int(sys.stdin.readline().rstrip())


for _ in range(T):
    N = int(sys.stdin.readline().rstrip())
    heap = D_Heap()

    for __ in range(N):
        line = sys.stdin.readline().split()
        op = line[0]
        val = int(line[1])

        if op == "I":
            heap.insert(val)

        elif op == "D":
            if val == 1:
                heap.delete_max()
            elif val == -1:
                heap.delete_min()


    if heap.len == 0:
        print("EMPTY")
    else:
        print(heap.max_heap[1], end=' ')
        print(heap.min_heap[1])


# https://www.acmicpc.net/problem/7662
# 20201014

import sys

T = int(sys.stdin.readline().rstrip())

class Deque:
    def __init__(self):
        self.items = []
        self.dict = {}
        self.len = 0

    def insert(self, val):
        if val in self.dict.keys():
            self.dict[val] += 1
        else:
            self.dict[val] = 1
            self.insert_items(val, left = 0, right = self.len)

    def insert_items(self, val, left, right):
        if left == right:
            self.items.insert(left, val)
            self.len += 1
            return

        middle = left + (right - left) // 2
        if self.items[middle] > val:
            self.insert_items(val, left, middle)
        else:
            self.insert_items(val, middle + 1, right)

    def delete_max(self):
        if self.len == 0:
            return

        max_val = self.items[-1]

        if self.dict[max_val] == 1:
            self.dict.pop(max_val)
            self.items.pop()
            self.len -= 1

        else:
            self.dict[max_val] -= 1

        return

    def delete_min(self):
        if self.len == 0:
            return

        min_val = self.items[0]

        if self.dict[min_val] == 1:
            self.dict.pop(min_val)
            self.items.pop(0)
            self.len -= 1

        else:
            self.dict[min_val] -= 1

        return


for _ in range(T):
    N = int(sys.stdin.readline().rstrip())
    deque = Deque()

    for __ in range(N):
        line = sys.stdin.readline().split()
        op = line[0]
        val = int(line[1])

        if op == "I":
            deque.insert(val)

        elif op == "D":
            if val == 1:
                deque.delete_max()
            elif val == -1:
                deque.delete_min()

    if deque.len == 0:
        print("EMPTY")
    else:
        print(deque.items[-1], end = ' ')
        print(deque.items[0])


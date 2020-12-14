# https://www.acmicpc.net/problem/7662
# 20201203

import sys
from collections import deque
from bisect import insort

T = int(sys.stdin.readline().rstrip())

for _ in range(T):
    N = int(sys.stdin.readline().rstrip())
    deq = deque()
    hash = {}

    for __ in range(N):
        line = sys.stdin.readline().split()
        op = line[0]
        val = int(line[1])

        if op == "I":
            if val not in hash.keys():
                insort(deq, val)
                hash[val] = 1
            else:
                hash[val] += 1

        elif op == "D":
            if len(deq) == 0:
                continue

            else:

                if val == 1:
                    max_val = deq[-1]

                    if hash[max_val] == 1:
                        hash.pop(max_val)
                        deq.pop()

                    else:
                        hash[max_val] -= 1

                elif val == -1:
                    min_val = deq[0]

                    if hash[min_val] == 1:
                        hash.pop(min_val)
                        deq.popleft()

                    else:
                        hash[min_val] -= 1

    if len(deq) == 0:
        print("EMPTY")
    elif len(deq) == 1:
        res = deq.pop()
        print(res, end = ' ')
        print(res)
    else:
        print(deq.pop(), end=' ')
        print(deq.popleft())


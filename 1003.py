#https://www.acmicpc.net/problem/1003
# 20200414

import sys

fibo_list = [(1, 0), (0, 1)]

def fibo_accum(n):
    fibo_len = len(fibo_list) - 1
    if n <= fibo_len:
        pass
    else:
        while fibo_len < n:
            fibo_list.append(tuple_sum(
                fibo_list[-1], fibo_list[-2]
            ))
            fibo_len = len(fibo_list) - 1

def tuple_sum(t1, t2):
    t11, t12 = t1
    t21, t22 = t2
    return (t11 + t21, t12 + t22)


num_ex = int(sys.stdin.readline())
for i in range(num_ex):
    n = int(sys.stdin.readline())
    fibo_accum(n)

    fibo_0, fibo_1 = fibo_list[n]
    sys.stdout.write(str(fibo_0) + ' ' + str(fibo_1) + '\n')
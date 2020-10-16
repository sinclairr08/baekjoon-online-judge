#https://www.acmicpc.net/problem/3955
# 20200426

import sys

def get_candy(K, C):
    original_k = K
    original_c = C
    remainder = K % C
    quotients = []

    while remainder != 0:
        quotients.append(K // C)
        K = C
        C = remainder
        remainder = K % C

    if C != 1:
        return "IMPOSSIBLE"

    x_k = [1, 0]
    x_c = [0, 1]

    for q in quotients:
        y_k = x_k[-2] - q * x_k[-1]
        y_c = x_c[-2] - q * x_c[-1]

        x_k.append(y_k)
        x_c.append(y_c)

    ans = x_c[-1]
    while ans <= 0 or ans * original_c <= original_k:
        ans += original_k

    if ans > 1e9:
        return "IMPOSSIBLE"
    else:
        return ans



Test_case = int(sys.stdin.readline().rstrip())


for i in range(Test_case):
    K, C = map(int, sys.stdin.readline().split())
    print(get_candy(K, C))
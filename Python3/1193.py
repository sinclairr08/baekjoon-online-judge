#https://www.acmicpc.net/problem/1193
# 20200424

import sys

def fract_finder(N):
    line = 1
    while N > line:
        N -= line
        line += 1

    if line % 2 == 0:
        mol = N
        denom = line + 1 - N

    else:
        denom = N
        mol = line + 1 - N

    return mol, denom

N = int(sys.stdin.readline().rstrip())
mol, denom = fract_finder(N)
print("{}/{}".format(mol, denom))
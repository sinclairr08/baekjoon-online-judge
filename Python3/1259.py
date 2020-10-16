# https://www.acmicpc.net/problem/1259
# 20201013

import sys

def is_palindrome(words):
    l = len(words)
    if l == 1:
        print('yes')
    elif l % 2 == 1:
        if words[:l // 2] == words[-1:l // 2 : -1]:
            print('yes')
        else:
            print('no')
    else:
        if words[:l // 2] == words[-1:l // 2 - 1: -1]:
            print('yes')
        else:
            print('no')



while True:
    line = sys.stdin.readline().rstrip()
    if int(line) == 0:
        break

    is_palindrome(line)

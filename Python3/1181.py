# https://www.acmicpc.net/problem/1181
# 20201012

import sys

N = int(sys.stdin.readline().rstrip())
dict = {}

for _ in range(N):
    line = sys.stdin.readline().rstrip()
    l = len(line)

    if l not in dict:
        dict[l] = []

    if line not in dict[l]:
        dict[l].append(line)

new_dict = sorted(dict.items(), key = lambda x:x[0])

for l, words in new_dict:
    words.sort()
    for word in words:
        print(word)

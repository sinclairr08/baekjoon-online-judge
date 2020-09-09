#https://www.acmicpc.net/problem/10798
# 20200909

import sys
lines = []
maxlen = 0

def split_word(string):
    temp = []
    for char in string:
        temp.append(char)

    return temp

def fill_None(lines, maxlen):
    for line in lines:
        while len(line) < maxlen:
            line.append(None)

def print_vertical(lines, num_lines, maxlen):
    for i in range(maxlen):
        for j in range(num_lines):
            if lines[j][i] is not None:
                print(lines[j][i], end = '')


while True:
    line = sys.stdin.readline().rstrip()
    if not line:
        break

    split_line = split_word(line)
    lines.append(split_line)

    if len(split_line) > maxlen:
        maxlen = len(split_line)

num_lines = len(lines)
fill_None(lines, maxlen)
print_vertical(lines, num_lines, maxlen)




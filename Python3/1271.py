# https://www.acmicpc.net/problem/1271
# First Written : 20200421
# Last Modified : 20201230

import sys

if __name__ == "__main__":
    money, person = map(int, sys.stdin.readline().split())

    each = money // person
    rest = money % person

    print(each)
    print(rest)

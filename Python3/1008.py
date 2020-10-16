#https://www.acmicpc.net/problem/1008
# 20200421

import sys
from decimal import Decimal

a, b = map(Decimal, sys.stdin.readline().rstrip().split())

sys.stdout.write(str(a / b))
#https://www.acmicpc.net/problem/2839
# 20200821

import sys

N = int(sys.stdin.readline())

# Idea : consider the remainder of N divided by 5
# Subtracting 3 at the remainder eventually goes to zero
# 2 -> 4 -> 1 -> 3 -> 0

rem_5 = N % 5
if rem_5 == 2 :
    cnt_3 = 4
elif rem_5 == 4 :
    cnt_3 = 3
elif rem_5 == 1 :
    cnt_3 = 2
elif rem_5 == 3 :
    cnt_3 = 1
else:
    cnt_3 = 0

N_5 = N - (3 * cnt_3)

if N_5 < 0:
    print(-1)
else:
    print(N_5 // 5 + cnt_3)

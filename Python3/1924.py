#https://www.acmicpc.net/problem/1924
# 20200424

import sys

def Find_2007(month, day):
    months = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    Aday = day
    for i in range(month - 1):
        Aday += months[i]

    if Aday % 7 == 0:
        return 'SUN'
    elif Aday % 7 == 1:
        return 'MON'
    elif Aday % 7 == 2:
        return 'TUE'
    elif Aday % 7 == 3:
        return 'WED'
    elif Aday % 7 == 4:
        return 'THU'
    elif Aday % 7 == 5:
        return 'FRI'
    elif Aday % 7 == 6:
        return 'SAT'


month, day = map(int, sys.stdin.readline().split())
Weekday = Find_2007(month, day)
sys.stdout.write(Weekday)
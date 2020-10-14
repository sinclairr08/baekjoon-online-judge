# https://www.acmicpc.net/problem/1599
# 20201012

import sys

N = int(sys.stdin.readline().rstrip())
dict = {
    'a' : 'a',
    'b' : 'b',
    'k' : 'c',
    'd' : 'd',
    'e' : 'e',
    'g' : 'f',
    'h' : 'g',
    'i' : 'h',
    'l' : 'i',
    'm' : 'j',
    'n' : 'k',
    'ng' : 'l',
    'o' : 'm',
    'p' : 'n',
    'r' : 'o',
    's' : 'p',
    't' : 'q',
    'u' : 'r',
    'w' : 's',
    'y' : 't'
}

def minsik_encode(str):
    encoded = []
    prev_count = False
    for i in range(len(str)):
        if prev_count:
            prev_count = False
            continue

        if str[i] == 'n' and i < len(str) - 1 and str[i + 1] == 'g':
                prev_count = True
                encoded.append(dict['ng'])
        else:
            encoded.append(dict[str[i]])


    return ''.join(encoded)


dict_line = {}
for _ in range(N):
    line = sys.stdin.readline().rstrip()
    dict_line[line] = minsik_encode(line)

new_dict = sorted(dict_line.items(), key=lambda x:x[1], reverse=False)


for key, value in new_dict:
    print(key)




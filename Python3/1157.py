# https://www.acmicpc.net/problem/1157
# 20201013

import sys

def upper_word(word):
    if word >= 'a':
        return chr(ord(word) - ord('a') + ord('A'))
    else:
        return word

words = sys.stdin.readline().rstrip()
dict = {}

for word in words:
    word_u = upper_word(word)
    if word_u not in dict.keys():
        dict[word_u] = 1
    else:
        dict[word_u] += 1

new_dict = sorted(dict.items(), key=lambda x:x[1], reverse=True)

val, i = new_dict[0]
if len(new_dict) <= 1:
    print(val)

else:
    _, j = new_dict[1]

    if i == j:
        print("?")
    else:
        print(val)

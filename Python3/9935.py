# https://www.acmicpc.net/problem/9935
# 20201215

import sys

class Stack:
    def __init__(self):
        self.list = [0] * 1000001
        self.state_list = [0] * 1000001
        self.top = -1

    def insert(self, word):
        self.top += 1
        self.list[self.top] = word

    def pops(self, n_pop):
        self.top -= n_pop

    def get_results(self):
        return self.list[:self.top + 1]

    def set_state(self, state):
        self.state_list[self.top] = state

    def pop_state(self):
        if self.top == -1:
            return 0
        else:
            return self.state_list[self.top]


if __name__ == "__main__":
    words = sys.stdin.readline().rstrip()
    bomb = sys.stdin.readline().rstrip()
    len_words = len(words)
    len_bomb = len(bomb)

    # if cur_match == len(bomb) : bomb it!
    cur_match = 0

    stack = Stack()

    for cur_word in words:
        stack.insert(cur_word)


        if cur_word == bomb[cur_match]:
            cur_match += 1
            stack.set_state(cur_match)

            if cur_match == len_bomb:
                stack.pops(len_bomb)
                cur_match = stack.pop_state()

        else:
            cur_match = 0

            if cur_word == bomb[cur_match]:
                cur_match += 1
                stack.set_state(cur_match)
            else:
                stack.set_state(0)

    res = stack.get_results()
    if not res:
        print("FRULA")

    else:
        print(''.join(res))


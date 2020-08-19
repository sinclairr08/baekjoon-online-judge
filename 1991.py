#https://www.acmicpc.net/problem/1991
# 20200819

import sys

class Node:
    def __init__(self, content, left, right):
        self.left = left
        self.right = right
        self.content = content

    def is_left(self):
        if self.left == ".":
            return False
        return True

    def is_right(self):
        if self.right == ".":
            return False
        return True

class Tree:
    def __init__(self):
        self.nodes = {}

    def input_nodes(self, content, left, right):
        if content not in self.nodes:
            self.nodes[content] = Node(content, left, right)

    def preorder(self, root_content):
        node = self.nodes[root_content]
        print(root_content, end = '')

        if node.is_left():
            self.preorder(node.left)

        if node.is_right():
            self.preorder(node.right)

    def inorder(self, root_content):
        node = self.nodes[root_content]

        if node.is_left():
            self.inorder(node.left)

        print(root_content, end = '')

        if node.is_right():
            self.inorder(node.right)

    def postorder(self, root_content):
        node = self.nodes[root_content]

        if node.is_left():
            self.postorder(node.left)

        if node.is_right():
            self.postorder(node.right)

        print(root_content, end= '')


if __name__ == "__main__":
    Nnode = int(sys.stdin.readline())
    tree = Tree()

    for i in range(Nnode):
        content, left, right = tuple(sys.stdin.readline().split())
        tree.input_nodes(content, left, right)

    tree.preorder('A')
    print()
    tree.inorder('A')
    print()
    tree.postorder('A')
    print()
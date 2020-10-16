#https://www.acmicpc.net/problem/1991
# 20200819

import sys

class Node:
    def __init__(self, item, left, right, parent):
        self.item = item
        self.left = None
        self.right = None
        self.parent = parent

        if left != ".":
            self.left = Node(left, ".", ".", self)

        if right != ".":
            self.right = Node(right, ".", ".", self)

    def is_left(self):
        if self.left is None:
            return False
        return True

    def is_right(self):
        if self.right is None:
            return False
        return True

class Tree:
    def __init__(self):
        self.Nnode = 0
        self.root = None

    def input_nodes(self, item, left, right):
        if self.Nnode == 0:
            self.root = Node(item, left, right, None)

        else:
            node = self.traverse(self.root, item)
            if node is None:
                raise NameError

            if node.parent.is_left() and node.parent.left.item == item:
                node.parent.left = Node(item, left, right, node.parent)

            else:
                node.parent.right = Node(item, left, right, node.parent)


        self.Nnode += 1


    
    def traverse(self, node, item):
        if node.item == item:
            return node

        if node.is_left():
            result_left = self.traverse(node.left, item)
            if result_left is not None:
                return result_left

        if node.is_right():
            result_right = self.traverse(node.right, item)
            if result_right is not None:
                return result_right

        return None


    def preorder(self, node):
        print(node.item, end = '')

        if node.is_left():
            self.preorder(node.left)

        if node.is_right():
            self.preorder(node.right)

    def inorder(self, node):

        if node.is_left():
            self.inorder(node.left)

        print(node.item, end = '')

        if node.is_right():
            self.inorder(node.right)

    def postorder(self, node):

        if node.is_left():
            self.postorder(node.left)

        if node.is_right():
            self.postorder(node.right)

        print(node.item, end= '')


if __name__ == "__main__":
    Nnode = int(sys.stdin.readline())
    tree = Tree()

    for i in range(Nnode):
        item, left, right = tuple(sys.stdin.readline().split())
        tree.input_nodes(item, left, right)

    tree.preorder(tree.root)
    print()
    tree.inorder(tree.root)
    print()
    tree.postorder(tree.root)
    print()
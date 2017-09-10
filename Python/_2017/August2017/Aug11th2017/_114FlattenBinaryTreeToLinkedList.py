# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def flatten(self, root):
        """
        :type root: TreeNode
        :rtype: void Do not return anything, modify root in-place instead.
        """
        self.Node = root

        def helper(node = root):
            if node:
                helper(node.left)
                helper(node.right)
                tmp = node.right
                node.right = node.left
                head = node
                while head.right!=None:
                    head = head.right
                head.right = tmp
                node.left=None
            return

        helper()
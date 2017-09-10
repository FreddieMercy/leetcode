# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def minDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root == None:
            return 0
        left = self.minDepth(root.left)
        right = self.minDepth(root.right)

        if left and right:
            return 1 + min(left, right)

        if left:
            return left

        return right

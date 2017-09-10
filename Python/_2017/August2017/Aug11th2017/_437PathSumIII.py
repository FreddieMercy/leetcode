# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def findSame(self, root, sum):
        if root:
            return int(root.val==sum) + (self.findSame(root.left, sum-root.val) + self.findSame(root.right, sum-root.val))
        return 0
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: int
        """
        ans = 0
        if root:
            ans = self.findSame(root, sum)+ self.pathSum(root.left, sum)+self.pathSum(root.right, sum)
        return ans
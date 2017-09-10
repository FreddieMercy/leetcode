# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

#I think one of the test cases is wrong. I still think my answer is the correct one
'''
class Solution(object):
    def findTilt(self, root):

        left = 0
        right = 0
        leftR = 0
        rightR = 0

        if root == None:
        	return 0

        if root.left != None:
        	left = self.findTilt(root.left)
        	leftR = root.left.val
        if root.right != None:
        	right = self.findTilt(root.right)
        	rightR = root.right.val

        return abs(leftR-rightR) + left+right
'''
#https://discuss.leetcode.com/topic/87208/python-simple-with-explanation/2
class Solution(object):
    def findTilt(self, root):
        self.ans = 0
        def _sum(node):
            if not node: return 0
            left, right = _sum(node.left), _sum(node.right)
            self.ans += abs(left - right)
            return node.val + left + right
        _sum(root)
        return self.ans
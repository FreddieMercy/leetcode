# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None



class Solution(object):
    def str2tree(self, s):
        """
        :type s: str
        :rtype: TreeNode
        """

        #change a string like '4(2(3)(1))(6(5))' to 't(4,t(2,t(3),t(1)),t(6,t(5)))' and then just let Python evaluate that

        def t(val, left=None, right=None):
            node, node.left, node.right = TreeNode(val), left, right
            return node
        return eval('t(' + s.replace('(', ',t(') + ')') if s else None
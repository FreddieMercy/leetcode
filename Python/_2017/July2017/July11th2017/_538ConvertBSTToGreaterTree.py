# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def convertBST(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        self.sum = 0
        def stupidMakeTheDescriptionClearIdontKnowWhenToComnpareBeforeTheChangeOrAfterTheDumChange(current):
            if current == None:
                return
            if current.right != None:
                stupidMakeTheDescriptionClearIdontKnowWhenToComnpareBeforeTheChangeOrAfterTheDumChange(current.right)
            print(current.val)
            current.val += self.sum
            self.sum = current.val
            if current.left != None:
                stupidMakeTheDescriptionClearIdontKnowWhenToComnpareBeforeTheChangeOrAfterTheDumChange(current.left)

        stupidMakeTheDescriptionClearIdontKnowWhenToComnpareBeforeTheChangeOrAfterTheDumChange(root)
        return root
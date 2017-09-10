# Definition for a binary tree node.
'''
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def generateTrees(self, n):
        if n <= 0:
            return None
        nums = [x for x in range(n+1)]
        start, end = 1, len(nums[1:])-1

        def makeTrees(value = 1, index = True):
            ret = []            
            print(value)
            if (value <= 1 and not index) or value >=end:
                print("return None")
                return None

            root = TreeNode(value)
            for x in nums[1:value]:#left
                root.left = makeTrees(x, False)[0]

            for y in nums[value:]:#right
                root.right = makeTrees(y, False)[0]
                    
            if index:
                ret.append(root)

            if index:
                print("return ret")
                return ret
            print("return root")
            return [root]

        return makeTrees()

'''

#The code below from https://discuss.leetcode.com/topic/15886/should-be-6-liner shares the same idea of mine. 
#I don't wanna waste time on it anymore
class Solution(object):
    def generateTrees(self, n):
        if n <=0:
            return []
        def node(val, left, right):
            node = TreeNode(val)
            node.left = left
            node.right = right
            return node
        def trees(first, last):
            return [node(root, left, right)
                    for root in range(first, last+1)
                    for left in trees(first, root-1)
                    for right in trees(root+1, last)] or [None]
        return trees(1, n)
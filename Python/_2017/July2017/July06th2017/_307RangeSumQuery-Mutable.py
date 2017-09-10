class NumArray(object):

    def __init__(self, nums):
        """
        :type nums: List[int]
        """
        self.num = nums
        self.length = len(nums)

    def update(self, i, val):
        """
        :type i: int
        :type val: int
        :rtype: void
        """

        if i < 0 or i >= self.length:
            return
        self.num[i] = val
        

    def sumRange(self, i, j):
        """
        :type i: int
        :type j: int
        :rtype: int
        """

        if i < 0 or j >= self.length or j < i:
            return 0

        return sum(self.num[i:j+1])
'''
#https://discuss.leetcode.com/topic/30016/0-lines-python
#Awesome solution

class NumArray(object):
    def __init__(self, nums):
        self.update = nums.__setitem__
        self.sumRange = lambda i, j: sum(nums[i:j+1])

'''
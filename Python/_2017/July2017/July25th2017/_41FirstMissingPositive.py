class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ans = 1
        while True:
            if not ans in nums:
                return ans
            ans+=1
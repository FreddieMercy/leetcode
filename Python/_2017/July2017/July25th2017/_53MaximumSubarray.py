class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        length = len(nums)
        if not length:
            return 0
        localMax = nums[0]
        totalMax = localMax

        for i in range(1, length):
            if localMax < 0 and nums[i]>localMax:
                localMax = nums[i]
            elif nums[i] >=0:
                localMax+=nums[i]
            else:
                localMax+=nums[i]
            totalMax = max(totalMax, localMax)
        return totalMax 
class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        retV = []
        length = len(nums)

        for i in range(length):
            tmp = nums[:i] + nums[i+1:]
            if len(tmp) <= 1:
                retV.append([nums[i]]+tmp)
            else:
                for j in self.permute(tmp):
                    retV.append([nums[i]]+j)

        return retV
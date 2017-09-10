class Solution(object):
    def findMaxConsecutiveOnes(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ret = 0
        strs = ''.join(str(s) for s in nums)

        while len(strs) > 0:
            if strs[0] == "1":
                ret = max(ret, len(strs) - len(strs.lstrip(strs[0])))
            strs =strs.lstrip(strs[0])
        return ret

x = Solution()
print(x.findMaxConsecutiveOnes([1,1,0,1,1,1]))
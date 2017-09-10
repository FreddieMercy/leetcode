
class Solution(object):
    def canJump(self, nums):
        end = len(nums)-1
        for i in range(end, -1, -1):
            if nums[i] + i >= end:
                end = i
        return not end
   
'''
class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        m = []
        length = len(nums)
        if length<=1 or not 0 in nums[:-1]:
            return True
        if not nums[0]:
            return False
        def dfs(start = 0, dest = length):
            if start in m:
                return False
            if not nums[start]:
                m.append(start)
                return False
            end = start + nums[start]
            if end >= dest-1:
                return True
            for i in range(start+1, end+1):
                if dfs(i, dest):
                    return True
            m.append(start)
            return False
        return dfs()
'''
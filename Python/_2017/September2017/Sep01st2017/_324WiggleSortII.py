class Solution(object):
    def wiggleSort(self, nums):
        nums.sort()
        nums[0::2], nums[1::2] = nums[:len(nums)//2][::-1], nums[len(nums)//2:][::-1]
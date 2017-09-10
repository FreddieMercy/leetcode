class Solution(object):
    def subsets(self, nums):
        res = [[]]
        for num in sorted(nums):
            res += [item+[num] for item in res]
        return res

'''
class Solution(object):
    def subsets(self, num):   
        leng = len(num)
        if not leng:
            return [[]]

        if leng == 1:
            return [num, []]
 
        def helper(nums = num, length = leng):
            retV=[]
            if length > 1:
                for i in range(length):
                    tmp = nums[:i] + nums[i+1:]
                    retV.append(tmp)
                    for j in helper(tmp, len(tmp)):
                        if not j in retV:
                            retV.append(j)
            return retV
        return helper()+[num]+[[]]
'''
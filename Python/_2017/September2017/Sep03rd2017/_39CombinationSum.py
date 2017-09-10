class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        length = len(candidates)
        tmp = sorted(candidates)
        ans = []
        if not length or tmp[0] > target:
            return ans
        if target in tmp:
            ans.append([target])
            tmp.remove(target)
            length-=1
        for i in range(length):
            first = tmp[i]
            if first >target:
                break
            result = [first]
            for l in self.combinationSum(tmp[i:], target - first):
                result.extend(l)
                ans.append(result)
                result = [first]
        return ans
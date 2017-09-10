class Solution(object):
    def getRow(self, rowIndex):
        """
        :type rowIndex: int
        :rtype: List[int]
        """
        ans = [1]
        for i in range(rowIndex):
            ans.append(ans[i] * (rowIndex - i) / (i + 1))

        return ans
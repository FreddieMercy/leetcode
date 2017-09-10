class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """

        for r in matrix:
            length = len(r)
            if length > 0:
                if r[length-1] >= target and  r[0] <= target:
                    for c in r:
                        if c==target:
                            return True
                    return False
        return False
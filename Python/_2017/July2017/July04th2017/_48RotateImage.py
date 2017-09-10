class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        length = len(matrix)
        retV = []
        for i in range(length):
            row = []
            for x in reversed(matrix):
                row.append(x[i])
            retV.append(row)

        matrix[:] = retV
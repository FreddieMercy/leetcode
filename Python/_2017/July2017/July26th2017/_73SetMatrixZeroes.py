class Solution(object):
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        first = ""
        length = len(matrix)
        if not length:
            return

        if not matrix[0][0]:
            first = "ab"
        for i in range(length):
            if 0 in matrix[i]:
                for j in range(len(matrix[i])):
                    if not matrix[i][j]:
                        if not j:
                            first+="b"
                        else:
                            matrix[0][j] = 0
                if not i:
                    first+="a"
                else:
                    matrix[i][0] = 0

        for i in range(length-1, -1, -1):
            for j in range(len(matrix[i])-1, -1, -1):
                if not matrix[0][j] or not matrix[i][0]:
                    matrix[i][j] = 0

        if "a" in first:
            for i in range(len(matrix[0])):
                matrix[0][i] = 0

        if "b" in first:
            for i in range(length):
                matrix[i][0] = 0
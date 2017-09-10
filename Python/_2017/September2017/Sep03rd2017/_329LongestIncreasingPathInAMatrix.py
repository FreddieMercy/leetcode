class Solution(object):
    def longestIncreasingPath(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        self.length =len(matrix)
        if not self.length:
            return 0
        self.row = len(matrix[0])
        dp = [0]*(self.length+1)
        for i in range(self.length+1):
            dp[i] = [0]*(self.row+1)
        def dfs(i, j):
            if not dp[i][j]:
                left, right, top, bot =0,0,0,0
                if i+1<self.length and matrix[i][j] > matrix[i+1][j]:
                    bot =dfs(i+1, j)+1
                if i>0 and matrix[i][j] > matrix[i-1][j]:
                    top = dfs(i-1, j)+1
                if j+1 < self.row and matrix[i][j] > matrix[i][j+1]:
                    right = dfs(i, j+1)+1
                if j > 0 and matrix[i][j] > matrix[i][j-1]:
                    left = dfs(i, j-1)+1
                dp[i][j] = max([top,bot,left,right, 1])
            return dp[i][j]
        return max(dfs(i,j) for j in range(self.row) for i in range(self.length))
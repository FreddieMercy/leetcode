class Solution(object):
    def maximalRectangle(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        m = len(matrix)
        if not m:
            return 0
        n = len(matrix[0])
        h, l, r = [0] * n,[0] * n,[n] * n

        ans = 0
        for i in range(m):
            left = 0
            right = n
            for j in range(n):

                if matrix[i][j] == "1":
                    h[j] +=1
                    l[j] = max(l[j], left)
                else:
                    h[j] = 0
                    l[j] = 0
                    left = j+1

                if matrix[i][n-1-j] == "1":
                    r[n-1-j] = min(r[n-1-j], right)
                else:
                    r[n-1-j] = n
                    right = n-1-j

            for j in range(n):
                ans = max(ans, h[j]*(r[j] - l[j]))

        return ans


'''

class Solution(object):
    def maximalRectangle(self, matrix):
        if not matrix or not matrix[0]:
            return 0
        n = len(matrix[0])
        height = [0] * (n + 1)
        ans = 0
        for row in matrix:
            for i in xrange(n):
                height[i] = height[i] + 1 if row[i] == '1' else 0
            stack = [-1]
            for i in xrange(n + 1):
                while height[i] < height[stack[-1]]:
                    h = height[stack.pop()]
                    w = i - 1 - stack[-1]
                    ans = max(ans, h * w)
                stack.append(i)
        return ans

'''
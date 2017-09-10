class Solution(object):
    def uniquePaths(self, m, n):
        mem = []
        for row in range(m):
            mem.append([])
            for col in range(n):
                if not row or not col:
                    mem[row].append(1)
                else:
                    mem[row].append(mem[row-1][col]+mem[row][col-1])

        return mem[m-1][n-1]
#https://discuss.leetcode.com/topic/16749/7-lines-python-14-lines-java

class Solution(object):
    def numIslands(self, grid):

        def sink(i, j):
            if 0 <= i < len(grid) and 0 <= j < len(grid[i]) and grid[i][j] == '1':
                grid[i][j] = '0'
                map(sink, (i+1, i-1, i, i), (j, j, j+1, j-1))
                return 1
            return 0
        return sum(sink(i, j) for i in range(len(grid)) for j in range(len(grid[i])))

'''

class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        lengthGrid = len(grid)
        count = 0
        tracker = []

        if lengthGrid == 0:
            return 0

        while tracker != grid:

            for x in range(0, lengthGrid):
                tmp = ""
                found = False
                incre = False
                lengthOfTrackerX = 0 if x >= len(tracker) else len(tracker[x])
                for y in range(lengthOfTrackerX, len(grid[x])):

                    if grid[x][y] == "1":
                        tmp+="1"
                        if not found:
                            if x==0 or grid[x-1][y] == "0":
                                count+=1
                                incre = True
                            found = True
                        else:
                            if incre and grid[x-1][y] == "1":
                                count-=1
                        if y >= len(grid[x])-1:
                            tracker[x]+=tmp
                    else:
                        tmp+="0"

                        if y >= len(grid[x])-1 or not ((x > 0 and grid[x-1][y+1-len(tmp):y+1] =="1"*len(tmp)) or (x < lengthGrid -1 and grid[x+1][y+1-len(tmp):y+1] =="1"*len(tmp))):
                 
                            if len(tracker)>x:
                                tracker[x]+=tmp
                            else:
                                tracker.append(tmp)
                            break

        return count

x = Solution()
#print(x.numIslands(["11000","11000","00100","00011"]))

print(x.numIslands(["11110","11010","11000","00000"]))

'''
class Solution(object):
    def makesquare(self, nums):

        numberOfSide, num, total = 4, nums, sum(nums)
        side = total/4
        num.sort(reverse=True)

        if len(num) < numberOfSide or total% numberOfSide !=0 or num[0] > side:
            return False

        num = list(filter(lambda x : x != side, num))
        length = len(num)
        numberOfSide-=len(nums)-length


        if not length and not numberOfSide:
            return True

        col = [0]*numberOfSide

        def dfs(index=0):
            '''
            if all(map(lambda x : x==side, col)):
                return True

            if index >= length:
                return False
            '''

            if index >= length:
                return True

            for i in range(numberOfSide):
                tmp = col[i]+num[index]                
                if tmp > side or col[i] in col[:i]:
                    continue
                col[i]=tmp
                if dfs(index+1):
                    return True
                col[i]-=num[index]


            return False

        return dfs()
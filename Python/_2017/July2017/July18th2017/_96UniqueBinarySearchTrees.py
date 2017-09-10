class Solution(object):
    def numTrees(self, n):
        """
        :type n: int
        :rtype: int
        """
        m = {}

        def c(l = n):
            if l <= 0:
                return 1
            if l <=2:
                return l

            if l in m.keys():
                return m[l]
            j = 0
            end = l//2
            ans = 0
            for i in range(1, end+1):
                ans += c(l-i)*c(i-1)
                j+=1
            ans*=2
            if l%2 == 1:                
                ans+=c(l-end-1)*c(end)
            m[l] = ans

            return ans

        return c()

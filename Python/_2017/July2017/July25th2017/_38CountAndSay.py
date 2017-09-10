class Solution(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """

        if n <=0:
            return ""
        if n <= 2:
            return "1"*n

        ans = "21"
        for i in range(n-3):
            m = ""
            count = 0
            content = ans[0]
            for c in ans:
                if content == c:
                    count+=1
                else:
                    m+=str(count)+content
                    count = 1
                    content = c
            ans = m+str(count)+content

        return ans
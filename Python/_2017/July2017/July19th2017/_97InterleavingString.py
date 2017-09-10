class Solution(object):
    def isInterleave(self, s1, s2, s3):
        """
        :type s1: str
        :type s2: str
        :type s3: str
        :rtype: bool
        """

        m = len(s1)
        n = len(s2)
        z = len(s3)
        if z != m+n:
            return False
        mem = []
        for i in range(m+1):
            mem.append([False]*(n+1))            
        mem[0][0]=True
        cur = 0
        for x in range(m+1):
            for y in range(n+1):
                if mem[x][y] or (x - 1 >= 0 and mem[x-1][y] and s1[x-1] == s3[x+y-1]) or (y-1>=0 and mem[x][y-1] and s2[y-1] == s3[x+y-1]):
                    mem[x][y] = True
                else:
                    mem[x][y] = False 
        return mem[m][n]

'''
#Time Limit Exceed
class Solution(object):
    def isInterleave(self, s1, s2, s3):
        """
        :type s1: str
        :type s2: str
        :type s3: str
        :rtype: bool
        """
        x = 0
        y = 0
        m = len(s1)
        n = len(s2)
        z = len(s3)
        if z != m+n:
            return False
        mem = []
        for i in range(m+1):
            mem.append([False]*(n+1))            
        mem[0][0]=True
        for i in range(z):
            c = s3[i]
            if m > x and c == s1[x] and n > y and c == s2[y]:
                return self.isInterleave(s1[x+1:], s2[y:], s3[i+1:]) or self.isInterleave(s1[x:], s2[y+1:], s3[i+1:])
            if m > x and c == s1[x]:
                x+=1
            if n > y and c == s2[y]:            
                y+=1        
            mem[x][y] = True   
        return mem[m][n]
'''
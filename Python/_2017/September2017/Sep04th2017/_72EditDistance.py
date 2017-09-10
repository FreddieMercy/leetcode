class Solution(object):
    def minDistance(self, word1, word2):
        long = ""
        short = ""
        if len(word1)>len(word2):
            long = word1
            short = word2
        else:
            long = word2
            short = word1
        l = len(long)
        s = len(short)
        if not s:
            return l
        dp = [0]*(s+1)
        dp[0]=[i for i in range(l+1)]
        for i in range(1, s+1):
            dp[i]=[l]*(l+1)
            dp[i][0]=i
        for i in range(s):
            for j in range(l):
                if short[i] == long[j]:
                    dp[i+1][j+1] = min(min(dp[i + 1][j], dp[i][j]), dp[i+1][j+1])
                else:
                    dp[i + 1][j + 1] = min(min(dp[i + 1][j], dp[i][j])+1, dp[i+1][j+1])
        return dp[s][l]


'''
class Solution(object):
    def minDistance(self, word1, word2):
        length1 = len(word1)
        length2 = len(word2)
        if not length2:
            return length1
        rep = 0
        lastSame = 0
        start = 0

        tmp = word1.find(word2[0])
        dur = 0

        if dur>=??:
            start = tmp

        word = word1[start:]
        lengthW = len(word)
        length = min(length2, lengthW)
        for i in range(length):
            if word[i] == word2[i]:
                rep +=i-lastSame
                lastSame = i+1
        rep +=length-lastSame
        return rep+abs(lengthW-length2) + (length1-lengthW)
'''
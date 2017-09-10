class Solution(object):
    def longestPalindrome(self, s):
        start = 0
        end = len(s)

        if not end:
            return ""

        length = 1
        
        for i in range(end):
            if i - length -1 >=0 and s[i-length-1:i+1] == s[i-length-1:i+1][::-1]:
                start = i-length-1
                length +=2
                continue

            if i - length >=0 and s[i-length:i+1] == s[i-length:i+1][::-1]:
                start = i - length
                length+=1

        return s[start:start+length]


'''
#TLE
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        length = len(s)

        if length<=1:
            return s

        e = s[::-1]

        if s==e:
            return s

        mem = [[None for x in range(length+1)] for y in range(length+1)]
        _max = 0
        ret = {}

        for x in range(length):
            for y in range(length):
                if s[x] == e[y]:
                    if mem[x][y]== None:
                        mem[x+1][y+1] = s[x]
                    else:
                        mem[x+1][y+1] = mem[x][y]+s[x]
                    tmp = len(mem[x+1][y+1])
                    _max = max(_max, tmp)
                    ret[tmp] = mem[x+1][y+1]

        ans= ret[_max]
        if ans == ans[::-1]:
            return ans
        return s[0]
'''
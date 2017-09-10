class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        d = {'M':1000, 'D':500, 'C':100, 'L':50, 'X':10, 'V':5, 'I':1}
        ret = 0
        pre = d[m]
        for c in s:
            if pre >= d[c]:
                ret+=d[c]
                pre = d[c]
            else:
                ret+=d[c]-pre*2
                pre = d[c]-pre

        return ret
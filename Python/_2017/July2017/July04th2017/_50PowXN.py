
class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if not n:
            return 1
        stupid = x
        cof = abs(n)
        if n < 0:
            stupid = 1/stupid
        retV = 1
        bin = "{0:b}".format(cof)[::-1]
        length = len(bin)
        
        for i in range(length):
            if bin[i] == "1":
                retV *= stupid
            stupid*=stupid
        return retV

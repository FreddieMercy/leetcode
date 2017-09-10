class Solution(object):
    def generateParenthesis(self, n):
        retV = []
        def helper(s="", m=n, k=0):
            if not m and not k:
                retV.append(s)
                return
            if m > 0:
                helper(s+"(", m-1, k+1)
            if k > 0:
                helper(s+")", m, k-1)

        helper()

        return retV

'''
from math import ceil, log
class Solution(object):
    def generateParenthesis(self, n):
        
        if n <=0:
            return []
        if n == 1:
            return ["()"]
        if n == 2:
            return ["(())", "()()"]
        retV = {}
        numOfBits = "0"+str(n-1)+"b"
        for x in range(2**(n-1)):
            tmp = format(x,numOfBits)
            retV["("+tmp.replace("0", "()").replace("1", ")(")+")"]=0
            if tmp[0] == "0":
                clearZero = tmp.lstrip("0")
                clearOnes = clearZero.lstrip("1")
                length = len(clearZero)
                lengthOnes = len(clearOnes)
                numberOfZeros = len(tmp) -  length
                numberOfOnees = length - lengthOnes
                if not lengthOnes:
                    if 1+numberOfZeros>= numberOfOnees+numberOfZeros:
                        tmp = "("+tmp.replace("0", "(").replace("1", ")")+tmp.replace("1", "(").replace("0", ")")+")"
                    else:
                        tmp = "("+tmp.replace("0", ")").replace("1", "(")+tmp.replace("1", ")").replace("0", "(")+")"
                else:
                    if numberOfZeros+1>= numberOfOnees:
                        tmp = "("+tmp.replace("0", "(").replace("1", ")")+tmp.replace("1", "(").replace("0", ")")+")"
                    else:
                        tmp = "("+tmp.replace("0", ")").replace("1", "(")+tmp.replace("1", ")").replace("0", "(")+")"

                retV[tmp] = 0

        return list(retV.keys())
'''
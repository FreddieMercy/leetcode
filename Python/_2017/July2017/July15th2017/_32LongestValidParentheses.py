class Solution(object):
    def longestValidParentheses(self, k):

        s = k.lstrip(")")
        s = s.rstrip("(")

        length = len(s)
        stackl = []        
        maxl = 0
        tmpl = 0
        limitL = length-1
        stackr = []        
        maxr = 0
        tmpr = 0
        limitR = 0

        i = 0
        j = length-i-1

        for i in range(0, length):
            j = length-i-1
            if i > limitL and j < limitR:
                break
            if i <= limitL:
                x = s[i]
                if (len(stackl) == 0 and x == ")"):
                    maxl = max(maxl, tmpl)
                    tmpl = 0
                    if j >= limitR:
                        limitR = i
                elif x == ")":
                    tmpl += 2
                    stackl.pop()
                else:
                    stackl.append(x)

            if j >= limitR:
                y = s[j]
                if (len(stackr) == 0 and y == "("):
                    maxr = max(maxr, tmpr)
                    tmpr = 0
                    if i <= limitL:
                        limitL = j
                elif y == "(":
                    tmpr += 2
                    stackr.pop()
                else:
                    stackr.append(y)
        
        return max(max(maxl,maxr), min(tmpl, tmpr))
            
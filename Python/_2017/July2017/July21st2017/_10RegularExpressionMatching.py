class Solution(object):
    def isMatch(self, s, p):

        m = len(s)
        n = len(p)

        if not m and not n:
            return True

        if not n:
            return False
        if not m:
            tmp =""
            for i in range(n):
                if p[i] == "*":
                    if tmp != "" and i and p[i-1]!="*":
                        tmp = tmp[:-1]
                else:
                    tmp+=p[i]
            if not len(tmp):
                return True
            return False                

        mem = []
        for i in range(n+1):
            mem.append([False]*(m+1))            
        mem[0][0]=True
        pre = ""
        for row in range(n):
            for col in range(m):
                if mem[row][col] and s[col] == p[row]:
                    mem[row+1][col+1] = True
                    pre = s[col]
                elif p[row] == ".":
                    pre = "."
                    mem[row+1][col+1] = mem[row][col]
                elif p[row] == "*":                    
                    if (mem[row][col] or mem[row+1][col]) and (s[col] == pre or pre=="."):
                        mem[row+1][col+1] = True
                    else:
                        mem[row+1][col+1] = mem[row][col+1] or mem[row-1][col+1]
                    if not mem[row+1][col]:
                        mem[row+1][col] = mem[row][col] or mem[row-1][col]
                else:
                    pre = p[row]
        return mem[n][m]


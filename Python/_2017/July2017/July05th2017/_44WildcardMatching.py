class Solution(object):
    def isMatch(self, s, p):

        m = len(s)
        n = len(p)

        if not m and not n:
            return True

        if not n:
            return False
        if not m:
            return len(p.lstrip("*"))==0     

        if len(p.replace("*","")) > m:
            return False         

        mem = []
        for i in range(n+1):
            mem.append([False]*(m+1))            
        mem[0][0]=True
        for row in range(n):
            for col in range(m):
                if mem[row][col] and s[col] == p[row]:
                    mem[row+1][col+1] = True
                elif p[row] == "?":
                    mem[row+1][col+1] = mem[row][col]
                elif p[row] == "*":                    
                    mem[row+1][col+1] = mem[row][col+1] or mem[row][col] or mem[row+1][col]
                    if not row and not mem[row+1][col]:
                        mem[row+1][col] = mem[row+1][col+1]
                    if row:
                        mem[row+1][0] = mem[row][0]
                
        return mem[n][m]


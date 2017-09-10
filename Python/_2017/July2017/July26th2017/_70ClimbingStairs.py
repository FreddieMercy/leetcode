class Solution(object):
    def climbStairs(self, m):
        mem = {}
        def climbStair(n = m):
            if n <=0:
                return 0
            if n <=2:
                return n
            if n in mem.keys():
                return mem[n]
            mem[n]= climbStair(n-1) + climbStair(n-2)
            return mem[n]

        return climbStair()
class Solution(object):
    def reverse(self, x):
        ret = 0
        if x < 0:
            ret = -int(''.join(y for y in reversed(str(x)[1:])))
            if abs(ret+1)>>31:
                return 0
            return ret
        ret = int(''.join(y for y in reversed(str(x))))

        #if ret>2147483647:
        if ret>>31:
            return 0
        return ret

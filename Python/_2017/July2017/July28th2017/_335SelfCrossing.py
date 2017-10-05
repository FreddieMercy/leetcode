class Solution(object):
    def isSelfCrossing(self, x):
        
        for i in range(3, len(x)):
            if x[i-3]>=x[i-1]:
                if x[i]>=x[i-2]:
                    return True
                if i >= 4:
                    if x[i]+x[i-4] >= x[i-2]:
                        if x[i-3]==x[i-1]:
                            return True
                        if i >= 5:
                            if x[i-3]<=x[i-1]+x[i-5] and x[i-2]-x[i-4]>=0 and x[i-1]<=x[i-3]:
                                return True
                        
        return False

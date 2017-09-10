class Solution(object):
    def largestRectangleArea(self, heights):
        high, low, save, j, length = 0,0,0,0,len(heights)
        while j < length:
            i = heights[j]
            if i == high:
                low+=1
            elif i > high:
                if high:
                    Biggers = []
                    index = 0
                    incre = True
                    while i >= high and j < length:
                        if i < heights[j-1]:
                            incre = False
                        Biggers.append(i)
                        j+=1
                        index+=1
                        if j < length:
                            i = heights[j]
                    low+=index
                    fur = 0
                    if incre:
                        fur = self.largestRectangleArea([x for x in reversed(Biggers)])
                    elif sum(Biggers) > high*low:
                        fur = self.largestRectangleArea(Biggers)
                    if high * low < fur:
                        save = max(save, fur)
                    continue
            else:
                    save = max(save, low*high)
                    low +=  1 
                    high = i
                    
            if high * low <= i:
                high = i
                low = 1
            j+=1
        return max(high*low, save)

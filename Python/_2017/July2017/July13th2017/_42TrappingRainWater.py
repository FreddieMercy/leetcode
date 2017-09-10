class Solution(object):
    def trap(self, height):

        actuall = 0
        actualr = 0
        total = 0
        left = 0
        right = len(height) - 1
        
        while left < right:
            actuall = max(actuall, height[left])
            actualr = max(actualr, height[right])
            #waiting = max(actuall, actualr)

            if actuall <= actualr:
                total += actuall - height[left]
                #print("at location left = "+str(left)+", actuall is "+str(actuall)+" and height["+str(left)+"] = "+str(height[left])+", total + "+str(actuall - height[left])+" = "+str(total))
                left+=1
                
            if actualr <= actuall:
                total += actualr - height[right]
                #print("at location right = "+str(right)+", actualr is "+str(actualr)+" and height["+str(right)+"] = "+str(height[right])+", total + "+str(actualr - height[right])+" = "+str(total))
                right-=1
        #print("at end, left = "+str(left)+", and right = "+str(right)+", total = "+str(total))
        if left==right and height[left] < actuall and height[right]<actualr:
            tmp = min(actuall, actualr)
            total += tmp-height[left]
        return total

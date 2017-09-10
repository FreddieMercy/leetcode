
class Solution(object):
    def divide(self, dividend, divisor):
        if not divisor:
            return 0
        if not dividend:
            return 0
        num = abs(dividend)
        din = abs(divisor)
        ans = 0
        while num >= din:
            temp, i = din, 1
            while num >= temp:
                num -= temp
                ans += i
                i <<= 1
                temp <<= 1
            
        if (divisor < 0 and dividend < 0) or (dividend>0 and divisor>0):
            if ans>>31:
                return 2**31-1
            return ans

        if ans >= 2**31:
            return -(2**31)
        return -ans

'''
class Solution(object):
    def divide(self, dividend, divisor):
        """
        :type dividend: int
        :type divisor: int
        :rtype: int
        """
        if not divisor:
            return 0
        if not dividend or dividend < divisor:
            return 0
        num = format(str(abs(dividend)),"032")
        din = format(str(abs(divisor)), "032")
        if num[0] == "1" or din[0] == "1":
            return 2**31-1
        retV = "0"        
        length = len(din)
        for i in range(len(num)-length):
            if int(num[i:i+length],2) >= int(din,2):
                tmp = int(num[i:i+length],2)
                tmp -= divisor
                num = num[:i]+format(str(tmp),"0"+str(length)+"b")+num[i+length:]
                retV+="1"
            else:
                retV+="0"

        ans = int(retV, 2)
        if (divisor < 0 and dividend < 0) or (dividend>0 and divisor>0):
            return ans
        return -ans
'''
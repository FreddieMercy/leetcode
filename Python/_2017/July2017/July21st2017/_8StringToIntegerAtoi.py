class Solution(object):
    def myAtoi(self, str):

        num = "0123456789"
        x = str.lstrip()
        x = x.rstrip()
        s = ""

        for c in x:
            if c in num:
                s+=c
            else:
                if (c == "-" or c == "+") and s=="":

                    s+=c
                else:
                    break;
        try:
            tmp = int(s)
            if tmp < 0:
                if abs(tmp+1)>>31:
                    return -(2**31-1)-1
                return tmp
            else:
                if tmp>>31:
                    return 2**31-1
                return tmp
        except:
            return 0
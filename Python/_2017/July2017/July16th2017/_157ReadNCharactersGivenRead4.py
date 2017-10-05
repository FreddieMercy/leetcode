# The read4 API is already defined for you.
# @param buf, a list of characters
# @return an integer
def read4(buf):
    return

class Solution:
    def read(self, buf, n):
        idx = 0
        while True:
            buf4 = [""]*4
            curr = min(read4(buf4),n-idx)  # curr is the number of chars that reads
            for i in range(curr):
                buf[idx] = buf4[i]
                idx+=1
            if curr!=4 or idx==n:  # return if it reaches the end of file or reaches n
                return idx
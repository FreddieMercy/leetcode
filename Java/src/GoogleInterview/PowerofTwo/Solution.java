package GoogleInterview.PowerofTwo;

public class Solution {
    public boolean isPowerOfTwo(int n) {
        while (n > 0) {
            if (n == 1)
                return true;

            if ((n & 1) == 0)
                n = n >>> 1;
            else
                return false;

        }

        return false;
    }
}
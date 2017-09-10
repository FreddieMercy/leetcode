using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Leetcode._2017.August2017.Aug28th2017._334IncreasingTripletSubsequence
{
    public class Solution
    {
        private int[] dp = new int[] { int.MaxValue, int.MaxValue};
        private bool Add(int value, int index = 0)
        {
            if(index >= 2)
            {
                return true;
            }

            if (value<dp[index])
            {
                dp[index] = value;
            }
            else if (value > dp[index])
            {
                return Add(value, index + 1);
            }

            return false;
        }
        public bool IncreasingTriplet(int[] nums)
        {
            foreach(int i in nums){
                if (Add(i))
                {
                    return true;
                }
            }
            return false;
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Leetcode._2017.August2017.Aug30th2017._322CoinChange
{
    public class Solution
    {
        public int CoinChange(int[] coins, int amount)
        {
            int[] dp = new int[amount + 1];
            for(int i = 1; i < dp.Length; ++i)
            {
                dp[i] = amount + 1;
                foreach (int j in coins)
                {
                    if (i >= j)
                    {
                        dp[i] = Math.Min(dp[i], dp[i - j] + 1);
                    }
                }
            }
            return (dp[amount] > amount) ? -1 : dp[amount];
        }
    }

            /*
            public class Solution
            {
                private int[] SubArray(int[] source, int start, int end)
                {
                    int[] result = new int[end - start];
                    Array.Copy(source, 0, result, 0, end);
                    return result;
                }
                public int CoinChange(int[] coins, int amount, bool sorted = false)
                {
                    if (!sorted)
                    {
                        Array.Sort(coins);
                    }
                    if (coins.Length == 0 || coins[coins.Length-1]==0)
                    {
                        return -1;
                    }
                    int nums = amount/ coins[coins.Length - 1];
                    if (0 == amount% coins[coins.Length - 1])
                    {
                        return nums;
                    }
                    int tmp = this.CoinChange(SubArray(coins, 0, coins.Length - 1), amount - nums * coins[coins.Length - 1], true);
                    while (tmp < 0 && nums > 0)
                    {
                        nums--;
                        tmp = this.CoinChange(SubArray(coins, 0, coins.Length - 1), amount - nums * coins[coins.Length - 1], true);
                    }
                    return tmp + nums;
                }
            }
            */
        }

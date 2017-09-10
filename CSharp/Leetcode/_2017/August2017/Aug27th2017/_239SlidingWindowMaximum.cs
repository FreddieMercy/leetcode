using System;
using System.Collections.ObjectModel;
using System.Collections.Generic;
using System.Collections;
namespace Leetcode._2017.August2017.Aug27th2017._239SlidingWindowMaximum
{
    public class Solution
    {
        public int[] MaxSlidingWindow(int[] nums, int k)
        {
            List<int> res = new List<int>();
            var list = new LinkedList<int>();
            for (int i = 0; i < nums.Length; i++)
            {
                if (list.Count > 0 && list.First.Value == i - k)
                {
                    list.RemoveFirst();
                }
                while (list.Count > 0 && nums[list.Last.Value] < nums[i])
                {
                    list.RemoveLast();
                }
                list.AddLast(i);
                if (i >= k - 1)
                {
                    res.Add(nums[list.First.Value]);
                }
            }
            return res.ToArray();
        }
    }
}
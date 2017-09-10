using System;
using System.Collections.ObjectModel;
using System.Collections.Generic;

namespace Leetcode._2017.August2017.Aug09th2017._215KthLargestElementInAnArray
{
	public class Solution
	{
		public int FindKthLargest(int[] nums, int k)
		{
            Array.Sort(nums);
            Array.Reverse(nums);
            return nums[k - 1];
		}
	}
}
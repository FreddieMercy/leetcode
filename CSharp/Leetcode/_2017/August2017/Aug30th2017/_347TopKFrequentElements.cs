using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Leetcode._2017.August2017.Aug30th2017._347TopKFrequentElements
{
    public class Solution
    {
        private class compPairs : IComparer<IGrouping<int,int>>
        {
            public int Compare(IGrouping<int, int> a, IGrouping<int, int> b)
            {
                if (b.Count() != a.Count())
                {
                    return b.Count() - a.Count();
                }
                return a.Key - b.Key;
            }
        }
        public IList<int> TopKFrequent(int[] nums, int k)
        {
            IList<int> ans = new List<int>();
            SortedSet<IGrouping<int,int>> s = new SortedSet<IGrouping<int,int>>(new compPairs());
            var groups = nums.GroupBy(item => item);
            foreach (var group in groups)
            {
                s.Add(group);
            }
            while (k > 0)
            {
                IGrouping<int,int> value = s.Min;
                while (s.Count()>0&&value.Count() == s.Min.Count())
                {
                    ans.Add(s.Min.Key);
                    s.Remove(s.Min);
                    k--;
                }
            }
            return ans;
        }
    }
}

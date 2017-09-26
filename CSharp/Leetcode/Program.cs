using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Leetcode._2017.August2017.Aug30th2017._347TopKFrequentElements;

namespace Leetcode
{
    class Program
    {
        private class sortAscendingHelper : IComparer<int[]>
        {
            public int Compare(int[] a, int[] b)
            {
                return a[0] - b[0];
            }
        }
        private class sortAscendingHelper2 : IComparer<Int16>
        {
            public int Compare(Int16 a, Int16 b)
            {
                return a - b;
            }
        }

        static void Main(string[] args)
        {
            Solution x = new Solution();
            Console.WriteLine(x.TopKFrequent(new int[] { 1 }, 1));
            SortedSet<int[]> s = new SortedSet<int[]>(new sortAscendingHelper());
            int[] tmp = new int[1];
            for (int i = 1; i < 100; ++i)
            {
                tmp[0] = i;
                s.Add(tmp);
            }
            Int16[] sth = new Int16[100];
            SortedSet<Int16> j = new SortedSet<Int16>(new sortAscendingHelper2());
            for (int i = 1; i < 100; ++i)
            {
                sth[i] = (Int16)i;
                j.Add(sth[i]);
            }
            sth[0] = 100;
            return;
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Leetcode._2017.August2017.Aug28th2017._341FlattenNestedListIterator
{

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger
    {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        bool IsInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        int GetInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        IList<NestedInteger> GetList();
    }

    public class NestedIterator
    {
        private class Integer
        {
            private int value;
            public Integer(int i)
            {
                value = i;
            }
            public int GetInteger()
            {
                return value;
            }
        }
        private IList<NestedInteger> list = null;
        private Integer integer = null;
        public NestedIterator(IList<NestedInteger> nestedList)
        {
            list = nestedList;
        }
        private void findFirstInteger()
        {
            while (list.Count>0 && integer==null)
            {
                NestedInteger tmp = list[0];
                if (tmp.IsInteger())
                {
                    integer = new Integer(tmp.GetInteger());
                    list.Remove(tmp);
                }
                else
                {
                    if (tmp.GetList()==null||tmp.GetList().Count == 0)
                    {
                        list.Remove(tmp);
                    }
                    else
                    {
                        NestedIterator i = new NestedIterator(tmp.GetList());
                        if (i.HasNext())
                        {
                            integer = new Integer(i.Next());
                        }
                    }
                }
            }
        }
        public bool HasNext()
        {
            this.findFirstInteger();
            return integer != null;
        }

        public int Next()
        {
            int tmp = integer.GetInteger();
            integer = null;
            return tmp;
        }
    }

    /**
     * Your NestedIterator will be called like this:
     * NestedIterator i = new NestedIterator(nestedList);
     * while (i.HasNext()) v[f()] = i.Next();
     */
}

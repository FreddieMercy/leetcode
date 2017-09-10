using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Leetcode._2017.August2017.Aug28th2017._328OddEvenLinkedList
{
    // Definition for singly-linked list.
    public class ListNode
    {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }

    public class Solution
    {
        public ListNode OddEvenList(ListNode head)
        {
            if (head != null)
            {
                ListNode tmpOdd = head;
                ListNode Even = head.next;
                ListNode tmpEven = Even;
                while (tmpOdd != null && tmpOdd.next != null && tmpOdd.next.next != null)
                {
                    tmpOdd.next = tmpOdd.next.next;
                    tmpEven.next = tmpEven.next.next;
                    tmpOdd = tmpOdd.next;
                    if (tmpEven.next != null)
                    {
                        tmpEven = tmpEven.next;
                    }
                }
                tmpOdd.next = Even;
            }
            return head;
        }
    }
}

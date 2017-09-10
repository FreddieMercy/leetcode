using System;
using System.Collections.ObjectModel;
using System.Collections.Generic;
using System.Collections;
namespace Leetcode._2017.August2017.Aug27th2017._237DeleteNodeInALinkedList
{
	 // Definition for singly-linked list.
	  public class ListNode {
	      public int val;
	      public ListNode next;
	      public ListNode(int x) { val = x; }
	  }
	 
	public class Solution
	{
		public void DeleteNode(ListNode node)
		{
            if(node.next!=null){
                node.val = node.next.val;
                node.next = node.next.next;
            }
		}
	}
}

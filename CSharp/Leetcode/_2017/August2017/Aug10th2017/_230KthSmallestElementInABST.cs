using System;
using System.Collections.ObjectModel;
using System.Collections.Generic;
using System.Collections;
namespace Leetcode._2017.August2017.Aug10th2017._230KthSmallestElementInABST
{
    //  Definition for a binary tree node.
    public class TreeNode
    {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public class Solution
    {
        public int KthSmallest(TreeNode root, int k)
        {
            TreeNode tmp = root;
            List<TreeNode> l = new List<TreeNode>();
            int i = 0;
            while (i < k)
            {
                if (l.Count != 0 && tmp.right != null)
                {
                    l.Remove(tmp);
                    tmp = tmp.right;
                }
                while (tmp != null && !l.Contains(tmp))
                {
                    l.Add(tmp);
                    tmp = tmp.left;
                }
                l.Remove(tmp);
                tmp = l[l.Count - 1];
                i++;
            }
            return tmp.val;
        }
    }
}

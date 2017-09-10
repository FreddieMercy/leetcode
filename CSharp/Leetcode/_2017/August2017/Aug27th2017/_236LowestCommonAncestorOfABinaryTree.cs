using System;
using System.Collections.ObjectModel;
using System.Collections.Generic;
using System.Collections;
namespace Leetcode._2017.August2017.Aug27th2017._236LowestCommonAncestorOfABinaryTree
{
	 // Definition for a binary tree node.
	  public class TreeNode {
	     public int val;
	      public TreeNode left;
	      public TreeNode right;
	      public TreeNode(int x) { val = x; }
	 }

	public class Solution
	{
		public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
		{
            if(root == p || root == q||root==null){
                return root;
            }
            TreeNode left = LowestCommonAncestor(root.left, p, q);
            TreeNode right = LowestCommonAncestor(root.right, p, q);
            if(left==null&&right == null){
                return null;
            }
            if(left == null || right == null){
                return (left != null) ? left : right;
            }
            return root;
		}
	}
}

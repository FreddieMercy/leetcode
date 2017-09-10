using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Leetcode._2017.August2017.Aug30th2017._226InvertBinaryTree
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
        public TreeNode InvertTree(TreeNode root)
        {
            if (root == null)
            {
                return root;
            }
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;

            this.InvertTree(root.left);
            this.InvertTree(root.right);
            return root;
        }
    }
}

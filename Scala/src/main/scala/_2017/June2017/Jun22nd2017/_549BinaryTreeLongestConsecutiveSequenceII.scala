package _2017.June2017.Jun22nd2017
import scala.collection.mutable.SortedSet
import scala.collection.mutable.HashMap
import scala.collection.mutable.ListBuffer

class _549BinaryTreeLongestConsecutiveSequenceII {

  // Definition for a binary tree node.
  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
  }

  object Solution {
    private var maxval = 0

    def longestConsecutive(root: TreeNode): Int = {
      maxval = 0
      longestPath(root)
      return maxval
    }

    def longestPath(root: TreeNode): Array[Int] = {
      if (root == null) return Array[Int](0, 0)
      var inr = 1
      var dcr = 1
      if (root.left != null) {
        val l = longestPath(root.left)
        if (root.value == root.left.value + 1) dcr = l(1) + 1
        else if (root.value == root.left.value - 1) inr = l(0) + 1
      }
      if (root.right != null) {
        val r = longestPath(root.right)
        if (root.value ==  root.right.value + 1) dcr = Math.max(dcr, r(1) + 1)
        else if (root.value ==  root.right.value - 1) inr = Math.max(inr, r(0) + 1)
      }
      maxval = Math.max(maxval, dcr + inr - 1)
      return Array[Int](inr, dcr)
    }
  }
/*
  object Solution {
    private var ret = 0
    private def update(v: TreeNode, r:Int, tree : HashMap[Int, SortedSet[Int]], nodetoRoot : HashMap[Int, Int]): Unit = {

      val tmp = tree(nodetoRoot(r))
      tmp += v.value
      tree.put(nodetoRoot(r), tmp)
      ret = Math.max(ret, tmp.size)
      nodetoRoot.put(v.value, nodetoRoot(r))
      nodetoRoot.remove(r)
      dfs(v.left, tree.clone(), nodetoRoot.clone())
      dfs(v.right, tree.clone(), nodetoRoot.clone())
    }

    private def dfs(head : TreeNode, tree : HashMap[Int, SortedSet[Int]]=HashMap[Int, SortedSet[Int]](), nodetoRoot : HashMap[Int, Int]=HashMap[Int, Int]()): Unit = {
      if(head != null) {
        val h: Int = head.value - 1
        val t: Int = head.value + 1

        if (nodetoRoot.keySet.exists(x => x == h)) {
          println("value is "+head.value+", found head. ")
          update(head, h, tree, nodetoRoot)
        }
        else if (nodetoRoot.keySet.exists(x => x == t)) {
          println("value is "+head.value+", found tail. ")
          update(head, t, tree, nodetoRoot)
        }
        else {
          println("value is "+head.value+", found nothing")
          ret = Math.max(1, ret)
          val NewNodetoRoot = HashMap[Int, Int](head.value -> head.value)
          val NewTree : HashMap[Int, SortedSet[Int]]=HashMap[Int, SortedSet[Int]](head.value-> SortedSet[Int](head.value))
          dfs(head.left, NewTree.clone(), NewNodetoRoot.clone())
          dfs(head.right, NewTree.clone(), NewNodetoRoot.clone())
        }
      }

    }

    def longestConsecutive(root: TreeNode): Int = {
      ret = 0
      dfs(root)
      return ret
    }
  }
  */
}

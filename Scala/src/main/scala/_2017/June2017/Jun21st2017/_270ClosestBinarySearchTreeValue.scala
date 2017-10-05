package _2017.June2017.Jun21st2017

class _270ClosestBinarySearchTreeValue {

    // Definition for a binary tree node.
     class TreeNode(var _value: Int) {
       var value: Int = _value
       var left: TreeNode = null
       var right: TreeNode = null
     }

  object Solution {
    def closestValue(root: TreeNode, target: Double): Int = {
      var ret = root.value
      var head = root
      while ( head != null) {
        if (Math.abs(target - head.value) < Math.abs(target - ret)){
          ret = head.value
        }
        head = if (head.value > target) head.left else head.right
      }

      return ret
    }
  }
}

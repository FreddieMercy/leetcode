//
//  _663EqualTreePartition.swift
//  leetcode
//
//  Created by Junhao Zhang on 10/3/17.
//  Copyright © 2017 Junhao Zhang. All rights reserved.
//

import Foundation

class _663EqualTreePartition{
    
    //Definition for a binary tree node.
      public class TreeNode {
          public var val: Int
          public var left: TreeNode?
          public var right: TreeNode?
          public init(_ val: Int) {
              self.val = val
              self.left = nil
              self.right = nil
          }
      }
    
    class Solution {
        private func getsum(_ root:TreeNode?, _ map : inout [Int:Int] )->Int{
            if root == nil{
                return 0
            }
            
            let cur : Int = root!.val + getsum(root!.left, &map) + getsum(root!.right, &map)
            map[cur] = (map[cur] ?? 0) + 1
        
            return cur
        }
        
        func checkEqualTree(_ root: TreeNode?) -> Bool {
            var map : [Int:Int] = [:]
            let sum : Int = getsum(root!, &map);
            if sum == 0{
                return (map[sum] ?? 0) > 1
            }
            
            return sum%2 == 0 && (map[sum/2] != nil)
        }
    }
    /*
    class Solution {
        func checkEqualTree(_ root: TreeNode?) -> Bool {
            guard let root = root else { return false}
            
            var sums = Set<Int>()
            guard let totalSum = findSum(root, &sums, true) else { return false }
            
            return (totalSum % 2 == 0) ? sums.contains(totalSum / 2) : false
        }
        
        func findSum(_ root: TreeNode?, _ sumSet: inout Set<Int>, _ isRoot: Bool = false) -> Int? {
            guard let root = root else {
                return nil
            }
            var sum = root.val
            if let lsum = findSum(root.left, &sumSet) {
                sum += lsum
            }
            if let rsum = findSum(root.right, &sumSet) {
                sum += rsum
            }
            if !isRoot {
                sumSet.insert(sum)
            }
            return sum
        }
    }
    */
}

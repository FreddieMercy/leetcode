//
//  _545BoundaryOfBinaryTree.swift
//  leetcode
//
//  Created by Junhao Zhang on 10/3/17.
//  Copyright © 2017 Junhao Zhang. All rights reserved.
//

import Foundation

class _545BoundaryOfBinaryTree{
    
     // Definition for a binary tree node.
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
        
        private func isLeaf(_ t:TreeNode)->Bool {
            return t.left == nil && t.right == nil
        }
        
        private func addLeaves(_ res: inout [Int], _ root:TreeNode)->Void {
        
            if isLeaf(root) {
                res.append(root.val)
            }
            
            else {
                if root.left != nil {
                    addLeaves(&res, root.left!)
                }
                if root.right != nil {
                    addLeaves(&res, root.right!)
                }
            }
        }
        
        func boundaryOfBinaryTree(_ root: TreeNode?) -> [Int] {
            var res = [Int]()
            if root == nil {
                return res
            }
            if !isLeaf(root!) {
                res.append(root!.val)
            }
            
            var t = root!.left
            
            while t != nil {
                if !isLeaf(t!) {
                    res.append(t!.val)
                }
                if t!.left != nil {
                    t = t!.left
                } else {
                    t = t!.right
                }
                
            }
            addLeaves(&res, root!)
            var s = [Int]()
            t = root!.right
            while t != nil {
                if !isLeaf(t!) {
                    s.append(t!.val)
                }
                
                if t!.right != nil {
                    t = t!.right
                }
                else {
                    t = t!.left
                }
            }
            while s.count > 0 {
                res.append(s.popLast()!)
            }
            
            return res
        }
    }
}

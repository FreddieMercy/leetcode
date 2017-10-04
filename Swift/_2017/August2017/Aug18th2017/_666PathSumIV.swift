//
//  _666PathSumIV.swift
//  leetcode
//
//  Created by Junhao Zhang on 10/3/17.
//  Copyright © 2017 Junhao Zhang. All rights reserved.
//

import Foundation

class _666PathSumIV{
    class Solution {
        private var sum : Int = 0
        private var tree : [Int:Int] = [:]
        
        func pathSum(_ nums: [Int]) -> Int {
            if nums.count > 0{
                for i in nums{
                    tree[Int(i / 10)] = Int(i%10)
                }
                traverse(nums[0] / 10, 0)
            }
            return sum
        }
        
        private func traverse(_ root:Int, _ preSum:Int)->Void {
        let level = Int(root / 10)
        let pos = Int(root % 10)
        let left = Int((level + 1) * 10 + pos * 2 - 1)
        let right = Int((level + 1) * 10 + pos * 2)
        
        let curSum = Int(preSum + tree[root]!)
        
        if tree[left]==nil && tree[right]==nil {
            sum += curSum;
            return;
        }
        
            if tree[left] != nil {
                traverse(left, curSum)
            }
            
            if tree[right] != nil {
                traverse(right, curSum)
            }
        }
    }
}

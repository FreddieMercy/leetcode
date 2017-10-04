//
//  _644MaximumAverageSubarrayII.swift
//  leetcode
//
//  Created by Junhao Zhang on 9/29/17.
//  Copyright © 2017 Junhao Zhang. All rights reserved.
//

import Foundation

class _644MaximumAverageSubarrayII{
    class Solution {
        func findMaxAverage(_ nums: [Int], _ k: Int) -> Double {
            var max_val : Double = Double(UInt8.min)
            var min_val : Double = Double(UInt8.max)
            
            for i in nums {
                max_val = max(max_val, Double(i))
                min_val = min(min_val, Double(i))
            }
            
            var prev_mid : Double = max_val, error : Double = Double(UInt8.max)
            
            while error > 0.00001 {
                let mid : Double = (max_val + min_val) * 0.5
                if check(nums, mid, k){
                    min_val = mid
                }
                else{
                    max_val = mid
                }
                error = abs(prev_mid - mid)
                prev_mid = mid
            }
            
            return min_val
        }
        
        private func check(_ nums:[Int], _ mid:Double, _ k:Int)->Bool {
            var sum:Double = 0, prev:Double = 0, min_sum:Double = 0
            if k-1 > 0{
                for i in 0...k-1{
                    sum += Double(nums[i]) - mid
                }
            }
            else if k-1 == 0{
                sum = Double(nums[0]) - mid
            }
            if sum >= 0{
                return true
            }
            
            if nums.count-1 > k{
                for i in k...nums.count-1 {
                    sum += Double(nums[i]) - mid
                    prev += Double(nums[i - k]) - mid
                    min_sum = min(prev, min_sum)
                    
                    if sum >= min_sum{
                        return true
                    }
                }
            }
                
            else if nums.count-1 == k{
                sum += Double(nums[k]) - mid
                prev += Double(nums[0]) - mid
                min_sum = min(prev, min_sum)
                if sum >= min_sum{
                    return true
                }
            }
            
            return false
        }
    }
}

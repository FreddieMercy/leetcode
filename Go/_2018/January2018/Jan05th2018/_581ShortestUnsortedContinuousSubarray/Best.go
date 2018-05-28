package go581ShortestUnsortedContinuousSubarray_Best

import (
	"math"
)

func findUnsortedSubarray(nums []int) int {
    //Forward sweep
    foundPeak := false
    min := math.MaxInt32
    for i :=0; i< len(nums); i++ {
        if foundPeak {
            if nums[i] < min {
                min = nums[i]
            }   
        } else {
            if (i+1) < len(nums) && nums[i+1] < nums[i] {
                foundPeak = true
            }
        }
    }
    
    if !foundPeak {
        return 0
    }
    
    //Backward Sweep
    foundValley := false
    max := math.MinInt32
    for i := len(nums)-1; i>=0;i-- {
        if foundValley {
            if nums[i] > max {
                max = nums[i]
            }
        } else {
            if (i-1) >=0 && nums[i-1] > nums[i] {
                foundValley = true
            }
        }
    }
    
    var minIndex, maxIndex int
    for i,num := range nums {
        if num > min {
            minIndex = i
            break
        }
    }
    for i:=len(nums)-1;i>=0;i-- {
        if nums[i] < max {
            maxIndex = i
            break
        }
    }
    return maxIndex-minIndex+1
}
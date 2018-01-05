package go581ShortestUnsortedContinuousSubarray

func findUnsortedSubarray(nums []int) int {
	if len(nums) <= 1 {
		return 0
	}

	i := 0
	var j int = len(nums) - 1
	var ans int = len(nums)

	for i < j && nums[i] <= nums[i+1] {
		i++
		ans -= 1
	}

	for i < j && nums[i] <= nums[j] && nums[j] >= nums[j-1] {
		j--
		ans -= 1
	}
	if i == j && nums[i] <= nums[j] {
		ans--
	}
	return ans
}

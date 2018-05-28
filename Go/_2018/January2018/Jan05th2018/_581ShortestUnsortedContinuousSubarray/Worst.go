package go581ShortestUnsortedContinuousSubarray_Worst

import (
	"sort"
)

func findUnsortedSubarray(nums []int) int {
	arr := make([]int, len(nums))
	copy(arr, nums)
	sort.Ints(arr)

	m, n := 0, len(nums)-1

	for m <= n && (nums[m] == arr[m] || nums[n] == arr[n]) {
		if nums[m] == arr[m] {
			m++
		}

		if nums[n] == arr[n] {
			n--
		}
	}

	if m-n > 0 {
		return 0
	}

	return n - m + 1
}

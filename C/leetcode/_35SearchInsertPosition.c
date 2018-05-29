#include <stdlib.h>

int searchInsert(int* nums, int numsSize, int target) {
	int left = 0;
	int right = numsSize;
	while (left < right)
	{
		int mid = (right - left) / 2 + left;

		if (*(nums + mid) == target) {
			return mid;
		}

		if (*(nums + mid) < target) {
			left = mid+1;
		}
		else {
			right = mid;
		}
	}
	return left;
}
func search(nums []int, target int) int {
	l := 0
	r := len(nums) - 1
	for l < r {
		m := l + (r - l) / 2
		if nums[m] > nums[r] {
			l = m + 1
		} else {
			r = m
		}
	}

	pivot := l

	if target >= nums[pivot] && target <= nums[len(nums)-1] {
		left := pivot
		right := len(nums) - 1
		for left <= right {
			mid := left + (right-left)/2
			if nums[mid] == target {
				return mid
			}

			if nums[mid] < target {
				left = mid + 1
			} else {
				right = mid - 1
			}
		}
	} else {
		left := 0
		right := pivot - 1
		for left <= right {
			mid := left + (right-left)/2
			if nums[mid] == target {
				return mid
			}

			if nums[mid] < target {
				left = mid + 1
			} else {
				right = mid - 1
			}
		}
	}

	return -1
}
func threeSum(nums []int) [][]int {
	ans := [][]int{}
	sort.Ints(nums)

	for idx, k := range nums {
		if idx > 0 && nums[idx] == nums[idx-1] {
			continue
		}
		i := idx + 1
		j := len(nums) - 1
		for i < j {
			sum := k + nums[i] + nums[j]
			if sum > 0 {
				j--
			} else if sum < 0 {
				i++
			} else {
				option := []int{k, nums[i], nums[j]}
				ans = append(ans, option)
				i++
				j--
				for i < j && nums[i] == nums[i-1] {
					i++
				}

				for i < j && nums[j] == nums[j+1] {
					j--
				}
			}
		}
	}
	return ans
}

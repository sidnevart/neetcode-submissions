func productExceptSelf(nums []int) []int {
	product := 1
	result := make([]int, len(nums))
	zeroIdx := 0
	zeroCnt := 0
	for idx, num := range nums {
		if num == 0 {
			zeroIdx = idx
			zeroCnt += 1
		}
	}
	if zeroCnt == 0 {
		for _, num := range nums {
			product *= num
		}
		i := 0
		for i < len(nums) {
			result[i] = product / nums[i]
			i++
		}
	} else {
		if zeroCnt < 2 {
			for idx, num := range nums{
				if idx != zeroIdx {
					product *= num
					result[idx] = 0
				} else {
					continue 
				}
			}
			result[zeroIdx] = product
		} else {
			for i, _ := range nums {
				result[i] = 0
			}
		}
	}

	return result
}




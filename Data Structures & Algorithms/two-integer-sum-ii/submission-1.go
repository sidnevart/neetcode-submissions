func twoSum(numbers []int, target int) []int {
	left := 0
	right := len(numbers) - 1
	ans := []int{}

	for left < right {
		if numbers[left] + numbers[right] > target {
			right--
			continue 
		} else if numbers[left] + numbers[right] < target {
			left++
			continue 
		} else {
			ans = append(ans, left + 1)
			ans = append(ans, right + 1)
			break
		}

	}

	return ans
}

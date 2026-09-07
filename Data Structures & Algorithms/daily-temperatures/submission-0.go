func dailyTemperatures(temperatures []int) []int {
	ans := make([]int, len(temperatures))
	stack := []int{}
	
	for idx := 0; idx < len(temperatures); idx++ {
		for len(stack) > 0 && temperatures[idx] > temperatures[stack[len(stack) - 1]] {
			oldIdx := stack[len(stack) - 1]
			ans[oldIdx] = idx - oldIdx
			stack = stack[:len(stack) - 1]
		}

		stack = append(stack, idx)
	}

	return ans
}

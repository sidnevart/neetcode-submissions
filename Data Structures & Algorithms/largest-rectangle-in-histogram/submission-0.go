func largestRectangleArea(heights []int) int {
	stack := [][]int{} // start, height
	maxArea := 0

	for i := 0; i < len(heights); i++ {
		curHeight := heights[i]
		start := i

		for len(stack) > 0 &&
			stack[len(stack)-1][1] > curHeight {

			popped := stack[len(stack)-1]
			stack = stack[:len(stack)-1]

			start = popped[0]

			area := popped[1] * (i - popped[0])
			maxArea = max(maxArea, area)
		}

		stack = append(stack, []int{start, curHeight})
	}

	// всё, что осталось, может тянуться до конца массива
	for len(stack) > 0 {
		popped := stack[len(stack)-1]
		stack = stack[:len(stack)-1]

		area := popped[1] * (len(heights) - popped[0])
		maxArea = max(maxArea, area)
	}

	return maxArea
}
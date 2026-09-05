func maxArea(heights []int) int {
	left := 0
	right := len(heights) - 1
	maxA := 0
	for left < right {
		area := min(heights[left], heights[right]) * (right - left)
		if area > maxA {
			maxA = area
		}
		if heights[left] < heights[right] {
			left++
		} else {
			right--
		}
	}
	return maxA
}


func trap(height []int) int {
	l := 0
	r := len(height) - 1

	leftMax := 0
	rightMax := len(height) - 1
	water := 0

	for l < r {
		if height[l] < height[r] {
			if height[l] > height[leftMax] {
				leftMax = l
			} else {
				water += height[leftMax] - height[l]
			}
			l++
		} else {
			
			if height[r] > height[rightMax]{
				rightMax = r
			} else {
				water += height[rightMax] - height[r]
			}
			r--
		}
	}
	return water
}

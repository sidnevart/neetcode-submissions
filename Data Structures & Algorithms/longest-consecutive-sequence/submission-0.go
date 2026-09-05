func longestConsecutive(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	seen := make(map[int]bool)
	for _, n := range nums {
		seen[n] = true
	}

	longest := 0

	for num := range seen {
		if !seen[num-1] {
			current := num
			length := 0
			for seen[current] {
				length++
				current++
			}

			if length > longest {
				longest = length
			}
		}
	}

	return longest
}
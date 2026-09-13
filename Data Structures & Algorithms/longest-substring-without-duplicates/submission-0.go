	func lengthOfLongestSubstring(s string) int {
		left := 0
		seen := make(map[string]bool)
		longest := 0
		for right := 0; right < len(s); right++ {
			for seen[string(s[right])] {
				seen[string(s[left])] = false
				left++
			} 
			seen[string(s[right])] = true
	

			length := right - left + 1
			if length > longest {
				longest = length
			}
		}

		return longest

	}

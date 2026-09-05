import uni "unicode"

func isPalindrome(s string) bool {
	left := 0
	right := len(s) - 1

	for left < right {
		if !uni.IsLetter(rune(s[left])) && !uni.IsDigit(rune(s[left]))  {
			left += 1
			continue
		}
		if !uni.IsLetter(rune(s[right])) && !uni.IsDigit(rune(s[right])) {
			right -= 1 
			continue 
		} 
		if uni.ToLower(rune(s[left])) != uni.ToLower(rune(s[right])) {
			return false
		} else {
			left++
			right--
		}
	}

	return true 
}



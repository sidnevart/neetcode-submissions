import (
	mathh "math"
)

func minWindow(s string, t string) string {
	if len(t) > len(s) {
		return ""
	}

	ans := ""
	left := 0
	window := map[byte]int{}
	need := map[byte]int{}
	minimum := mathh.MaxInt

	for i := 0; i < len(t); i++ {
		need[t[i]]++
	}

	have := 0
	needCount := len(need)
	for right := 0; right < len(s); right++ {
		window[s[right]]++
		if window[s[right]] == need[s[right]]{
			have++
		}

		for have == needCount {
			if right - left + 1 < minimum {
				minimum = right - left + 1
				ans = s[left : right + 1]
			}
			
			if window[s[left]] == need[s[left]] {
				have--
			}
			window[s[left]]--
			left++
		}
	}

	return ans
}

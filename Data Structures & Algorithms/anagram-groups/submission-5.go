import (
	srt "sort"
	st "strings"
)

func groupAnagrams(strs []string) [][]string {
	groups := make(map[string][]string)
	ans := make([][]string, 0)
	for _, word := range strs {
		chars := st.Split(word, "")
		srt.Strings(chars)
		key := st.Join(chars, "")
		groups[key] = append(groups[key], word)
	}

	for _, group := range groups {
		ans = append(ans, group)
	}

	return ans
}
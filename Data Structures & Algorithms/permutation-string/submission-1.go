import (
	mapss "maps"
)

func checkInclusion(s1 string, s2 string) bool {

	if len(s1) > len(s2) {
		return false
	}

	set_1 := make(map[byte]int)
	for i := 0; i < len(s1); i++ {
		set_1[s1[i]]++
	}
	k := len(s1)

	set_2 := make(map[byte]int)
	for i := 0; i < k; i++ {
		set_2[s2[i]]++
	}

	if mapss.Equal(set_1, set_2) {
		return true
	}

	for right := k; right < len(s2); right++ {
		set_2[s2[right]]++
		left := right - k
		set_2[s2[left]]--
		if set_2[s2[left]] == 0 {
			delete(set_2, s2[left])
		}

		if mapss.Equal(set_1, set_2){
			return true 
		}
	}

	return false
}

type Solution struct{}

func (s *Solution) Encode(strs []string) string {
	encoded := ""
	separator := "#"
	for _, str := range strs {
		str_len := strconv.Itoa(len(str))
		encoded += (str_len + separator + str)
	}
	return encoded
}
func (s *Solution) Decode(encoded string) []string {
	result := []string{}
	start := 0
	curIdx := 0
	for curIdx < len(encoded) {
		if encoded[curIdx] == '#' {
			strLen, _ := strconv.Atoi(encoded[start:curIdx])
			result = append(result, encoded[(curIdx)+1:(curIdx+strLen+1)])
			start = curIdx + strLen + 1
			curIdx = start
		} else {
			curIdx++
		}
	}
	return result
}



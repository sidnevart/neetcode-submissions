func isValid(s string) bool {
	set := map[string]struct{}{
		"(": {},
		"[": {},
		"{": {},
	}
	stack := []string{}
	for i := 0; i < len(s); i++ {
		if _, ok := set[string(s[i])]; ok {
			stack = append(stack, string(s[i]))
		} else {
			if len(stack) == 0 {
				return false
			}
			peek := stack[len(stack)-1]
			switch peek {
			case "{":
				if string(s[i]) != "}" {
					return false
				} else {
					stack = stack[:len(stack)-1]
				}
			case "[":
				if string(s[i]) != "]" {
					return false
				} else {
					stack = stack[:len(stack)-1]
				}
			case "(":
				if string(s[i]) != ")" {
					return false
				} else {
					stack = stack[:len(stack)-1]
				}
			}

		}
	}
	if len(stack) > 0 {
		return false
	}
	return true
}
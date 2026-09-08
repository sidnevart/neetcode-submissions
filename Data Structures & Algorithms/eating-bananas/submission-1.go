func minEatingSpeed(piles []int, h int) int {
	pilesAmount := 0
	for _, amount := range piles {
		pilesAmount += amount
	}

	left := 1
	right := pilesAmount
	
	for left < right {
		mid := left + (right - left) / 2
		
		if canFinish(mid, piles, h) {
			right = mid
		} else {
			left = mid + 1
		}
	}

	return left
}

func canFinish(speed int, piles []int, h int) bool {
	hours := 0
	for _, pile := range piles {
		hours += pile / speed

		if pile%speed != 0 {
			hours++
		}
	}
	return hours <= h
}

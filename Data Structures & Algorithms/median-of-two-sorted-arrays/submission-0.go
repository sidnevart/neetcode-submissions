func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	// Binary search всегда делаем по меньшему массиву
	if len(nums1) > len(nums2) {
		nums1, nums2 = nums2, nums1
	}

	A := nums1
	B := nums2

	total := len(A) + len(B)

	// сколько элементов должно быть слева
	half := (total + 1) / 2

	left := 0
	right := len(A)

	for left <= right {
		// i = сколько элементов берем слева из A
		i := left + (right-left)/2

		// j = сколько тогда надо взять слева из B
		j := half - i

		// значения около "палок"
		Aleft := math.MinInt
		if i > 0 {
			Aleft = A[i-1]
		}

		Aright := math.MaxInt
		if i < len(A) {
			Aright = A[i]
		}

		Bleft := math.MinInt
		if j > 0 {
			Bleft = B[j-1]
		}

		Bright := math.MaxInt
		if j < len(B) {
			Bright = B[j]
		}

		// палка стоит правильно
		if Aleft <= Bright && Bleft <= Aright {
			if total%2 == 1 {
				return float64(max(Aleft, Bleft))
			}

			leftMax := max(Aleft, Bleft)
			rightMin := min(Aright, Bright)

			return float64(leftMax+rightMin) / 2.0
		}

		// из A взяли слишком много
		if Aleft > Bright {
			right = i - 1
		} else {
			// из A взяли слишком мало
			left = i + 1
		}
	}

	return 0
}
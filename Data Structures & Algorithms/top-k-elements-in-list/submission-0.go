func topKFrequent(nums []int, k int) []int {
	freq_map := make(map[int]int)
	buckets := make([][]int, len(nums)+1)
	ans := make([]int, 0)
	for _, num := range nums {
		freq_map[num]++
	}
	for number, count := range freq_map {
		buckets[count] = append(buckets[count], number)
	}

	for count := len(buckets) - 1; count >= 0; count-- {
		for _, number := range buckets[count] {
			ans = append(ans, number)
			if len(ans) == k {
				return ans
			}
		}
	}

	return ans
}

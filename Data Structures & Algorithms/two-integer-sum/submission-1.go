func twoSum(nums []int, target int) []int {
    map_a := make(map[int]int)
   	ans := []int{}
   	for index, num := range nums {
		mb_num := target - num
		val, ok := map_a[mb_num]
		if ok {
			ans = []int{val, index}
		} 
		map_a[num] = index
   	}
   	return ans
}

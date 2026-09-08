func searchMatrix(matrix [][]int, target int) bool {
	rows := len(matrix)
	cols := len(matrix[0])

	for i := 0; i < rows; i++ {

		rightItem := matrix[i][cols - 1]
		if target > rightItem {
			continue 
		} else {
			left := 0
			right := cols - 1
			for left <= right {
				mid := left + (right - left) / 2
				if matrix[i][mid] == target {
					return true
				} 
				if matrix[i][mid] < target {
					left = mid + 1
				} else {
					right = mid - 1
				}
			}
		}
	}
	return false
}

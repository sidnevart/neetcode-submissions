func isValidSudoku(board [][]byte) bool {
	for i := 0; i < len(board); i++ {
		seenInRow := make(map[byte]bool)
		seenInCol := make(map[byte]bool)

		for j := 0; j < len(board); j++ {
			rowValue := board[i][j]
			colValue := board[j][i]

			if rowValue != '.' {
				if seenInRow[rowValue] {
					return false
				}

				seenInRow[rowValue] = true
			}

			if colValue != '.' {
				if seenInCol[colValue] {
					return false
				}

				seenInCol[colValue] = true
			}
		}
	}

	// boxes
	for boxRow := 0; boxRow < 3; boxRow++ {
		for boxCol := 0; boxCol < 3; boxCol++ {
			seenInBox := make(map[byte]bool)

			for r := boxRow * 3; r < boxRow*3+3; r++ {
				for c := boxCol * 3; c < boxCol*3+3; c++ {
					value := board[r][c]

					if value == '.' {
						continue
					}

					if seenInBox[value] {
						return false
					}

					seenInBox[value] = true
				}
			}
		}
	}

	return true
}
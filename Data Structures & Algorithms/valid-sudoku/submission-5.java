class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int r = 0; r < board.length; r++){
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < board[0].length; i++){
                if (board[r][i] == '.'){
                    continue;
                }
                if (seen.contains(board[r][i])){
                    return false;
                }
                seen.add(board[r][i]);
            }
        }

        for (int c = 0; c < board.length; c++){
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < board[0].length; i++){
                if (board[i][c] == '.'){
                    continue;
                }
                if (seen.contains(board[i][c])){
                    return false;
                }
                seen.add(board[i][c]);
            }
        }

        for (int r = 0; r < 3; r++){
            for (int c = 0; c < 3; c++){
                Set<Character> seen = new HashSet<>();

                for (int rBound = r * 3; rBound < r * 3 + 3; rBound++){
                    for (int cBound = c * 3; cBound < c * 3 + 3; cBound++){
                        if (board[rBound][cBound] == '.'){
                            continue;
                        }
                        if (seen.contains(board[rBound][cBound])){
                            return false;
                        }
                        seen.add(board[rBound][cBound]);
                    }
                }    
            }
        }
        return true;
    }
}

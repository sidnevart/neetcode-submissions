class NumMatrix {

    int [][] prefix;

    public NumMatrix(int[][] matrix) {
        prefix = new int[matrix.length + 1][matrix[0].length + 1];
        for (int r = 0; r < matrix.length; r++){
            int prefixSum = 0;
            for (int c = 0; c < matrix[0].length; c++){
                int above = prefix[r][c + 1];
                prefixSum += matrix[r][c];
                prefix[r + 1][c + 1] = above + prefixSum;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        col1++;
        row2++;
        col2++;
        int bottomRight = prefix[row2][col2];
        int above = prefix[row1 - 1][col2];
        int left = prefix[row2][col1-1];
        int topLeft = prefix[row1 - 1][col1 - 1];
        return bottomRight - above - left + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
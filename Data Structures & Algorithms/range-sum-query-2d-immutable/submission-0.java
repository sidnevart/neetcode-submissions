class NumMatrix {

    int [][] sumMat;

    public NumMatrix(int[][] matrix) {
        this.sumMat = new int[matrix.length + 1][matrix[0].length + 1];
        for (int r = 0; r < matrix.length; r++){
            int prefix = 0;
            for (int c = 0; c < matrix[0].length; c++){
                prefix += matrix[r][c];
                sumMat[r + 1][c + 1] = prefix + sumMat[r][c + 1]; 
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        col1++;
        col2++;
        row2++;
        int topLeft = sumMat[row1 - 1][col1 - 1];
        int leftSide = sumMat[row2][col1 - 1];
        int aboveSide = sumMat[row1 - 1][col2];
        int bottomRight = sumMat[row2][col2];
        return bottomRight - leftSide - aboveSide + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

 /*

 */
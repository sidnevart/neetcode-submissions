class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean res = false;
        for (int r = 0; r < rows; r++){
            if (matrix[r][0] <= target && matrix[r][cols - 1] >= target){
                res = binarySearch(r, matrix, target);
                if (res){
                    return res;
                }
            }
        }
        return res;
    }

    public boolean binarySearch(int row, int[][]matrix, int target){
        int l = 0;
        int r = matrix[0].length - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (matrix[row][mid] == target){
                return true;
            } else if (matrix[row][mid] < target){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}

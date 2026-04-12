class Solution {
    boolean isToeplitz(int mat[][]) {
        int rows = mat.length;
        if (rows == 0) {
            return true;
        }
        int cols = mat[0].length;
        
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (mat[i][j] != mat[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
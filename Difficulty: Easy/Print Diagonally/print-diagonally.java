import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> diagView(int[][] mat) {
        int n = mat.length;
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int d = 0; d < 2 * n - 1; d++) {
            int row = Math.max(0, d - n + 1);
            int col = Math.min(d, n - 1);
            
            while (row < n && col >= 0) {
                result.add(mat[row][col]);
                row++;
                col--;
            }
        }
        
        return result;
    }

    public ArrayList<Integer> downwardDiagonal(int n, int[][] mat) {
        return diagView(mat);
    }
}
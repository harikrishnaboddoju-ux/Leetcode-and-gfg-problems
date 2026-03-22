import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRot(int[][] mat) {
        if (mat == null || mat.length == 0) return 0;
        
        int rows = mat.length;
        int cols = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (mat[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        
        if (freshCount == 0) return 0;
        
        int time = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            time++;
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] dir : dirs) {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    
                    if (r >= 0 && r < rows && c >= 0 && c < cols && mat[r][c] == 1) {
                        mat[r][c] = 2;
                        queue.offer(new int[]{r, c});
                        freshCount--;
                    }
                }
            }
        }
        
        return freshCount == 0 ? time : -1;
    }
}
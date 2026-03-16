import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                set.add(grid[i][j]);
                if (set.size() > 3) set.pollLast();

                for (int s = 1; ; s++) {
                    int topR = i, topC = j;
                    int botR = i + 2 * s, botC = j;
                    int leftR = i + s, leftC = j - s;
                    int rightR = i + s, rightC = j + s;

                    if (botR >= m || leftC < 0 || rightC >= n) break;

                    int currentSum = 0;
                    
                    for (int k = 0; k < s; k++) {
                        currentSum += grid[topR + k][topC - k];     // Top to Left
                        currentSum += grid[leftR + k][leftC + k];   // Left to Bottom
                        currentSum += grid[botR - k][botC + k];     // Bottom to Right
                        currentSum += grid[rightR - k][rightC - k]; // Right to Top
                    }

                    set.add(currentSum);
                    if (set.size() > 3) set.pollLast();
                }
            }
        }

        int[] result = new int[set.size()];
        int idx = 0;
        for (int val : set) {
            result[idx++] = val;
        }
        return result;
    }
}
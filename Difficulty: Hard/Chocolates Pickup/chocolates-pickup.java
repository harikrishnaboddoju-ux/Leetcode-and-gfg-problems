class Solution {
    public int maxChocolate(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[m][m];

        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2) {
                    dp[j1][j2] = grid[n - 1][j1];
                } else {
                    dp[j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
                }
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            int[][] nextRow = new int[m][m];
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maxChoco = -1;
                    
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int nj1 = j1 + di;
                            int nj2 = j2 + dj;

                            if (nj1 >= 0 && nj1 < m && nj2 >= 0 && nj2 < m) {
                                maxChoco = Math.max(maxChoco, dp[nj1][nj2]);
                            }
                        }
                    }

                    int current = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];
                    nextRow[j1][j2] = (maxChoco != -1) ? current + maxChoco : -1;
                }
            }
            dp = nextRow;
        }

        return dp[0][m - 1]; 
    }
}
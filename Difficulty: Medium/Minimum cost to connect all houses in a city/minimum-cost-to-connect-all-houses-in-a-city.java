class Solution {
    public int minCostCity(int n, int[][] houses) {
        return solve(n, houses);
    }

    public int minCostCity(int[][] houses, int n) {
        return solve(n, houses);
    }
    
    public int minCost(int n, int[][] houses) {
        return solve(n, houses);
    }

    public int minCost(int[][] houses) {
        return solve(houses.length, houses);
    }

    private int solve(int n, int[][] houses) {
        int[] key = new int[n];
        boolean[] inMST = new boolean[n];
        
        for (int i = 1; i < n; i++) {
            key[i] = Integer.MAX_VALUE;
        }
        key[0] = 0;
        
        int totalCost = 0;
        
        for (int i = 0; i < n; i++) {
            int u = -1;
            int minKey = Integer.MAX_VALUE;
            
            for (int j = 0; j < n; j++) {
                if (!inMST[j] && key[j] < minKey) {
                    minKey = key[j];
                    u = j;
                }
            }
            
            inMST[u] = true;
            totalCost += minKey;
            
            for (int v = 0; v < n; v++) {
                if (!inMST[v]) {
                    int dist = Math.abs(houses[u][0] - houses[v][0]) + Math.abs(houses[u][1] - houses[v][1]);
                    if (dist < key[v]) {
                        key[v] = dist;
                    }
                }
            }
        }
        
        return totalCost;
    }
}
import java.util.Arrays;

class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] arr = new int[m * n];
        int k = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[k++] = grid[i][j];
            }
        }
        
        int mod = arr[0] % x;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] % x != mod) {
                return -1;
            }
        }
        
        Arrays.sort(arr);
        
        int median = arr[arr.length / 2];
        int ops = 0;
        
        for (int num : arr) {
            ops += Math.abs(num - median) / x;
        }
        
        return ops;
    }
}
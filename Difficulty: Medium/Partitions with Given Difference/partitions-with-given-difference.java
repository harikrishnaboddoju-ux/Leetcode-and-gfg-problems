class Solution {
    public int countPartitions(int[] arr, int d) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        
        if (totalSum - d < 0 || (totalSum - d) % 2 != 0) {
            return 0;
        }
        
        int target = (totalSum - d) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        int MOD = 1000000007;
        
        for (int num : arr) {
            for (int j = target; j >= num; j--) {
                dp[j] = (dp[j] + dp[j - num]) % MOD;
            }
        }
        
        return dp[target];
    }
}
class Solution {
    public int concatenatedBinary(int n) {
        long res = 0;
        int MOD = 1000000007;
        int shift = 0;
        
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                shift++;
            }
            res = ((res << shift) | i) % MOD;
        }
        
        return (int) res;
    }
}
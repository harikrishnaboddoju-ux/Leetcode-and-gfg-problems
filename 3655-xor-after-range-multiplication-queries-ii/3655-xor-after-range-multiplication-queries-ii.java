import java.util.Arrays;

class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int mod = 1000000007;
        int B = 220;
        
        int[][] diff = new int[B][n];
        for (int i = 0; i < B; i++) {
            Arrays.fill(diff[i], 1);
        }
        
        int[] total = new int[n];
        Arrays.fill(total, 1);
        
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];
            
            if (k >= B) {
                for (int idx = l; idx <= r; idx += k) {
                    total[idx] = (int) (((long) total[idx] * v) % mod);
                }
            } else {
                diff[k][l] = (int) (((long) diff[k][l] * v) % mod);
                int end = l + ((r - l) / k) * k;
                if (end + k < n) {
                    int inv = (int) power(v, mod - 2, mod);
                    diff[k][end + k] = (int) (((long) diff[k][end + k] * inv) % mod);
                }
            }
        }
        
        for (int k = 1; k < B; k++) {
            for (int i = 0; i < n; i++) {
                if (i >= k) {
                    diff[k][i] = (int) (((long) diff[k][i] * diff[k][i - k]) % mod);
                }
                total[i] = (int) (((long) total[i] * diff[k][i]) % mod);
            }
        }
        
        int xorSum = 0;
        for (int i = 0; i < n; i++) {
            long finalVal = ((long) nums[i] * total[i]) % mod;
            xorSum ^= (int) finalVal;
        }
        
        return xorSum;
    }
    
    private long power(long base, long exp, int mod) {
        long res = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
}
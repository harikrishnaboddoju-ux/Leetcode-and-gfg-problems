class Solution {
    public int minSteps(int m, int n, int d) {
        if (m > n) {
            int temp = m;
            m = n;
            n = temp;
        }
        if (d > n || d % gcd(m, n) != 0) {
            return -1;
        }
        return Math.min(pour(m, n, d), pour(n, m, d));
    }

    private int pour(int fromCap, int toCap, int d) {
        int fromJug = fromCap;
        int toJug = 0;
        int step = 1;
        
        while (fromJug != d && toJug != d) {
            int temp = Math.min(fromJug, toCap - toJug);
            toJug += temp;
            fromJug -= temp;
            step++;
            
            if (fromJug == d || toJug == d) {
                break;
            }
            
            if (fromJug == 0) {
                fromJug = fromCap;
                step++;
            }
            
            if (toJug == toCap) {
                toJug = 0;
                step++;
            }
        }
        return step;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
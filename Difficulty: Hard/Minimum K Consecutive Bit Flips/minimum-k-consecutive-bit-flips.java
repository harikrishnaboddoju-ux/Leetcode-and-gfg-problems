class Solution {
    public int kBitFlips(int[] arr, int k) {
        int n = arr.length;
        int flipCount = 0;
        int ans = 0;
        boolean[] isFlipped = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (i >= k && isFlipped[i - k]) {
                flipCount--;
            }
            
            if ((arr[i] + flipCount) % 2 == 0) {
                if (i + k > n) {
                    return -1;
                }
                ans++;
                flipCount++;
                isFlipped[i] = true;
            }
        }
        
        return ans;
    }
}
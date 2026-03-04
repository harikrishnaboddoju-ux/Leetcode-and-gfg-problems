class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        int currentXor = 0;
        
        for (int i = 0; i < k; i++) {
            currentXor ^= arr[i];
        }
        
        int maxXor = currentXor;
        
        for (int i = k; i < arr.length; i++) {
            currentXor ^= arr[i - k];
            currentXor ^= arr[i];
            
            if (currentXor > maxXor) {
                maxXor = currentXor;
            }
        }
        
        return maxXor;
    }
}
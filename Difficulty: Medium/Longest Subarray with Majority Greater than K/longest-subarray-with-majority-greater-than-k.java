class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        int[] prefixSum = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + (arr[i] > k ? 1 : -1);
        }

        int[] stack = new int[n + 1];
        int top = 0;
        for (int i = 0; i <= n; i++) {
            if (top == 0 || prefixSum[i] < prefixSum[stack[top - 1]]) {
                stack[top++] = i;
            }
        }

        int maxLen = 0;
        for (int j = n; j >= 0; j--) {
            while (top > 0 && prefixSum[j] > prefixSum[stack[top - 1]]) {
                maxLen = Math.max(maxLen, j - stack[--top]);
            }
        }

        return maxLen;
    }
}
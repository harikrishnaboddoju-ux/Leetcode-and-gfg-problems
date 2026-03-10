class Solution {
    public int countSubarrays(int[] arr) {
        int n = arr.length;
        int count = 0;
        int[] stack = new int[n];
        int top = -1;
        
        for (int i = n - 1; i >= 0; i--) {
            while (top >= 0 && arr[stack[top]] >= arr[i]) {
                top--;
            }
            
            int nse = (top == -1) ? n : stack[top];
            count += (nse - i);
            
            stack[++top] = i;
        }
        
        return count;
    }
}
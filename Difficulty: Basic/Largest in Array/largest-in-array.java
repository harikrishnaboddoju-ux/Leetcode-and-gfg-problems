class Solution {
    public static int largest(int[] arr) {
        // Assume the first element is the largest
        int max = arr[0];
        
        // Traverse the array to find the maximum value
        for (int i = 1; i < arr.length; i++) {
            // Update max if a larger value is found
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        
        return max;
    }
}
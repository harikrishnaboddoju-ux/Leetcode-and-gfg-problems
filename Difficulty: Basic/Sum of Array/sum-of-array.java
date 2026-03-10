class Solution {
    int arraySum(int arr[]) {
        int total = 0;
        
        // Iterate through each element in the array
        for (int i = 0; i < arr.length; i++) {
            // Accumulate the values into the running total
            total += arr[i];
        }
        
        return total;
    }
}
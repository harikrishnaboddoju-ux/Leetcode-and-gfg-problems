class Solution {
    public int minSwaps(int[] arr) {
        int totalOnes = 0;
        for (int num : arr) {
            if (num == 1) {
                totalOnes++;
            }
        }
        
        if (totalOnes == 0) {
            return -1;
        }
        
        int currentOnes = 0;
        for (int i = 0; i < totalOnes; i++) {
            if (arr[i] == 1) {
                currentOnes++;
            }
        }
        
        int maxOnes = currentOnes;
        for (int i = totalOnes; i < arr.length; i++) {
            if (arr[i] == 1) {
                currentOnes++;
            }
            if (arr[i - totalOnes] == 1) {
                currentOnes--;
            }
            maxOnes = Math.max(maxOnes, currentOnes);
        }
        
        return totalOnes - maxOnes;
    }
}
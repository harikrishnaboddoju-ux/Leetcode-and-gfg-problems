class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        int maxVal = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }
        
        int[] freq = new int[maxVal + 1];
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]]++;
        }
        
        for (int i = 1; i <= maxVal; i++) {
            if (freq[i] == 0) {
                continue;
            }
            for (int j = i + 1; j <= maxVal; j++) {
                if (freq[j] == 0) {
                    continue;
                }
                
                int cSq = i * i + j * j;
                int c = (int) Math.sqrt(cSq);
                
                if (c * c == cSq && c <= maxVal && freq[c] > 0) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
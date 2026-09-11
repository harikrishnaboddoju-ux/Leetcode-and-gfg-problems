class Solution {
    public int totalNumbers(int[] digits) {
        int[] counts = new int[10];
        for (int digit : digits) {
            counts[digit]++;
        }
        
        int result = 0;
        for (int i = 100; i < 1000; i += 2) {
            int hundreds = i / 100;
            int tens = (i / 10) % 10;
            int ones = i % 10;
            
            counts[hundreds]--;
            counts[tens]--;
            counts[ones]--;
            
            if (counts[hundreds] >= 0 && counts[tens] >= 0 && counts[ones] >= 0) {
                result++;
            }
            
            counts[hundreds]++;
            counts[tens]++;
            counts[ones]++;
        }
        
        return result;
    }
}
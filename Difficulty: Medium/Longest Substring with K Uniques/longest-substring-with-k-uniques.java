class Solution {
    public int longestKSubstr(String s, int k) {
        int[] counts = new int[26];
        int left = 0, maxLen = -1, unique = 0;
        
        for (int right = 0; right < s.length(); right++) {
            if (counts[s.charAt(right) - 'a']++ == 0) {
                unique++;
            }
            
            while (unique > k) {
                if (--counts[s.charAt(left++) - 'a'] == 0) {
                    unique--;
                }
            }
            
            if (unique == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        
        return maxLen;
    }
}
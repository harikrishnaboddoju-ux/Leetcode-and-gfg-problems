class Solution {
    public String minWindow(String s, String p) {
        // Return empty string if s is smaller than p
        if (s.length() < p.length()) {
            return "";
        }
        
        int[] hashP = new int[256];
        int[] hashS = new int[256];
        
        for (int i = 0; i < p.length(); i++) {
            hashP[p.charAt(i)]++;
        }
        
        int start = 0;
        int startIndex = -1;
        int minLen = Integer.MAX_VALUE;
        int count = 0;
        
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            hashS[c]++;
            
            if (hashP[c] != 0 && hashS[c] <= hashP[c]) {
                count++;
            }
            
            if (count == p.length()) {
                while (hashS[s.charAt(start)] > hashP[s.charAt(start)] || hashP[s.charAt(start)] == 0) {
                    if (hashS[s.charAt(start)] > hashP[s.charAt(start)]) {
                        hashS[s.charAt(start)]--;
                    }
                    start++;
                }
                
                int windowLen = j - start + 1;
                if (minLen > windowLen) {
                    minLen = windowLen;
                    startIndex = start;
                }
            }
        }
        
        // Return empty string if no window was found
        if (startIndex == -1) {
            return "";
        }
        
        return s.substring(startIndex, startIndex + minLen);
    }
}
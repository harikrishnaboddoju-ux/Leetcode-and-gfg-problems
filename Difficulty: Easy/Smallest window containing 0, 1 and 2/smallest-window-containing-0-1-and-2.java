class Solution {
    public int smallestSubstring(String s) {
        int zero = -1, one = -1, two = -1;
        int res = Integer.MAX_VALUE;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') zero = i;
            else if (s.charAt(i) == '1') one = i;
            else if (s.charAt(i) == '2') two = i;
            
            if (zero != -1 && one != -1 && two != -1) {
                int minIdx = Math.min(zero, Math.min(one, two));
                res = Math.min(res, i - minIdx + 1);
            }
        }
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
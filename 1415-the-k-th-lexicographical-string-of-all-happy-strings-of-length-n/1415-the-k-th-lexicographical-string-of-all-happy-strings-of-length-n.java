class Solution {
    public String getHappyString(int n, int k) {
        int total = 3 * (1 << (n - 1));
        if (k > total) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        k--;
        
        int firstIdx = k / (1 << (n - 1));
        char prev = (char) ('a' + firstIdx);
        sb.append(prev);
        k %= (1 << (n - 1));
        
        for (int i = n - 2; i >= 0; i--) {
            char c1, c2;
            if (prev == 'a') {
                c1 = 'b';
                c2 = 'c';
            } else if (prev == 'b') {
                c1 = 'a';
                c2 = 'c';
            } else {
                c1 = 'a';
                c2 = 'b';
            }
            
            if (k < (1 << i)) {
                prev = c1;
            } else {
                prev = c2;
                k -= (1 << i);
            }
            sb.append(prev);
        }
        
        return sb.toString();
    }
}
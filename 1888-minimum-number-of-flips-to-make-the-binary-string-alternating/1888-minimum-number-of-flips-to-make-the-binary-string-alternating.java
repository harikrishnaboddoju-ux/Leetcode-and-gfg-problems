class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String doubled = s + s;
        int diff1 = 0, diff2 = 0;
        int minFlips = n;

        for (int i = 0; i < 2 * n; i++) {
            if (doubled.charAt(i) != (i % 2 == 0 ? '0' : '1')) {
                diff1++;
            }
            if (doubled.charAt(i) != (i % 2 == 0 ? '1' : '0')) {
                diff2++;
            }

            if (i >= n) {
                int left = i - n;
                if (doubled.charAt(left) != (left % 2 == 0 ? '0' : '1')) {
                    diff1--;
                }
                if (doubled.charAt(left) != (left % 2 == 0 ? '1' : '0')) {
                    diff2--;
                }
            }

            if (i >= n - 1) {
                minFlips = Math.min(minFlips, Math.min(diff1, diff2));
            }
        }

        return minFlips;
    }
}
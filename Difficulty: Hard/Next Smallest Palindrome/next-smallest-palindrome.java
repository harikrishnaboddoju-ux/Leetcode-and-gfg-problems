class Solution {
    public int[] nextPalindrome(int[] num) {
        int n = num.length;
        boolean all9s = true;
        for (int i = 0; i < n; i++) {
            if (num[i] != 9) {
                all9s = false;
                break;
            }
        }
        
        if (all9s) {
            int[] ans = new int[n + 1];
            ans[0] = 1;
            ans[n] = 1;
            return ans;
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = num[i];
        }

        int mid = n / 2;
        int i = mid - 1;
        int j = (n % 2 == 0) ? mid : mid + 1;

        boolean leftSmaller = false;
        while (i >= 0 && ans[i] == ans[j]) {
            i--;
            j++;
        }

        if (i < 0 || ans[i] < ans[j]) {
            leftSmaller = true;
        }

        for (int k = 0; k < mid; k++) {
            ans[n - 1 - k] = ans[k];
        }

        if (leftSmaller) {
            int carry = 1;
            i = mid - 1;
            if (n % 2 == 1) {
                ans[mid] += carry;
                carry = ans[mid] / 10;
                ans[mid] %= 10;
            }
            while (i >= 0 && carry > 0) {
                ans[i] += carry;
                carry = ans[i] / 10;
                ans[i] %= 10;
                ans[n - 1 - i] = ans[i];
                i--;
            }
        }

        return ans;
    }

    public java.util.Vector<Integer> generateNextPalindrome(int[] num, int n) {
        int[] res = nextPalindrome(num);
        java.util.Vector<Integer> vec = new java.util.Vector<>();
        for (int val : res) {
            vec.add(val);
        }
        return vec;
    }
}
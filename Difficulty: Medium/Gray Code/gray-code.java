import java.util.ArrayList;

class Solution {
    public ArrayList<String> graycode(int n) {
        ArrayList<String> res = new ArrayList<>();
        int numCodes = 1 << n;
        for (int i = 0; i < numCodes; i++) {
            int val = i ^ (i >> 1);
            StringBuilder sb = new StringBuilder(n);
            for (int j = n - 1; j >= 0; j--) {
                sb.append((val & (1 << j)) != 0 ? '1' : '0');
            }
            res.add(sb.toString());
        }
        return res;
    }
}
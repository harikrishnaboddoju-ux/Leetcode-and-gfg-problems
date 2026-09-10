import java.util.ArrayList;

class Solution {
    public ArrayList<String> possibleWords(int[] a, int N) {
        ArrayList<String> res = new ArrayList<>();
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(res, a, mapping, 0, new StringBuilder(), N);
        return res;
    }

    public ArrayList<String> possibleWords(int[] arr) {
        return possibleWords(arr, arr.length);
    }

    private void backtrack(ArrayList<String> res, int[] arr, String[] mapping, int index, StringBuilder sb, int n) {
        if (index == n) {
            res.add(sb.toString());
            return;
        }

        String letters = mapping[arr[index]];
        if (letters.isEmpty()) {
            backtrack(res, arr, mapping, index + 1, sb, n);
        } else {
            for (int i = 0; i < letters.length(); i++) {
                sb.append(letters.charAt(i));
                backtrack(res, arr, mapping, index + 1, sb, n);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
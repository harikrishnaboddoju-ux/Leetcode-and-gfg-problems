import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalElements(int[] arr) {
        int left = 0, maxLength = 0;
        Map<Integer, Integer> counts = new HashMap<>();

        for (int right = 0; right < arr.length; right++) {
            counts.put(arr[right], counts.getOrDefault(arr[right], 0) + 1);

            while (counts.size() > 2) {
                counts.put(arr[left], counts.get(arr[left]) - 1);
                if (counts.get(arr[left]) == 0) {
                    counts.remove(arr[left]);
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
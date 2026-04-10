import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> find3Numbers(int[] arr) {
        List<Integer> res = new ArrayList<>();
        if (arr == null || arr.length < 3) {
            return res;
        }
        
        int min = arr[0];
        int max = Integer.MAX_VALUE;
        int storeMin = min;
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > min && arr[i] < max) {
                max = arr[i];
                storeMin = min;
            } else if (arr[i] > max) {
                res.add(storeMin);
                res.add(max);
                res.add(arr[i]);
                return res;
            }
        }
        
        return res;
    }
}
import java.util.HashMap;

class Solution {
    public long subarrayXor(int arr[], int k) {
        long count = 0;
        int xr = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : arr) {
            xr ^= num;
            int target = xr ^ k;
            
            if (map.containsKey(target)) {
                count += map.get(target);
            }
            
            map.put(xr, map.getOrDefault(xr, 0) + 1);
        }
        
        return count;
    }
}
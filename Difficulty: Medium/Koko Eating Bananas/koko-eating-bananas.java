class Solution {
    public static int kokoEat(int[] arr, int k) {
        int maxVal = 0;
        for (int pile : arr) {
            if (pile > maxVal) {
                maxVal = pile;
            }
        }
        
        int low = 1;
        int high = maxVal;
        int ans = maxVal;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canEatAll(arr, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return ans;
    }
    
    private static boolean canEatAll(int[] arr, int k, int speed) {
        long totalHours = 0;
        for (int pile : arr) {
            totalHours += (pile + speed - 1) / speed;
            if (totalHours > k) {
                return false;
            }
        }
        return totalHours <= k;
    }
}
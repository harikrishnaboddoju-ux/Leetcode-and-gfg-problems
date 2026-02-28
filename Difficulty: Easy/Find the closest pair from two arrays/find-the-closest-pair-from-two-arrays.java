import java.util.*;

class Solution {
    public static ArrayList<Integer> findClosestPair(int arr1[], int arr2[], int x) {
        int n = arr1.length;
        int m = arr2.length;
        int left = 0;
        int right = m - 1;
        int minDiff = Integer.MAX_VALUE;
        
        ArrayList<Integer> result = new ArrayList<>(Arrays.asList(-1, -1));
        
        while (left < n && right >= 0) {
            int currentSum = arr1[left] + arr2[right];
            int currentDiff = Math.abs(currentSum - x);
            
            if (currentDiff < minDiff) {
                minDiff = currentDiff;
                result.set(0, arr1[left]);
                result.set(1, arr2[right]);
            }
            
            if (currentSum < x) {
                left++;
            } else {
                right--;
            }
        }
        
        return result;
    }
}
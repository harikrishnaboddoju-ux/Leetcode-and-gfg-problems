import java.util.*;
class Solution {
    private int reverse(int num){
        int revnum=0;
        while(num>0){
            int digit=num%10;
            revnum=revnum*10+digit;
            num=num/10;
        }
        return revnum;
    }
    public int minMirrorPairDistance(int[] nums) {
        int minDistance = Integer.MAX_VALUE;
        Map<Integer, Integer> reversedSeen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (reversedSeen.containsKey(nums[i])) {
                int distance = i - reversedSeen.get(nums[i]);
                minDistance = Math.min(minDistance, distance);
            }
            int rev = reverse(nums[i]);
            reversedSeen.put(rev, i);
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
        
    }
}
import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] objArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            objArr[i] = arr[i];
        }

        Arrays.sort(objArr, (a, b) -> {
            int bitCountA = Integer.bitCount(a);
            int bitCountB = Integer.bitCount(b);
            
            if (bitCountA != bitCountB) {
                return bitCountA - bitCountB;
            }
            return a - b;
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
        return arr;
    }
}

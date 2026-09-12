import java.util.Arrays;

class Solution {
    public long maxProductSubsequence(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        long product = 1;

        if (k % 2 != 0 && arr[n - 1] < 0) {
            for (int i = n - 1; i >= n - k; i--) {
                product *= (long) arr[i];
            }
            return product;
        }

        int left = 0;
        int right = n - 1;

        if (k % 2 != 0) {
            product *= (long) arr[right];
            right--;
            k--;
        }

        while (k > 0) {
            long leftProduct = (long) arr[left] * arr[left + 1];
            long rightProduct = (long) arr[right] * arr[right - 1];

            if (leftProduct > rightProduct) {
                product *= leftProduct;
                left += 2;
            } else {
                product *= rightProduct;
                right -= 2;
            }
            k -= 2;
        }

        return product;
    }

    public long maxProduct(int[] arr, int k) {
        return maxProductSubsequence(arr, k);
    }
}
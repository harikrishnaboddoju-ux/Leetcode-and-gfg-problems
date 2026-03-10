class Solution {
    public int getSecondLargest(int[] arr) {
        int largest = -1;
        int secondLargest = -1;

        // Traverse the array to find distinct largest and second largest
        for (int x : arr) {
            if (x > largest) {
                secondLargest = largest;
                largest = x;
            } else if (x < largest && x > secondLargest) {
                secondLargest = x;
            }
        }

        return secondLargest;
    }
}
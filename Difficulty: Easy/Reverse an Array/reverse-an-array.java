class Solution {
    public void reverseArray(int arr[]) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            // Swap the elements at the left and right pointers
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            
            // Move pointers towards the center
            left++;
            right--;
        }
    }
}
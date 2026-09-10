class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int[] booking : bookings) {
            int first = booking[0];
            int last = booking[1];
            int seats = booking[2];
            ans[first - 1] += seats;
            if(last < n){
                ans[last] -= seats;
            }
        }
        int[] answer = new int[n];
            answer[0] = ans[0];
            for(int i = 1; i < n; i++){
                answer[i] = answer[i - 1] +ans[i];
            }
            return answer;
    }
}
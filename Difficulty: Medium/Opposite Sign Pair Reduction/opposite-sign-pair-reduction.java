import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public ArrayList<Integer> reducePairs(int[] arr) {
        Stack<Integer> st = new Stack<>();
        
        for (int num : arr) {
            boolean push = true;
            
            while (!st.isEmpty() && ((st.peek() > 0 && num < 0) || (st.peek() < 0 && num > 0))) {
                int top = st.pop();
                int absTop = Math.abs(top);
                int absNum = Math.abs(num);
                
                if (absTop > absNum) {
                    num = top;
                } else if (absTop == absNum) {
                    push = false;
                    break;
                }
            }
            
            if (push) {
                st.push(num);
            }
        }
        
        return new ArrayList<>(st);
    }
}
import java.util.*;
class Solution {
    public boolean isPower(int x, int y) {
        if (y == 1) return true;
    
        if (x == 1) return y == 1;

        long temp = x;
        while (temp < y) {
            temp *= x;
        }
        return temp == y;
}
}
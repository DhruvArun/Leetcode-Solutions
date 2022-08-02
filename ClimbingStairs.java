import java.util.*;

// Solution looks very simple, however, extensive analysis must be done prior to reaching this solution.
// Logic is seen upon drawing a decision tree.

class ClimbingStairs {
    public int climbStairs(int n) {
        int one = 1;
        int two = 1;
        
        for (int i = 0; i < n - 1; i++) {
            int temp = one;
            one += two;
            two = temp;
        }
        
        return one;
    }
}

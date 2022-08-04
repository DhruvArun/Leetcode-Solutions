import java.util.*;

class HouseRobber {
    public int rob(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;
        
        // [rob1, rob2, n, n+1, ...]
        for (int n : nums) {
            int temp = Math.max(rob1 + n, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        
        return rob2;
    }
}

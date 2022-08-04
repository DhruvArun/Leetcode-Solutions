import java.util.*;

class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        int start = robber(Arrays.copyOfRange(nums, 0, nums.length - 1));
        int end = robber(Arrays.copyOfRange(nums, 1, nums.length));
        
        return Math.max(start, end);
        
    }
    
    public int robber(int[] nums) {
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

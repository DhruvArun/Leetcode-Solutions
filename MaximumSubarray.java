import java.util.*;

// Similar to Sliding Window Approach 

class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSub = nums[0]; 
        int currentSum = 0;
        
        for (int num : nums) {
            if (currentSum < 0) {
                currentSum = 0;
            }
            
            currentSum += num;
            maxSub = Math.max(maxSub, currentSum);
        }
        
        return maxSub;
    }
}

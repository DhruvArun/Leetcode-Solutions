import java.util.*;

class PartitionEqualSubsetSum {
    // Time Complexity - O(nums.length * sum)
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        
        HashSet<Integer> dp = new HashSet<>();
        dp.add(0);
        
        for (int i = 0; i < nums.length - 1; i++) {
            HashSet<Integer> nextDP = new HashSet<>();
            for (int t : dp) {
                nextDP.add(t + nums[i]);
                nextDP.add(t);
            }
            dp = nextDP;
        }
        
        int target = sum / 2;
        return dp.contains(target) ? true : false;
    }
}
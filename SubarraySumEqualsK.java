import java.util.*;

// Time Complexity - O(n)
class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int sum = 0;
        HashMap<Integer, Integer> lookup = new HashMap<>();
        lookup.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (lookup.containsKey(sum - k)) {
                result += lookup.get(sum - k);
            }
            
            lookup.put(sum, lookup.getOrDefault(sum, 0) + 1);
        }
        
        return result;
    }
}

// Valid Solution
// Time Complexity - O(n^2) [Exceeds Time Limit]
class AlternateSolution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        
        for (int start = 0; start < nums.length; start++) {
            for (int end = start; end < nums.length; end++) {
                HashMap<Integer, Integer> lookup = new HashMap<>();
                lookup.put(0, 1);
                int cumulative = 0;
                
                if (start != 0) {
                    cumulative += nums[end] - nums[start - 1];
                }
                else {
                    cumulative += nums[end];
                }
                
                if (lookup.containsKey(cumulative - k)) {
                    result += lookup.get(cumulative - k);
                }

                if (lookup.containsKey(cumulative)) {
                    lookup.put(cumulative, lookup.get(cumulative) + 1);
                }
                else {
                    lookup.put(cumulative, 1);
                }
            }
        }
        
        return result;
    }
}
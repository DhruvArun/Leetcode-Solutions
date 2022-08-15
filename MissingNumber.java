import java.util.*;

// O(n) Time Complexity 
// Use Math Formula - Sum of first n Natural Numbers is equal to (n*(n+1)) / 2
class MissingNumber {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        
        for(int i = 0; i < nums.length; i++) {
            res += i - nums[i];
        }
        
        return res;
    }    
}

// Valid Solution (Exceeds Time Limit) – O(n^2) Time Complexity 
// Note: Second for loop uses ArrayList.contains() method which has O(n) Time Complexity
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = 0;
        List<Integer> temp = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            temp.add(nums[i]);
        }
        
        for (int i = 0; i <= n; i++) {
            if (!(temp.contains(i))) {
                res = i;
            }
        }
        
        return res;
    }
}

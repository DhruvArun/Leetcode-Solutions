import java.util.*;

class OneThreeTwoPattern {
    public boolean find132pattern(int[] nums) {
        Stack<ArrayList<Integer>> stk = new Stack<ArrayList<Integer>>(); // [num, minLeft]
        int currMin = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            while (!stk.isEmpty() && nums[i] >= stk.peek().get(0)) {
                stk.pop();
            }
            
            if (!stk.isEmpty() && nums[i] < stk.peek().get(0) && nums[i] > stk.peek().get(1)) {
                return true;
            }
            
            stk.push(new ArrayList(Arrays.asList(nums[i], currMin)));
            currMin = Math.min(currMin, nums[i]);
        }
        
        return false;
    }
}
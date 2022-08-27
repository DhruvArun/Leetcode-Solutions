import java.util.*;

// Time Complexity - O(n^3)
class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int b = nums[j];
                
                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    long sum = (long) a + (long) b + (long) nums[l] + (long) nums[r];
                    if (sum > target) {
                        r--;
                    }
                    else if (sum < target) {
                        l++;
                    }
                    else {
                        List<Integer> temp = new ArrayList<>();
                        
                        temp.add(a);
                        temp.add(b);
                        temp.add(nums[l]);
                        temp.add(nums[r]);
                        
                        result.add(temp);
                        l++;
                        // OR
                        // r--;
                    }
                }
            }
        }
        
        List<List<Integer>> finalResult = new ArrayList<>(result);        
        return finalResult;
    }
}
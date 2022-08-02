import java.util.*;

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
    
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            
            if (i > 0  && a == nums[i - 1]) {
                continue;    
            }
            
            int l = i + 1;
            int r = nums.length - 1;
            
            while (l < r) {
                int threeSum = a + nums[l] + nums[r];
                
                if (threeSum > 0) {
                    r--;
                }
                else if (threeSum < 0) {
                    l++;
                }
                else {
                    List<Integer> temp = new ArrayList<>();
                    
                    temp.add(a); temp.add(nums[l]); temp.add(nums[r]);
                    
                    result.add(temp);
                    l++;
                    
                    while (nums[l] == nums [l-1] && l < r) {
                        l++;
                    }
                }
            }

        }
        
        return result;
    }
}

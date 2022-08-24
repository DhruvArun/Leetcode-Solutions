import java.util.*;

// TimeComplexity - O(n) 
// Space Complexity - O(1)
// O(1) SC is required, thus, we cannot use a HashSet
class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int curr = nums[0];
        int start = 1, count = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != curr){
                nums[start] = nums[i];
                curr = nums[i];
                start++;
                count++;
            }
        }
        
        return count;
    }
}
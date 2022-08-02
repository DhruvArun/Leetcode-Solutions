import java.util.*;

class MinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        
        int temp = nums[0];
        
        while (l <= r) {
            if (nums[l] < nums[r]) {
                temp = Math.min(temp, nums[l]);
                break;
            }
            
            int mid = (l+r) / 2;
            
            temp = Math.min(temp, nums[mid]);
            
            // left-sorted, search right 
            if (nums[mid] >= nums[l]) {
                l = mid + 1; 
            }
            
            // right-sorted, search left
            else {
                r = mid - 1;
            }
        }
        
        return (temp);
    }
}

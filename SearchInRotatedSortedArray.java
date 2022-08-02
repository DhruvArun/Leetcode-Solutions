import java.util.*;

// Question requires O(log(n)) Time Complexity – Use Binary Search 

class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        
        while (l <= r) {
            int mid = (l + r) / 2;
            
            if (target == nums[mid]) {
                return mid;
            }
            
            if (nums[mid] >= nums[l]) {
                if (target > nums[mid] || target < nums[l]) {
                    l = mid + 1;
                }
                else {
                    r = mid - 1;
                } 
            }
            else {
                if (target < nums[mid] || target > nums[r]) {
                    r = mid - 1;
                }
                else {
                    l = mid + 1;
                }
            }
        }
        
        return -1;
    }
}


// Valid Algorithm - Exceeds Time Limit: O(n) Time Complexity

// class SearchInRotatedSortedArray {
//     public int search(int[] nums, int target) {
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] == target) {
//                 return i;
//             }
//         }
        
//         return -1;
//     }
// }

import java.util.*;

// Time Complexity - O(n)
// Space Complexity - O(1)
// Floyd's Tortoise and Hare Algorithm to Find a Cycle in a Linked List
// nums.length = n + 1
// nums[i] is in the range [1, n]
// Value at nums[i] points to value of nums when index is equal to nums[i]
// Eg. [1,3,4,2,2] => 0 -> 3 -> 2 -> 4 -> 2 -> 4
// Since, 0 -> nums[1] -> nums[3] -> nums[2] -> nums[4] -> nums[2]
// nums[3] == nums[4], giving us a Cycle in the Linked List
// Beginning of Cycle is the Duplicate value in nums
class SFindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }
        
        int slow2 = 0;
        while (true) {
            slow = nums[slow];
            slow2 = nums[slow2];
            if (slow == slow2) {
                return slow;
            }
        }
    }
}
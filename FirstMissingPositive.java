import java.util.*;

// Time Complexity - O(3n) => O(n)
// Space Complexity - O(1)
// Result belongs to [1, nums.length + 1]
class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (index >= 1 && index <= nums.length) {
                // int index = Math.abs(nums[i]) - 1;
                if (nums[index - 1] > 0) {
                    nums[index - 1] *= -1;
                }
                else if (nums[index - 1] == 0) {
                    nums[index - 1] = -1 * (nums.length + 1);
                }
            }
        }
        
        for (int i = 1; i < nums.length + 1; i++) {
            if (nums[i - 1] >= 0) {
                return i;
            }
        }
        
        return nums.length + 1;
    }
}

// Time Complexity - O(2n) => O(n)
// Space Complexity - O(n), HashSet uses extra Memory
// Result belongs to [1, nums.length + 1]
class AlternateSolution1 {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (n > 0 && n != Integer.MAX_VALUE) {
                set.add(n);
            }
        }
        if (set.size() == 0) {
            return 1;
        }
        
        for (int i = 1; i <= nums.length + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        
        return -1;
    }
}

// Time Complexity - O(nlog(n) + 2n) => O(nlog(n))
// Space Complexity - O(n), HashSet uses extra Memory
// Arrays.sort() is an O(nlog(n)) Operation
class AlternateSolution2 {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 1 & nums[0] != 1) {
            return 1;
        }
        if (nums.length == 1 & nums[0] == 1) {
            return 2;
        }
        if (nums.length == 0) {
            return 1;
        }
                
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (n > 0 && n != Integer.MAX_VALUE) {
                set.add(n);
            }
        }
        if (set.size() == 0) {
            return 1;
        }
        
        List<Integer> temp = new ArrayList<>(set);
        int r = temp.get(temp.size() - 1) + 1;
        for (int i = 1; i <= r; i++) {
            if (!set.contains(Integer.valueOf(i))) {
                return i;
            }
        }
        
        return -1;
    }
}
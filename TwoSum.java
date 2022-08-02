import java.util.*;

// O(n) Time Complexity

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> prevMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;
            
            if (prevMap.containsKey(diff)) {
                return new int[]{prevMap.get(diff), i};
            }
            
            prevMap.put(num, i);
        }
        
        return new int[]{};
    }
}

// O(n^2) Time Complexity

// class TwoSum {
//     public int[] twoSum(int[] nums, int target) {
//         int sum = 0;
//         for (int i = 0; i < nums.length; i++) {
//             sum += nums[i];
//             for (int j = i + 1; j < nums.length; j++) {
//                sum += nums[j];
//                if (sum == target) {
//                    int[] result = new int[2];
//                    result[0] = i;
//                    result[1] = j;
                   
//                    return result;
//                }
//                sum -= nums[j]; 
//             }
//             sum = 0;
//         }
//         return nums;
//     }
// }

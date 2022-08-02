import java.util.*;
import java.util.stream.*;

// Optimal Solution – Using Sets

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        
        Set<Integer> numSet = new HashSet<>(numList);
            
        for(int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int length = 1;
                
                while (numSet.contains(num + length)) {
                    length++;
                }
                
                longest = Math.max(length, longest);
            }
        }
        
        return longest;
    }
}

// Valid Algorithm – Exceeds Time Limit as an Array is used as opposed 
// to a Set which is more time efficient as it cannot contain any duplicates. 

// class Solution {
//     public int longestConsecutive(int[] nums) {
//         int longest = 0;
        
//         List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
            
//         for(int num : numList) {
//             if (!numList.contains(num - 1)) {
//                 int length = 1;
                
//                 while (numList.contains(num + length)) {
//                     length++;
//                 }
                
//                 longest = Math.max(length, longest);
//             }
//         }
        
//         return longest;
//     }
// }

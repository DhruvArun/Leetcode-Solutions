import java.util.*;

// Valid Algorithm, Within Time Limit - O(n) Time Complexity

class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
 
        int[] t1 = new int[nums.length];
        int[] t2 = new int[nums.length];

        t1[0] = 1;
        t2[nums.length - 1] = 1;

        // scan from left to right
        for(int i = 0; i < nums.length - 1; i++) {
            t1[i+1] = nums[i] * t1[i];
        }

        // scan from right to left
        for(int i = nums.length - 1; i > 0; i--) {
            t2[i-1] = t2[i] * nums[i];
        }

        //multiply
        for(int i=0; i < nums.length; i++) {
            result[i] = t1[i] * t2[i];
        }

        return result;
    }      
}

// Valid Algorithm, Exceeds Time Limit - O(n^2) Time Complexity

// class ProductOfArrayExceptSelf {
//     public int[] productExceptSelf(int[] nums) {
//         List<Integer> result = new ArrayList<>();
        
//         for (int i = 0; i < nums.length; i++) {
//             int prod = 1;
            
//             for (int j = 0; j < nums.length; j++) {
//                 if (j == i) {
//                     continue;
//                 }
//                 else {
//                     prod *= nums[j];
//                 }
//             }
            
//             result.add(prod);
//         }
               
//         int[] res = new int[result.size()];
        
//         for (int k = 0; k < result.size(); k++) {
//             res[k] = result.get(k);
//         }
        
//         return res;
//     }
// }

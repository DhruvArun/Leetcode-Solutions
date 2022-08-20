import java.util.*;
import java.util.stream.*;

class MaximumProductSubarray {
    // Time Complexity - O(n)
    public int maxProduct(int[] nums) {
        List<Integer> temp = (ArrayList<Integer>) Arrays.stream(nums)
            .boxed().collect(Collectors.toList());
        int res = Collections.max(temp);      
        int currMin = 1, currMax = 1;
        
        for (int n : nums) {
            if (n == 0) {
                currMin = 1;
                currMax = 1;
                continue;
            }
            int tmp = currMax * n;
            currMax = Math.max(n , Math.max(tmp, n * currMin));
            currMin = Math.min(n , Math.min(tmp, n * currMin));
            res = Math.max(res, currMax);
        }
        
        return res;
    }
}

// Brute Force Solution - Exceeds Time Limit
// Find Every Subarray
// Find Product of each Subarray
// Return Maximum Product
// Time Complexity - O(n^2)
class AlternateSolution {
    public int maxProduct(int[] nums) {
        ArrayList<List> subarray = new ArrayList<>();  
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                List<Integer> temp = new ArrayList<>();
                for (int k = i; k < j + 1; k++) {
                    temp.add(nums[k]);
                }
                subarray.add(temp);
            } 
        }
        
        int product = Integer.MIN_VALUE;
        for (List lst : subarray) {
            int temp = 1;
            for (Object i : lst) {
                temp *= (int) i;
            }
            if (temp > product) {
                product = temp;
            }
        }
        
        return product;
    }
}
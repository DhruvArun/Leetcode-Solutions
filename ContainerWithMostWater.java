import java. util.*;

// Optimal Solution (O(n)) Time Complexity – Using Two Pointers

class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int result = 0;
        
        int l = 0;
        int r = height.length - 1;
        
        while (l < r) {
            int area = ((r - l) * Math.min(height[l], height[r]));
            result = Math.max(area, result);
            
            if (height[l] >= height[r]) {
                r--;
            }
            // else if (height[l] < height[r]) {
            //     l++;
            // }
            else {
                l++;
            }
        }
        
        return result;
    }
}

// Valid Solution (O(n^2)) Time Complexity – Exceeds Time Limit 

// class ContainerWithMostWater {
//     public int maxArea(int[] height) {
//         int result = 0;
        
//         for (int i = 0; i < height.length; i++) {
//             for (int j = i + 1; j < height.length; j++) {
//                 int area = (j - i) * Math.min(height[i], height[j]);
//                 result = Math.max(result, area);
//             }
//         }
        
//         return result;
//     }
// }

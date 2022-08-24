import java.util.*;

// Two-Pointer Approach - Allows us to Reduce SC from O(n) to O(1)
// Time Complexity - O(n)
// Space Complexity - O(1)
// Key Equation => water[i] = min(maxL, maxR) - height[i];
// Note => if (water[i] < 0) { water[i] = 0; }
class TrappingRainWater {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int maxL = height[l], maxR = height[height.length - 1];
        int res = 0;
        
        // Since we Update maxL or maxR before Adding it to res, 
        // We DON'T need to check if it's Negative (as it  can NEVER be less than 0)
        while (l < r) {
            if (maxL < maxR) {
                l++;
                maxL = Math.max(maxL, height[l]);
                res += maxL - height[l];
            }
            else {
                r--;
                maxR = Math.max(maxR, height[r]);
                res += maxR - height[r];
            }
        }
        
        return res;
    }
}
import java.util.*;

// Brute Force has a Time Complexity - O(n^n)
// Dynamic Programming Approach
// Time Complexity - O(n^3)
// Space Complexity - O(n^2)
// Formula - (nums[l - 1] * nums[i] * nums[r + 1]) + cache[i + 1][r] + cache[l][i - 1]
class BurstBalloons {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] cache = new int[n + 2][n + 2];
        
        int[] arr = new int[n + 2];
        arr[0] = 1;
        for (int i = 1; i <= n; i++) {
            arr[i] = nums[i - 1];
        }
        arr[n + 1] = 1;
        
        return dfs(1, n, arr, cache);
    }
    
    public int dfs(int l, int r, int[] arr, int[][] cache) {
        if (l > r) {
            return 0;
        }
        if (cache[l][r] != 0) {
            return cache[l][r];
        }
        
        cache[l][r] = 0;
        for(int i = l; i < r + 1; i++) {
            int coins = (arr[l - 1] * arr[i] * arr[r + 1]) + dfs(i + 1, r, arr, cache) + dfs(l, i - 1, arr, cache);
            cache[l][r] = Math.max(cache[l][r], coins);
        }
        
        return cache[l][r];
    }
}
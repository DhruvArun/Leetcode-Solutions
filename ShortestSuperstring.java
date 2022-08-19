import java.util.*;

class ShortestSuperstring {
    // Similar to Travelling Salesman Problem
    // 2D-Array cost represents a Graph containing the Time required to Travel between Cities
    // Analogous to Discount when Merging Two Words in this case
    // This is not an exact TSP as we are allowed to visit one node multiple times
    
    // Time Complexity - O((2^n) * (n^2) * m)
    // Space Complexity - O((2^n) * n * m)
    // Time & Space Complexity of Bit Mask is O(2^n)
    // n = Number of Words 
    // m = Length of Longest Word
    public String shortestSuperstring(String[] words) {
        int n = words.length;
        int[][] cost = new int[n][n]; // Discount when Merging Word j to Word i
        
        if (words.length == 1) {
            return words[0];
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < words[i].length() && i != j; k++) {
                    if (words[j].startsWith(words[i].substring(k))){
                        cost[i][j] = (words[i].length() - k);
                        break;
                    }
                }
            }
        }
        
        int[][] dp = new int[1 << n][n];
        int[][] parent = new int[1 << n][n];
        
        for (int mask = 0; mask < (1 << n); mask++) {
            Arrays.fill(parent[mask], -1);
            
            for (int bit = 0; bit < n; bit++) if (((mask >> bit) & 1) > 0) {
                int preMask = mask ^ (1 << bit);

                if (preMask == 0) {
                    continue;
                }

                for (int i = 0; i < n; i++) if (((preMask >> i) & 1) > 0) {
                    int val = dp[preMask][i] + cost[i][bit];

                    if ( val > dp[mask][bit]) {
                        dp[mask][bit] = val;
                        parent[mask][bit] = i;
                    }
                }

            }
        }
        
        int[] perm = new int[n];
        boolean[] visited = new boolean[n];
        int t = 0;
        int end = (1 << n) - 1;
        
        int p = 0;
        for (int j = 0; j < n; j++) {
            if (dp[end][j] > dp[end][p]) {
                p = j;
            }
        }
        
        while (p != -1) {
            perm[t++] = p;
            visited[p] = true;
            int p2 = parent[end][p];
            end ^= (1 << p);
            p = p2;
        }
        
        for (int i = 0; i < t/2; i++) {
            int v = perm[i];
            perm[i] = perm[t - 1 - i];
            perm[t - 1 - i] = v;
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                perm[t++] = i;
            }
        }
        
        StringBuilder ans = new StringBuilder(words[perm[0]]);
        for (int i = 1; i < n; i++) {
            int overlap = cost[perm[i - 1]][perm[i]];
            ans.append(words[perm[i]].substring(overlap));
        }

        return ans.toString();
    }
}
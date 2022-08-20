import java.util.*;

class DecodeWays {
    // Time & Space Complexity - O(n)
    public int numDecodings(String s) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        dp.put(s.length(), 1);

        return dfs(0, s, dp);
    }
    
    public int dfs(int i, String s, HashMap dp) {
        if (dp.keySet().contains(i)) {
            return (int) dp.get(i);
        } 
        if (s.charAt(i) == '0') {
            return 0;
        }
        
        int res = dfs(i + 1, s, dp);
        if ((i + 1) < s.length() && 
            (s.charAt(i) == '1' || 
            (s.charAt(i) == '2' && (s.charAt(i + 1) - 48) <= 6))) {
            res += dfs(i + 2, s, dp);    
        }
        
        dp.put(i, res);
        return res;
    }
}
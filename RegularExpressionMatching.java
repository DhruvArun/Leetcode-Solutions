import java.util.*;

// Time Complexity - O(n * m)
// n => s.length(), m => p.length()
// Top-Down DP Solution w/ Memoization
class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (!p.contains(".") && !p.contains("*")) {
            return p.equals(s) ? true : false;
        }
        
        HashMap<List<Integer>, Boolean> cache = new HashMap<>();
        return dfs(0, 0, s, p, cache);
    }
    
    public boolean dfs(int i, int j, String s, String p, HashMap<List<Integer>, Boolean> cache) {
        if (cache.containsKey(Arrays.asList(i, j))) {
            return cache.get(Arrays.asList(i, j));
        }
        
        if (i >= s.length() && j >= p.length()) {
            return true;
        }
        if (j >= p.length()) {
            return false;
        }
        
        boolean match = (i < s.length()) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if ((j + 1) < p.length() && p.charAt(j + 1) == '*') {
            cache.put(Arrays.asList(i, j), (dfs(i, j + 2, s, p, cache) || (match && dfs(i + 1, j, s, p, cache))));
            return cache.get(Arrays.asList(i, j));
        }
        if (match) {
            cache.put(Arrays.asList(i, j), dfs(i + 1, j + 1, s, p, cache));
            return cache.get(Arrays.asList(i, j));
        }
        
        cache.put(Arrays.asList(i, j), false);
        return false;
    }
}
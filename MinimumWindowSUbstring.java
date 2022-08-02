import java.util.*;

class MinimumWindowSUbstring {
    public String minWindow(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        
        HashMap<Character, Integer> mapT = new HashMap<>();
        
        for (int k = 0; k < tArr.length; k++) {
            mapT.put(tArr[k], mapT.getOrDefault(tArr[k], 0) + 1);
        }
        
        int matched = 0;
        int start = 0;
        int minLen = sArr.length + 1;
        int subStr = 0;
        
        for (int end = 0; end < sArr.length; end++) {
            char right = sArr[end];
            
            if (mapT.containsKey(right)) {
                mapT.put(right, mapT.get(right) - 1);
                
                if (mapT.get(right) == 0) {
                    matched++;
                }
            }
            
            while (matched == mapT.size()) {
                if (minLen > end - start + 1) {
                    minLen = end - start + 1;
                    subStr = start;
                }
                
                char deleted = sArr[start++];
                
                if (mapT.containsKey(deleted)) {
                    if (mapT.get(deleted) == 0) {
                        matched--;
                    }
                    mapT.put(deleted, mapT.get(deleted) + 1);
                }
            }
        }
        
        return minLen > s.length() ? "" : s.substring(subStr, subStr + minLen);
    }
}

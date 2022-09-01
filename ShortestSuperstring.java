import java.util.*;

class ShortestSuperstring {
    // Time Complexity - O((n^2) * ((2^n) + m))
    // Space Complexity - O(n * ((2^n) + m))
    // Time & Space Complexity of Bit Mask is O(2^n)
    // n = Number of Words 
    // m = Length of Longest Word
    
    // Bit Mask - (int) ((1 << j) | (1 << k))
    // Bit Mask will be the Key of the HashMap
    // j - Position of s1, k - Position of s2
    // Key for the List containing Shortest Superstring - ((1 << words.length) - 1)
    public String shortestSuperstring(String[] words) {
        int l = words.length;
        if (l == 1) {return words[0];}
        
        String[][] cache = new String[l][l];
        Map<Integer, String[]> map = new HashMap<>();
        
        for (int j = 0; j < l; j++) {
            for (int k = 0; k < l; k++) {
                if (j == k) {continue;}
                
                cache[j][k] = getSuffix(words[j], words[k]);
                if (!map.containsKey((1 << j) | (1 << k))) {
                    map.put((1 << j) | (1 << k), new String[l]);
                }
                String[] arr = map.get((1 << j) | (1 << k));
                arr[k] = words[j] + cache[j][k];
            }
        }
        
        for (int n = 3; n <= l; n++) {
            Map<Integer, String[]> next = new HashMap<>();
            
            for (int key : map.keySet()) {
                String[] arr = map.get(key);
                for (int j = 0; j < l; j++) {
                    if (arr[j] == null) {continue;}
                    
                    for (int k = 0; k < l; k++) {
                        if ((key & (1 << k)) != 0) {continue;}
                        
                        if (!next.containsKey(key | (1 << k))) {
                            next.put((int) (key | (1 << k)), new String[l]);
                        }
                        String[] arr2 = next.get(key | (1 << k));
                        if (arr2[k] == null || arr2[k].length() > (arr[j].length() + cache[j][k].length())) {
                            arr2[k] = arr[j] + cache[j][k];
                        }
                    }
                }
            }
            map = next;
        }
        
        String result = null;        
        for (String s : map.get((1 << l) - 1)) {
            if (result == null || s.length() < result.length()) {
                result = s;
            }
        }
        
        return result;
    }
    
    public String getSuffix(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        
        for (int j = Math.max(0, (l1 - l2)); j < l1; j++) {
            if (s1.substring(j).equals(s2.substring(0, (l1 - j)))) {
                return s2.substring((l1 - j));
            }
        }
        
        return s2;
    }
}
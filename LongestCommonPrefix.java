import java.util.*;

class LongestCommonPrefix {
    // Time Complexity - O(n * m)
    // n = Number of Strings in List, m = Length of Shortest String
    // Same Time Complexity as other solution, however, required code is much less
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        
        for (int i = 0; i < strs[0].length(); i++) {
            for (String s : strs) {
                if (i == s.length() ||
                   s.charAt(i) != strs[0].charAt(i)) {
                    return res;
                }
            }
            res += strs[0].charAt(i);
        }
        
        return res;
    }
}

class AlternateSolution {
    // Time Complexity - O(n * m)
    // n = Number of Strings in List, m = Length of Shortest String
    // Valid Solution - Required code is much more
    public String longestCommonPrefix(String[] strs) { 
        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }
        
        int shortestLength = Arrays.stream(strs)
        .mapToInt(String::length)
        .min()
        .getAsInt();
        
        String pre = strs[0];
        
        for (int i = 1; i < strs.length; i++) {
            pre = lcp(strs[i], pre, shortestLength);
        }
                
        return pre;
    }
    
    public String lcp(String s1, String s2, int shortestLength) {
        String res = "";
        
        int len1 = s1.length();
        int len2 = s2.length();
        int i = 0;
        int j = 0;
        int count = 0;
        
        while (i < len1 && j < len2 && count < shortestLength) {
            if (s1.charAt(i) == s2.charAt(j)) {
                res += s1.charAt(i);
                i++;
                j++;
                count++;
            } 
            else {
                return res;
            }
        }
        
        return res;
    }
}
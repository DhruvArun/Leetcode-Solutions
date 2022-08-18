import java.util.*;

class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        
        String res = "";
        int len = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Odd Palindromes
            int l = i;
            int r = i;
            
            while (l >= 0 &&
                   r < s.length() && 
                   s.charAt(l) == s.charAt(r)) {
                if ((r - l + 1) > len) {
                    len = r - l + 1;
                    res = s.substring(l, r + 1);
                }
                
                l--;
                r++;
            }
            
            // Even Palindromes
            l = i;
            r = i + 1;
            
            while (l >= 0 &&
                   r < s.length() && 
                   s.charAt(l) == s.charAt(r)) {
                if ((r - l + 1) > len) {
                    len = r - l + 1;
                    res = s.substring(l, r + 1); 
                }
                
                l--;
                r++;
            }
        }
        
        return res;
    }
}
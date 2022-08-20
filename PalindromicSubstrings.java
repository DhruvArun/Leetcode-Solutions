import java.util.*;

// Optimal Solution using Dynamic Programming - O(n^2) Time Complexity
class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += countPalindrome(s, i, i);
            res += countPalindrome(s, i, i + 1);
        }
        return res;
    }
    
    public int countPalindrome(String s, int l, int r) {
        int count = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count++;
            l--;
            r++;
        }
        return count;
    }
}

// Brute Force Solution - O(n^3) Time Complexity 
class AlternateSolution {
    public int countSubstrings(String s) {
        int count = 0;
        List<String> substr = new ArrayList<>();
        
        for (int l = 1; l <= s.length(); l++) {
            for (int i = 0; i <= s.length() - l; i++) {
                substr.add(s.substring(i, i + l));
            }
        }
        
        for (int i = 0; i < substr.size(); i++) {
            if (palindrome(substr.get(i))) {
                count++;
            }
        }
                
        return count;
    }
    
    public boolean palindrome(String str) {
        StringBuilder sb = new StringBuilder(str);
        return str.equals(sb.reverse().toString()) ? true : false;
    }
}
import java.util.*;

class ImplementstrStr {
    // Knuth-Morris-Pratt (KMP) Algorithm for Optimal Solution
    // Time Complexity - O(m + n)
    // m - Length of haystack String, n - Length of needle String
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        
        int[] lps = new int[needle.length()]; // Longest Prefix Suffix
        Arrays.fill(lps, 0);
        
        int prevLPS = 0;
        int currLPS = 1;
        
        while (currLPS < lps.length) {
            if (needle.charAt(currLPS) == needle.charAt(prevLPS)) {
                lps[currLPS] = prevLPS + 1;
                prevLPS++;
                currLPS++;
            }
            else {
                if (prevLPS == 0) {
                    lps[currLPS] = 0;
                    currLPS++;
                }
                else {
                    prevLPS = lps[prevLPS - 1];
                }
            }
        }
        
        int i = 0; // Pointer for haystack
        int j = 0; // Pointer for needle
        
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            else {
                if (j == 0) {
                    i++;
                }
                else {
                    j = lps[j - 1];
                }
            }
            
            if (j == needle.length()) {
                return i - needle.length();
            }
        }
        
        return -1;
    }
}

class AlternateSolution {
    // Brute Force Approach
    // Time Complexity - O(m * n)
    // m - Length of haystack String, n - Length of needle String
    public int strStr(String haystack, String needle) { 
        if (needle.length() == 0) {
            return 0;
        }
        
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) { 
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        
        return -1;
    }
}
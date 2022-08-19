import java.util.*;

class ShortestCommonSupersequence {
    // Time Complexity = O(str1.length() * str2.length())
    public String shortestCommonSupersequence(String str1, String str2) {
        String result = "";
        String lcs = getLCS(str1, str2);
        int p1 = 0;
        int p2 = 0;
        
        for (char c : lcs.toCharArray()) {
            while (str1.charAt(p1) != c) {
                result += str1.charAt(p1);
                p1++;
            }
            while (str2.charAt(p2) != c) {
                result += str2.charAt(p2);
                p2++;
            }
            result += c;
            p1++;
            p2++;
        }
        
        result += str1.substring(p1) + str2.substring(p2);
        return result;
    }
    
    public String getLCS(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        String[][] dp = new String[len1 + 1][len2 + 1];
        
        for(int i = 0; i <= len1; i++) {
            for(int j = 0; j <= len2; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = "";
                }
                else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j-1] + str1.charAt(i - 1);
                }
                else {
                    dp[i][j] = dp[i][j - 1].length() > dp[i - 1][j].length() ? 
                        dp[i][j - 1] : dp[i - 1][j];
                }
            }
        }
        
        return dp[len1][len2];
    }
}
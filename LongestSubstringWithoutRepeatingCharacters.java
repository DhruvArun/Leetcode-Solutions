import java. util.*;

// O(n) Time Complexity using Sliding Window Approach 

class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
         
        int result = 0;
        
        int l = 0;
       
        char[] sArr = s.toCharArray();
        
        for(int r = 0; r < sArr.length; r++) {
            while (set.contains(sArr[r])) {
                set.remove(sArr[l]);
                l++;
            }
            
            set.add(sArr[r]);
            
            result = Math.max(result, set.size());
        }
        
        return result;
    }
}

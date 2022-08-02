import java.util.*;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        char[] sArr = s.toCharArray();        
        HashMap<Character, Integer> map = new HashMap<>();

        int result = 0;
        
        int l = 0;
        for (int r = 0; r < sArr.length; r++) {
            map.put(sArr[r], map.getOrDefault(sArr[r], 0) + 1);
            
            int max = Collections.max(map.values());
            
            while ((((r-l) + 1) - max) > k) {
                map.put(sArr[l], map.getOrDefault(sArr[l], 0) - 1);
                l++;
            }
            
            result = Math.max(result, (r-l) + 1);   
        }
        
        return result;
    }
}

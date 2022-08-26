import java.util.*;

// Time Complexity - O(Sum(words[i].length()))
class VerifyingAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : order.toCharArray()) {
            map.put(c, order.indexOf(c));
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());
            
            if (w1.length() > w2.length() 
            && w1.substring(0, minLen).
            equals(w2.substring(0, minLen))) {
                return false;
            }
            
            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    if (map.get(w1.charAt(j)) > map.get(w2.charAt(j))) {
                        return false;
                    }
                    break;
                }
            }
        }
        
        return true;
    }
}
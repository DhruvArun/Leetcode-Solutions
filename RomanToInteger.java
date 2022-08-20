import java.util.*;

class RomanToInteger {
    public Map<Character, Integer> roman() {
        return Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);
    }
    
    public int romanToInt(String s) {
        Map<Character, Integer> map = roman();
        int res = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                res -= map.get(s.charAt(i));
            }
            else {
                res += map.get(s.charAt(i));
            }
        }
        
        return res;
    }
}
import java.util.*;

// Topological Sort - Directed Acyclical Graph
// Time Complexity - O(n + c)
// Space Complexity - O(n + c)
// n - Number of Words in Input List
// c - Number of Distinct Characters in Input List
// If we find a Cycle in the Graph, Return ""
// Use Post-Order DFS to get Result in Reversed Order
// Keep track of whether a Node has been Visited
// Keep track of whether a Node is in the Current Path
class AlienDictionary {
    public static String alienOrder(String[] words) {
        HashMap<Character, HashSet<Character>> adj = new HashMap<>();

        for (String w : words) {
            for (char c : w.toCharArray()) {
                adj.put(c, new HashSet<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());

            if (w1.length() > w2.length() 
            && w1.substring(0, minLen).
            equals(w2.substring(0, minLen))) {
                return "";
            }

            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    adj.getOrDefault(w1.charAt(j), new HashSet<>()).
                    add(w2.charAt(j));
                    break;
                }
            }
        }
        
        // False - Visited, True - Visited & In Current Path
        HashMap<Character, Boolean> visit = new HashMap<>();
        ArrayList<Character> res = new ArrayList<>();

        for (char c : adj.keySet()) {
            if (dfs(c, visit, adj, res)) {
                return "";
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char l : res) {
            sb.append(l);
        }

        return sb.reverse().toString();
    }
    
    public static Boolean dfs(Character c, 
    HashMap<Character, Boolean> visit, 
    HashMap<Character, HashSet<Character>> adj,
    ArrayList<Character> res) {
        if (visit.keySet().contains(c)) {
            return (Boolean) visit.get(c);
        }

        visit.put(c, (Boolean) true);

        for (char nei : adj.get(c)) {
            if (dfs(nei, visit, adj, res)) {
                return (Boolean) true;
            }
        }
        
        visit.put(c, (Boolean) false);
        res.add(c);

        return (Boolean) false;
    }
}

// Question can be made more complex by adding the following constraint:
// There may be multiple valid order of letters, return the smallest in normal Lexicographical Order
class Solution {
    public static String alienOrder(String[] words) {
        HashMap<Character, HashSet<Character>> adj = new HashMap<>();

        for (String w : words) {
            for (char c : w.toCharArray()) {
                adj.put(c, new HashSet<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());

            if (w1.length() > w2.length() 
            && w1.substring(0, minLen).
            equals(w2.substring(0, minLen))) {
                return "";
            }

            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    adj.getOrDefault(w1.charAt(j), new HashSet<>()).
                    add(w2.charAt(j));
                    break;
                }
            }
        }

        var keys = adj.keySet();
        ArrayList<Character> keyList = new ArrayList<>(keys);

        var vals = adj.values();
        List<Character> valList = new ArrayList<>();
        for (Set curr : vals) {
            ArrayList<Character> lst = new ArrayList<>(curr);
            for (char val : lst) {
                valList.add(val);
            }
        }

        // False - Visited, True - Visited & In Current Path
        HashMap<Character, Boolean> visit = new HashMap<>();
        ArrayList<Character> res = new ArrayList<>();
        // If Key Returns Empty Set AND Key is not in Value List, it does NOT follow any order
        List<Character> unordered = new ArrayList<>();

        for (char c : adj.keySet()) {
            if (adj.get(c).isEmpty() && !valList.contains(c)) {
                unordered.add(c);
                continue;
            }
            if (dfs(c, visit, adj, res)) {
                return "";
            }
        }

        Collections.sort(unordered);
        StringBuilder sb = new StringBuilder();
        for (char l : res) {
            sb.append(l);
        }

        String order = sb.reverse().toString();
        char[] ordered = order.toCharArray();
        String result = "";
        int pt1 = 0, pt2 = 0;

        while (pt1 < ordered.length && pt2 < unordered.size()) {
            if (ordered[pt1] < unordered.get(pt2)) {
                result += ordered[pt1];
                pt1++;
            }
            else {
                result += unordered.get(pt2);
                pt2++;
            }
        }
        while (pt1 < ordered.length) {
            result += ordered[pt1];
            pt1++;
        }
        while (pt2 < unordered.size()) {
            result += unordered.get(pt2);
            pt2++;
        }

        return result;
    }
    
    public static Boolean dfs(Character c, 
    HashMap<Character, Boolean> visit, 
    HashMap<Character, HashSet<Character>> adj,
    ArrayList<Character> res) {
        if (visit.keySet().contains(c)) {
            return (Boolean) visit.get(c);
        }

        visit.put(c, (Boolean) true);

        for (char nei : adj.get(c)) {
            if (dfs(nei, visit, adj, res)) {
                return (Boolean) true;
            }
        }
        
        visit.put(c, (Boolean) false);
        res.add(c);

        return (Boolean) false;
    }
}
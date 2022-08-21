import java.util.*;

class StreamOfCharacters {
    class Trie {
        boolean isWord;
        Trie[] children = new Trie[26];
    }

    Trie root = new Trie();
    StringBuilder sb = new StringBuilder();

    public StreamOfCharacters(String[] words) {        
        for (String word : words) {
            insert(word);
        }
    }

    public boolean query(char letter) {
        sb.append(letter);
        Trie node = root;
        
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            node = node.children[c - 'a'];
            if (node != null && node.isWord) {
                return true;
            }
            else if (node == null) {
                return false;
            }
        }
        
        return false;
    }

    private void insert(String s) {
            Trie node = root;

            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new Trie();
                }
                node = node.children[c - 'a'];
            }
        
            node.isWord = true;
    } 
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
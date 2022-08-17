import java.util.*;

class Trie {
    boolean isWord;
    Trie[] children;
    
    public Trie() {
        isWord = false;
        children = new Trie[26];
    }
    
    public void insert(String word, Trie root) {
        Trie curr = root;
        
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Trie();  
            }
            
            curr = curr.children[c - 'a'];
        }
        
        curr.isWord = true;
    }
    
    public boolean search(String word, Trie root) {
        Trie curr = root;
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            if (c == '.') {
                for (Trie child : curr.children) {
                    if (child != null &&
                       search(word.substring(i + 1, word.length()), child)) {
                        return true;
                    }
                }
                
                return false;
            }
            
            curr = curr.children[c - 'a'];
            
            if (curr == null) {
                return false;
            }
        }
        
        return curr.isWord;
    }
}

class AddAndSearchWordDataStructure {
    Trie root;
    
    public AddAndSearchWordDataStructure() {
        root = new Trie();
    }
    
    public void addWord(String word) {
        root.insert(word, root);
    }
    
    public boolean search(String word) {
        return root.search(word, root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
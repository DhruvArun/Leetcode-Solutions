import java.util.*;

class Trie {
    String word;
    Map<Character, Trie> children;

    public Trie() {
        children = new HashMap<>();
    }

    public void insert(Trie root, String word) {
        int length = word.length();

        for (int i = 0; i < length; i ++) {
            char current = word.charAt(i);

            if (root.children.containsKey(current)){
                root = root.children.get(current);
            } 
            else {
                Trie temp = new Trie();
                root.children.put(current, temp);
                root = temp;
            }
        }

        root.word = word;
    }   
}

class WordSearchII {
    // Time Complexity = O(m * n * O(dfs))
    // O(dfs) = 4^(m*n)
    // Therefore, Time Complexity = O((m * n * 4^(m*n))
    // Backtracking Trie (Prefix Tree)
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        Trie root = new Trie();
        
        for (String word : words) {
            root.insert(root, word);
        }
        
        int rows = board.length;
        int cols = board[0].length;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (root.children.containsKey(board[r][c])) {
                    dfs(board, r, c, result, root);
                }
            }
        }
        
        return result;
    }
    
    public void dfs(char[][] board,
                    int row, 
                    int col, 
                    List<String> result,  
                    Trie root) {
        char currentChar = board[row][col];
        Trie currentNode = root.children.get(currentChar);
        
        if (currentNode.word != null) {
            result.add(currentNode.word);
            currentNode.word = null;
        }
        
        // Marking the current letter before the starting dfs: Similar to visited node
        board[row][col] = '*';

        int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if ((newRow < 0) || 
                (newCol < 0) || 
                (newRow >= board.length) || 
                (newCol >= board[0].length)) {
                continue;
            }
            
            if (currentNode.children.containsKey(board[newRow][newCol])){
                dfs(board, newRow, newCol, result, currentNode);
            }
        }
        
        // Restore the original letter in the board after dfs: Similar to removing from visited node
        board[row][col] = currentChar;
        
        if (currentNode.children.isEmpty()){
            root.children.remove(currentChar);
        }
    }
}

// Valid Solution (Exceeds Time Limit)
class Solution {
    // Time Complexity = O(words.length * m * n * O(dfs))
    // O(dfs) = 4^(word.length())
    // Therefore, Time Complexity = O((words.length * m * n * 4^N), where N = word.length()
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (exist(board, word)) {
                result.add(word);
            }
        }
        
        return result;
    }
    
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        
        HashSet<ArrayList<Integer>> path = new HashSet<ArrayList<Integer>>();
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(board, word, 0, r, c, path)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean dfs(char[][] board, String word, int i, int row, int col, HashSet path) {
        if (i == word.length()) {
            return true;
        }
        
        if (row < 0 || 
            col < 0 || 
            row >= board.length || 
            col >= board[0].length || 
            word.charAt(i) != board[row][col] || 
            path.contains(Arrays.asList(row, col))) {
            return false;
        }
        
        path.add(Arrays.asList(row, col));
        
        boolean result = (dfs(board, word, i + 1, row + 1, col, path) ||
                          dfs(board, word, i + 1, row - 1, col, path) ||
                          dfs(board, word, i + 1, row, col + 1, path) ||
                          dfs(board, word, i + 1, row, col - 1, path));
        
        path.remove(Arrays.asList(row, col));
        
        return result;
    }
}
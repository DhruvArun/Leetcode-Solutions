import java.util.*;

class WordSearch {
   // Time Complexity = O(m * n * O(dfs))
    // O(dfs) = 4^(word.length())
    // Therefore, Time Complexity = O(m * n * 4^N), where N = word.length()
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

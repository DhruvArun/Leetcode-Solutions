import java.util.*;

class NQueensII {
    public int result = 0;
    
    // Time Complexity - O(n * (n ^ n))
    public int totalNQueens(int n) {
        HashSet<Integer> col = new HashSet<>();
        HashSet<Integer> posDiag = new HashSet<>(); // (r + c)
        HashSet<Integer> negDiag = new HashSet<>(); // (r - c)
        
        backtrack(0, col, posDiag, negDiag, n);
        
        return result;
    }
    
    public void backtrack(int row, 
                          HashSet col, 
                          HashSet posDiag, 
                          HashSet negDiag,
                          int n) {
        if (row == n) {
            result += 1;
            return;
        }

        for (int c = 0; c < n; c++) {
            if (col.contains(c) || 
                posDiag.contains(row + c) || 
                negDiag.contains(row - c)) {
                continue;
            }

            col.add(c);
            posDiag.add(row + c);
            negDiag.add(row - c);

            backtrack(row + 1, col, posDiag, negDiag, n);

            col.remove(c);
            posDiag.remove(row + c);
            negDiag.remove(row - c);
        }
    }
}

// Valid Solution – Not the easiest way to do it as it requires us to first implement N-Queens I

class Solution {
    // This is just an implementation of N-Queens I
    // Return the size of the result list created in N-Queens I
    public int totalNQueens(int n) {
        List<List<String>> result = solveNQueens(n);
        
        return result.size();
    }
    
    // One queen per row
    // One queen per column
    // One queen per positive diagonal
    // One queen per negative diagonal
    public List<List<String>> solveNQueens(int n) {
        HashSet<Integer> col = new HashSet<>();
        // Define each positive diagonal as the value of (r + c) at that position
        // This remains constant along any positive diagonal
        HashSet<Integer> posDiag = new HashSet<>();
        // Define each negative diagonal as the value of (r - c) at that position
        // This remains constant along any negative diagonal
        HashSet<Integer> negDiag = new HashSet<>();
        
        List<List<String>> result = new ArrayList<>();
        String[][] board = new String[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ".";
            }
        }
        
        backtrack(0, col, posDiag, negDiag, result, n, board);
        
        return result;
    }
    
    public void backtrack(int row, 
                          HashSet col, 
                          HashSet posDiag, 
                          HashSet negDiag, 
                          List result, 
                          int n, 
                          String[][] board) {
        if (row == n) {
            String[][] copy = board;
            List<String> currRes = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                String temp = "";
                for (int j = 0; j < n; j++) {
                    temp += copy[i][j];
                }
                
                currRes.add(temp);
            }
            
            result.add(currRes);
            return;
        }
        
        for (int c = 0; c < n; c++) {
            if (col.contains(c) || 
                posDiag.contains(row + c) || 
                negDiag.contains(row - c)) {
                continue;
            }
            
            col.add(c);
            posDiag.add(row + c);
            negDiag.add(row - c);
            
            board[row][c] = "Q";
            
            backtrack(row + 1, col, posDiag, negDiag, result, n, board);
            
            col.remove(c);
            posDiag.remove(row + c);
            negDiag.remove(row - c);
            
            board[row][c] = ".";
        }
    }
}
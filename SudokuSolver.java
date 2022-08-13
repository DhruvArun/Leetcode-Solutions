import java.util.*;

class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board); 
     }
     
     public boolean solve(char[][] board) {    
         for (int row = 0; row < 9; row++) {
             for (int col = 0; col < 9; col++) {
                 if (board[row][col] == '.') {
                     for (char i = '1'; i <= '9'; i++) {
                         if (isValid(board, i, row, col)) {
                             board[row][col] = i;
                             if(solve(board)) {
                                 return true;
                             }
                             else {
                                 board[row][col]='.';
                             }
                         }
                     }
                     return false;
                 }   
             }
         }        
         return true;
     }
     
     public boolean isValid(char[][] board, int n, int row, int col){
         for (int i = 0; i < 9; i++) {
           if (board[i][col] == n){
               return false;
           }
           if (board[row][i] ==n) {
               return false;
           }
           if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == n) {
               return false;
           }
         }
         return true;
     }
}

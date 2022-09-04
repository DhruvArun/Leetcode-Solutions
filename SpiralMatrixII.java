import java.util.*;

class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int rowB = 0;
        int rowE = n - 1;
        int colB = 0;
        int colE = n - 1;
        int count = 1;
        
        while (rowB <= rowE && colB <= colE) {
            for (int i = colB; i <= colE; i++) {
                matrix[rowB][i] = count++;
            }
            
            rowB++;
            
            for (int i = rowB; i <= rowE; i++) {
                matrix[i][colE] = count++;
            }
            
            colE--;
            
            if (rowB <= rowE) {
                for (int i = colE; i >= colB; i--) {
                    matrix[rowE][i] = count++;
                }
            }
            
            rowE--;
            
            if (colB <= colE) {
                for (int i = rowE; i >= rowB; i--) {
                    matrix[i][colB] = count++;
                }
            }
            
            colB++;
        }
        
        return matrix;
    }
}
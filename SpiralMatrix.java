import java.util.*;

class SpiralMatrix  {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int left = 0;
        int right = n;
        
        int top = 0;
        int bottom = m;
        
        while ((left < right) && (top < bottom)) {
            for (int i = left; i < right; i++) {
                result.add(matrix[top][i]);
            }
            
            top++;
            
            for (int j = top; j < bottom; j++) {
                result.add(matrix[j][right - 1]);
            }
            
            right--;
            
            if (!((left < right) && (top < bottom))) {
                break;
            }
            
            for (int k = right - 1; k > left - 1; k--) {
                result.add(matrix[bottom - 1][k]);
            }
            
            bottom--;
            
            for (int l = bottom - 1; l > top - 1; l--) {
                result.add(matrix[l][left]);
            }
            
            left++;    
        }
        
        return result;
    }
}

import java.util.*;

// Time Complexity - O(n^2)
class NumberOfSubmatricesThatSumToTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int result = 0;
        
        for (int i = 0; i < row; i++) {
            int[] curr = matrix[i];
            for (int j = 1; j < curr.length; j++) {
                curr[j] += curr[j - 1];
            }
            matrix[i] = curr;
        }
        
        for (int start = 0; start < col; start++) {
            for (int end = start; end < col; end++) {
                HashMap<Integer, Integer> lookup = new HashMap<>();
                lookup.put(0, 1);
                int cumulative = 0;
                
                for (int k = 0; k < row; k++) {
                    cumulative += matrix[k][end] - (start != 0 ? matrix[k][start - 1] : 0);
                    result += lookup.getOrDefault((cumulative - target), 0);
                    lookup.put(cumulative, lookup.getOrDefault(cumulative, 0) + 1);
                }
            }
        }
        
        return result;
    }
}
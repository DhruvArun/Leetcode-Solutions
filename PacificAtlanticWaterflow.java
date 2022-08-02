import java.util.*;

class PacificAtlanticWaterflow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        
        Set<Integer> atl = new HashSet<>();
        Set<Integer> pac = new HashSet<>();
        
        for (int i = 0; i < cols; i++) {
            dfs(0, i, pac, heights[0][i], heights);
            dfs(rows - 1, i, atl, heights[rows - 1][i], heights);
        }
        
        for (int i = 0; i < rows; i++) {
            dfs(i, 0, pac, heights[i][0], heights);
            dfs(i, cols - 1, atl, heights[i][cols - 1], heights);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                List<Integer> temp = new ArrayList<>(Arrays.asList(i, j));
                
                if (pac.contains(temp) && atl.contains(temp)) {
                    res.add(temp);
                }
            }
        }
        
        return res;
    }
    
    public void dfs(int row, int col, Set visit, int prevHeight, int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        
        List<Integer> temp = new ArrayList<>(Arrays.asList(row, col));
        
        if (visit.contains(temp) || row < 0 || col < 0 || row == rows || col == cols || heights[row][col] < prevHeight) {
            return;
        }

        visit.add(temp);
        dfs(row + 1, col, visit, heights[row][col], heights);
        dfs(row - 1, col, visit, heights[row][col], heights);
        dfs(row, col + 1, visit, heights[row][col], heights);
        dfs(row, col - 1, visit, heights[row][col], heights);
    }
}

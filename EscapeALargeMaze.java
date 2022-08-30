import java.util.*;

// Can't use O(n^2) 2D Matrix Traversal as it will Exceed Time Limit since Maze is very Large
// There are AT MOST 200 Blocked Positions
// Therefore, if Manhattan Distance between Source & Target is > 200,
// There HAS to be a path from Source to Target
class EscapeALargeMaze {
    public int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // Down, Up, Right, Left
    
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> block = new HashSet<>();
        for (int[] b : blocked) {
            block.add(b[0] + " - " + b[1]);
        }
        
        return dfs(source, target, source, block, new HashSet()) && 
            dfs(target, source, target, block, new HashSet());
    }
    
    public boolean dfs(int[] source, int[] target, int[] current, Set<String> block, Set<String> visited) {
        if (current[0] == target[0] && current[1] == target[1]) {
            return true;
        }
        if (Math.abs(source[0] - current[0]) + Math.abs(source[1] - current[1]) > 200) {
            return true;
        }
        
        visited.add(current[0] + " - " + current[1]);
        
        for (int[] d : directions) {
            int r = current[0] + d[0];
            int c = current[1] + d[1];
            
            String temp = r + " - " + c;
            
            if (r >= 0 && r < 1000000 && 
                c >= 0 && c < 1000000 && 
                !block.contains(temp) && 
                !visited.contains(temp)) {
                if (dfs(source, target, new int[] {r, c}, block, visited)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
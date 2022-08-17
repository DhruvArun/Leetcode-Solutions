import java.util.*;

class SwimInRisingWater {
    // Djikstra's Algorithm
    // Time Complexity: O((n^2) * log(n))
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int result = 0;
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> 
                                                             grid[a / n][a % n] - grid[b / n][b % n]);
        minHeap.add(0); 
        boolean[][] visit = new boolean[n][n];
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (minHeap.size() > 0) {
            int pos = minHeap.poll();
            int r = pos / n;
            int c = pos % n;
            
            result = Math.max(result, grid[r][c]);
            
            if (r == n - 1 && c == n - 1) {
                return result;
            }
            
            for (int i = 0; i < 4; i++) {
                int dr = directions[i][0];
                int dc = directions[i][1];
                
                int neiR = r + dr;
                int neiC = c + dc;
                
                if (neiR < 0 || neiC < 0 || 
                    neiR >= n || neiC >= n || 
                    visit[neiR][neiC] == true) {
                    continue;
                }
                
                visit[neiR][neiC] = true;
                minHeap.add((neiR * n) + neiC);
            }
        }
        
        return -1;
    }
}
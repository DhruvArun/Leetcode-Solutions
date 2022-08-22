import java.util.*;

class CrackingTheSafe {
    public String crackSafe(int n, int k) {
        int target = (int) Math.pow(k, n);
        boolean[] visited = new boolean[(int) Math.pow(10, n)];
        visited[0] = true;
        int numVisited = 1;
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('0');
        }
        
        dfs(n, k, sb, 0, visited, numVisited, target);      
        return res;
    }
    
    String res;
    
    public void dfs(int n, int k, StringBuilder sb, int prev, boolean[] visited, int numVisited, int target) {
        if (res != null) {
            return;
        }
        if (numVisited == target) {
            res = sb.toString();
            return;
        }
        
        int root = (10 * prev) % ((int) Math.pow(10, n));
        for (int i = 0; i < k; i++) {
            int current = root + i;
            
            if (!visited[current]) {                
                sb.append(i);
                visited[current] = true;
                
                dfs(n, k, sb, current, visited, numVisited + 1, target);
                
                sb.setLength(sb.length() - 1);
                visited[current] = false;
            }
        }
    }
}
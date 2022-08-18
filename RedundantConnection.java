import java.util.*;

class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        
        for (int i = 0; i < size; i++)
            parent[i] = i;
    }
    
    private int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        
        return parent[node];
    }
    
    public boolean union(int node1, int node2) {
        int node1Parent = find(node1);
        int node2Parent = find(node2);
        
        if (node1Parent == node2Parent) {
            return false;
        }
        
        if (rank[node1Parent] > rank[node2Parent]) {
            parent[node2Parent] = node1Parent;
        }
        else if (rank[node1Parent] < rank[node2Parent]) {
            parent[node1Parent] = node2Parent;
        }
        else {
            parent[node2Parent] = node1Parent;
            rank[node1Parent] += 1;
        }
        
        return true;
    }
}

class RedundantConnection  {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];
        Arrays.fill(rank, 1);
        UnionFind unionFind = new UnionFind(n + 1);
        
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < edges.length; i++) {
            int n1 = edges[i][0];
            int n2 = edges[i][1];
            
            if (!unionFind.union(n1, n2)) {
                return edges[i];
            }
        }
        
        return new int[]{-1};
    }
}
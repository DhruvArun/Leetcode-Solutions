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
    
    public int find(int node) {
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

class NumberOfConnectedComponentsInUndirectedGraph {
    public static int countComponents(int n, int[][] edges) {
        int res = n;
        UnionFind unionFind = new UnionFind(n);

        for (int[] edge : edges) {
            int n1 = edge[0];
            int n2 = edge[1];

            if (unionFind.union(n1, n2)) {
                res--;
            }
        }

        return res;
    }
}
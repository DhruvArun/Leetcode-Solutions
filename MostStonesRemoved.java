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

class MostStonesRemoved {
    // moves = movesComponent1 + movesComponent2 + ... + movesComponentN
    // moves = (stonesComponest1 - 1) + (stonesComponest2 - 1) + ... + (stonesComponestN - 1)
    // moves = (stonesComponent1 + stonesComponent2 + ... + stonesComponentN) - (1 + 1 + ... + N)
    // moves = numStones - numComponents
    // All we need to find is the Number of Connected Components (Number of Groups)
    public int removeStones(int[][] stones) {
        int numStones = stones.length;
        int numComponents = stones.length;
        
        UnionFind unionFind = new UnionFind(stones.length);
        
        for (int i = 0; i < stones.length; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                int[] stone1 = stones[i];
                int[] stone2 = stones[j];
                if (stone1[0] == stone2[0] || stone1[1] == stone2[1]) {
                    if (unionFind.union(i, j)) {
                        numComponents--;
                    }
                }
            }
        }
        
        return (numStones - numComponents);
    }
}

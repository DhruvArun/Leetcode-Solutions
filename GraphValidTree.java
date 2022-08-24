import java.util.*;

// If there is a Cycle in the Graph, it is NOT a Tree
// All Nodes must also be Connected for it to be a Tree
// No Cycles + All Nodes Connected = Valid Tree
// Time Complexity - O(E + V)
// Space Complexity - O(E + V)
// E- Number of Edges, V - Number of Vertices
class GraphValidTree {
    public Map<Integer, List<Integer>> adj = new HashMap<>();

    public boolean validTree(int n, int[][] edges) {
        if (n == 0 || n == 1) {
            return true;
        }
        if (edges.length == 0) {
            return false;
        }

        HashSet<Integer> visit = new HashSet<>();
        for (var edge : edges) {
            var node1 = edge[0];
            var node2 = edge[1];

            adj.putIfAbsent(node1, new ArrayList<>());
            adj.putIfAbsent(node2, new ArrayList<>());
            adj.get(node1).add(node2);
            adj.get(node2).add(node1);
        }

        return dfs(0, -1, visit) && (n == visit.size());
    }

    public boolean dfs (int i, int prev, HashSet visit) {
        if (visit.contains(i)) {
            return false;
        }
        visit.add(i);

        for (var j : adj.get(i)) {
            if (j == prev) {
                continue;
            }
            if (!dfs(j, i, visit)) {
                return false;
            }
        }

        return true;
    }
}
import java.util.*;

class NetworkDelayTime {
    // Dijktstra's Algorithm
    // E = V^2, E = Number of Edges, V = Number of Vertices / Nodes
    // Time Complexity = O(E*log(V^2)) = O(E*2*log(V)) = O(E*log(V))
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, ArrayList<ArrayList<Integer>>> edges = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
        
        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            
            if (edges.keySet().contains(u)){
                edges.get(u).add(new ArrayList(Arrays.asList(v, w)));
            }
            else {
                edges.put(u, new ArrayList());
                edges.get(u).add(new ArrayList(Arrays.asList(v, w)));
            }
        }
        
        Set<Integer> visit = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.add(new int[]{k, 0});
        int result = 0;
        
        while (minHeap.size() > 0) {
            int[] currItem = minHeap.poll();
            int currNode = currItem[0];
            int currWeight = currItem[1];
            
            if (visit.contains(currNode)) {
                continue;
            }
            
            visit.add(currNode);
            result = Math.max(result, currWeight);
            
            ArrayList<ArrayList<Integer>> neighbors = edges.getOrDefault(currNode, new ArrayList());
            
            if (!neighbors.isEmpty()) {
                for (int i = 0; i < neighbors.size(); i++) {
                    ArrayList<Integer> curr = neighbors.get(i);
                    int nodeNeighbor = curr.get(0);
                    int neighborWeight = curr.get(1);
                    
                    if (!visit.contains(nodeNeighbor)) {
                        minHeap.add(new int[]{nodeNeighbor, currWeight + neighborWeight});
                    }
                }
            }
        }
        
        return visit.size() == n ? result : -1;
    }
}

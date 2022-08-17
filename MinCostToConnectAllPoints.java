import java.util.*;

class MinCostToConnectAllPoints {
    // Prim's Algorithm
    // Time Complexity - O((n^2) * log(n))
    public int minCostConnectPoints(int[][] points) {
        if (points.length == 1) {
            return 0;
        }
        
        int result = 0;
        HashMap<Integer, ArrayList<ArrayList<Integer>>> adjacencyList = 
            new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
        
        for (int i = 0; i < points.length; i++) {
            int[] curr = points[i];
            
            for (int j = i + 1; j < points.length; j++) {
                int cost = Math.abs(curr[0] - points[j][0]) + Math.abs(curr[1] - points[j][1]);
                
                if (!adjacencyList.keySet().contains(i)) {
                    adjacencyList.put(i, new ArrayList());
                    adjacencyList.get(i).add(new ArrayList(Arrays.asList(cost, j)));                    
                }
                else {
                    adjacencyList.get(i).add(new ArrayList(Arrays.asList(cost, j)));
                }
                
                if (!adjacencyList.keySet().contains(j)) {
                    adjacencyList.put(j, new ArrayList());
                    adjacencyList.get(j).add(new ArrayList(Arrays.asList(cost, i)));
                    
                }
                else {
                    adjacencyList.get(j).add(new ArrayList(Arrays.asList(cost, i)));
                }             
            }
        }
                
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.add(new int[]{0, 0}); // [cost, point]
        
        while (visited.size() < points.length) {
            int[] currItem = minHeap.poll();
            int currCost = currItem[0];
            int currPos = currItem[1];
            
            if (visited.contains(currPos)) {
                continue;
            }
            
            result += currCost;
            visited.add(currPos);
            
            for (ArrayList<Integer> nei : adjacencyList.get(currPos)) {
                int neiCost = nei.get(0);
                int neiPoint = nei.get(1);
                
                if (!visited.contains(neiPoint)) {
                    minHeap.add(new int[]{neiCost, neiPoint});
                }
            }
        }
        
        return result;
    }
}
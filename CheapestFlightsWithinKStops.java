import java.util.*;

class heapestFlightsWithinKStops{
    // Bellman-Ford Algorithm
    // Time Complexity - O(E * k), E = Number of Edges, k = Maximum Number of Stops  
    // Bellman-Ford can deal with Negative Weights unlike Dijkstra's Algorithm
    // The question gives us a bound k reperesenting the Maximum Number of Nodes we can visit
    // Dijkstra's Algorithm would visit every Node/Vertex
    // This makes it difficult to incorporate the upper bound k
    // This can easily be incorporated into Bellman-Ford's Algortithm
    // Hence, we use Bellman-Ford Algorithm instead of Dijkstar's Algorithm
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int MAX_VALUE = 100000; // Max Price is capped at 10000
        // Therefore, MAX_VALUE of 100000 is effectively Infinity
        int[] prices = new int[n];
        Arrays.fill(prices, MAX_VALUE);
        prices[src] = 0;
        
        for (int i = 0; i < k + 1; i++) {
            int[] tempPrices = prices.clone();
            
            for (int j = 0; j < flights.length; j++) {
                int s = flights[j][0];
                int d = flights[j][1];
                int cost = flights[j][2];
                
                if (prices[s] == MAX_VALUE) {
                    continue;
                }
                
                if (prices[s] + cost < tempPrices[d]) {
                    tempPrices[d] = prices[s] + cost;
                }
            }
            
            prices = tempPrices;
        }
        
        return prices[dst] == MAX_VALUE ? -1 : prices[dst];
    }
}
import java.util.*;

class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        
        PriorityQueue<Integer> min = new PriorityQueue<Integer>(Comparator.comparingInt(i-> capital[i])); 
        PriorityQueue<Integer> max = new PriorityQueue<Integer>(Comparator.comparingInt(i-> -profits[i]));

        for (int i = 0; i < n; i++) {
            min.add(i);
        }

        for (int i = 0; i < k; i++) {
            while (!min.isEmpty() && w >= capital[min.peek()]) {
                // Add all the possible Projects that can be taken up to max heap
                // So that max Profit will be at the Top
                max.add(min.poll());
            }

            if (max.isEmpty()) break;

            // Add the max top element from max heap which will give max Profit
            w += profits[max.poll()];
        }
        
        return w;
    }
}
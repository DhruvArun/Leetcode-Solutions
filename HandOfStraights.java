import java.util.*;

// Time Complexity - O(nlog(n))
// Insertion & Deletion from Priority Queue is an O(log(n)) Operation
class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        // We DON'T sort hand Array, as we use a Min Heap
        // Arrays.sort(hand); 
        
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int h : hand) {
            count.put(h, count.getOrDefault(h, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b); // Min Heap
        for (int k : count.keySet()) {
            pq.add(k);
        }
        
        while (!pq.isEmpty()){
            int first = pq.peek();
            for (int i = first; i < first + groupSize; i++) {
                if (!count.keySet().contains(i)) {
                    return false;
                }
                
                count.put(i, count.get(i) - 1);
                if (count.get(i) == 0) {
                    if (i != pq.peek()) {
                        return false;
                    }
                    pq.poll();
                }
            }
        }
        
        return true;
    }
}
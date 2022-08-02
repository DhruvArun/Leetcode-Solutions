import java.util.*;

class KFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num: nums) {
            Integer key = Integer.valueOf(num);
            // map.put(num, getOrDefault(num, 0) + 1); // Alternate way to create HashMap 
            
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } 
            else {
                map.put(key, 1);
            }
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        
        for (Map.Entry entry:map.entrySet()) {
            pq.add(entry);
        }	
        
        int[] result = new int[k];
        
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().getKey();
        }
        
        return result;
    }
}

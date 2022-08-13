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
        
        // Sorting the Map Keys based on Values (which is its frequency)
        
        LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();

        map.entrySet()
          .stream()
          .sorted(Map.Entry.comparingByValue())
          .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        
        Set<Integer> temp = sortedMap.keySet();
        Integer[] keys = temp.toArray(new Integer[temp.size()]);
        
        int[] result = new int[k];
        
        for(int i = 0; i < k; i++) {
            result[i] = keys[keys.length - 1 - i];
        }
        
        return result;
        
        // Alternative Method
        
//         PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        
//         for (Map.Entry entry : map.entrySet()) {
//             pq.add(entry);
//         }
        
//         int[] result = new int[k];
        
//         for (int i = 0; i < k; i++) {
//             result[i] = pq.poll().getKey();
//         }
        
//         return result;
    }
}
